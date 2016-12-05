package com.figer.tools.shanbay;

import com.dr.coffee.common.util.JsonUtil;
import com.figer.tools.counter.PdfReader;
import com.figer.tools.counter.WordCounter;
import com.figer.tools.shanbay.http.HttpClientUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by figer on 19/11/2016.
 */
public class ShanbayApi implements IShanbayService{

  private String baseUrl = "https://www.shanbay.com";
  private String charset = "utf-8";
  private HttpClientUtil httpClientUtil = null;

  public ShanbayApi(){
    httpClientUtil = new HttpClientUtil();
  }

  public void login(String userName, String password){
    String loginUrl = baseUrl + "/accounts/login/";
    Map<String,String> params = new HashMap<>();
    params.put("csrfmiddlewaretoken", "M6AliHp2DAnW0jPn4SQmL1fjjgaQujUc");
    params.put("username", userName);
    params.put("password", password);
    httpClientUtil.doPost(loginUrl, params, charset);
    System.out.println("Login shanbay success!");
  }

  public String createWordList(String wordBookId, String name, String desc){
    Map<String,String> params = new HashMap<>();

    String wordlist = "/api/v1/wordbook/wordlist/";
    params.put("name", name);
    params.put("description", desc);
    params.put("wordbook_id", wordBookId);
    String result = httpClientUtil.doPost(baseUrl + wordlist, params, charset);
    CreateWordListResp wordListResp = JsonUtil.fromJson(result, CreateWordListResp.class);
    String wordListId = wordListResp.getData().getWordlist().getId();
    System.out.println("Created word list " + wordListId + " success!");
    return wordListId;
  }

  public boolean addVocabulary(String vocabulary, String wordListId){
    String url = baseUrl + "/api/v1/wordlist/vocabulary/";
    Map<String,String> params = new HashMap<>();
    params.put("id", wordListId);
    params.put("word", vocabulary);
    String result = httpClientUtil.doPost(url, params, charset);
    CreateWordListResp wordResp = JsonUtil.fromJson(result, CreateWordListResp.class);
    if("0".equals(wordResp.getStatus_code())){
      System.out.println("Created vocabulary " + vocabulary + " success!");
      return true;
    }else {
      System.out.println("Created vocabulary " + vocabulary + " failed!");
      return false;
    }
  }

  /**
   * don't use it
   */
  @Deprecated
  public boolean deleteWordList(String wordListId){
    String wordListUrl = "/api/v1/wordbook/wordlist/" + wordListId;
    String result = httpClientUtil.delete(wordListUrl, charset);
    CreateWordListResp wordResp = JsonUtil.fromJson(result, CreateWordListResp.class);
    if("0".equals(wordResp.getStatus_code())){
      System.out.println("Delete word list " + wordListId + " success!");
      return true;
    }else {
      System.out.println("Created word list " + wordListId + " failed!");
      return false;
    }
  }


  private static final int UNIT_SIZE = 200;
  @Override
  public void createShanbayWordBook(String filePath, String wordBookId, String userName, String password) {
    WordCounter wordCounter = new WordCounter();
    PdfReader pdfReader = new PdfReader(filePath);
    while (pdfReader.hasNext()){
      wordCounter.processEnglishContent(pdfReader.next());
    }

    Map<String, Integer> counterMap = wordCounter.getCounterMap();
    if(counterMap != null && counterMap.size() > 0){
      System.out.println("init word counter success - total:" + counterMap.size());
    }else {
      System.out.println("no word init to counter - stop!");
      return;
    }

    List<Map.Entry<String, Integer>> list = new ArrayList(counterMap.entrySet());
    Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
      public int compare(Map.Entry<String, Integer> left,Map.Entry<String, Integer> right) {
        return -(left.getValue()).compareTo(right.getValue());
      }
    };
    Collections.sort(list, comparator);

    int index = 1;
    ShanbayApi shanbayApi = new ShanbayApi();
    shanbayApi.login(userName, password);
    String wordListId = shanbayApi.createWordList(wordBookId, "unit 0", "Created by figer via Java");
    boolean createdSuccess;
    for (Map.Entry<String, Integer> entry : list){
      try {
        Thread.sleep(2);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      try {
        createdSuccess = shanbayApi.addVocabulary(entry.getKey(), wordListId);
        if(createdSuccess){
          index ++;
        }
      }catch (Exception e){
        e.printStackTrace();
        System.out.println("created word occurred exception, try again!  ");
        createdSuccess = shanbayApi.addVocabulary(entry.getKey(), wordListId);
        if(createdSuccess){
          index ++;
        }
      }

      if(createdSuccess && index %  UNIT_SIZE == 0){
        System.out.println("index:" + index);
        try {
          wordListId = shanbayApi.createWordList(wordBookId, "unit " + index/UNIT_SIZE, "Created by figer via Java");
        }catch (Exception e){
          e.printStackTrace();
          System.out.println("created word list occurred exception, try again!  ");
          wordListId = shanbayApi.createWordList(wordBookId, "unit " + index/UNIT_SIZE, "Created by figer via Java");
        }
      }
    }

    System.out.println(String.format("map counter total %d, created words success %d and failed %d", counterMap.size(),index, counterMap.size() - index));
  }

}
