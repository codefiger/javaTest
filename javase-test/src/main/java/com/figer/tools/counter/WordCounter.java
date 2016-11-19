package com.figer.tools.counter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by figer on 05/11/2016.
 */
public class WordCounter {
  public static void main(String[] args) throws Exception{
    long starTime = System.currentTimeMillis();

    /*BufferedReader reader = new BufferedReader(new FileReader("/Users/figer/Downloads/test-counter.txt"));
    String line;
    while ((line = reader.readLine()) != null) {
      processEnglishContent(line);
    }
    reader.close();

    printCounterMap();*/
    long endTime = System.currentTimeMillis();
    System.out.println("耗时：");
    System.out.println(endTime - starTime+"ms");
  }


  private static final HashSet<String> ignoreWords = new HashSet<String>();
  private  Map<String, Integer> counterMap = new TreeMap<String, Integer>();
  private static final String ignoreWordsConfig [] = {"your","had","I","their","not","ago","him","men","day","eighty","able","only","still","In","man","The","will","you",
  "years","year","whose","what","with","yours","yes","a","an","are","all","any","been","both","each","either","one","two","three","four","five",
  "six","seven","eight","nine","ten","none","little","few","many","much","other","another","some","no","every","nobody","anybody","somebody",
  "everybody","when","where","how","who","there","where","is","was","were","do","did","this","that","in","on","at","as","first","second","third",
  "fourth","fifth","sixth","ninth","above","over","below","under","beside","behind","of","the","after","from","since","for","which","by","next",
  "last","tomorrow","yesterday","before","because","against","except","beyond","along","among","but","so","towards","to","it","me","i","he","she",
  "his","they","them","her","its","and","has","have","my","would","then","too","or","our","off","we","be","into","well","can","having","being",
  "even","us","these","those","if","ours"};

  public WordCounter(){
    for (int i = 0; i < ignoreWordsConfig.length; i++) {
      ignoreWords.add(ignoreWordsConfig[i]);
    }
  }

  public void processEnglishContent(String englishContent){
    //TODO: how to exclude useless words
    Pattern expression = Pattern.compile("[a-zA-Z]{3,}");// 定义正则表达式匹配单词
    Matcher matcher = expression.matcher(englishContent);//
    String word;
    while (matcher.find()) {
      word = matcher.group().toLowerCase();
      if(ignoreWords.contains(word)){
        continue;
      }

      if (counterMap.containsKey(word)) {
        counterMap.put(word, counterMap.get(word) + 1);
      } else {
        counterMap.put(word, 1);
      }
    }
  }

  public void printCounterMap(){
    List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(counterMap.entrySet());
    Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
      public int compare(Map.Entry<String, Integer> left,Map.Entry<String, Integer> right) {
        return -(left.getValue()).compareTo(right.getValue());
      }
    };
    Collections.sort(list, comparator);

    int index = 1;
    for (Map.Entry<String, Integer> entry : list){
      System.out.println(String.format("index %4d : %s - %d", index++, entry.getKey(), entry.getValue()));
    }
  }

  public void printAddShanbayJS(){
    List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(counterMap.entrySet());
    Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
      public int compare(Map.Entry<String, Integer> left,Map.Entry<String, Integer> right) {
        return -(left.getValue()).compareTo(right.getValue());
      }
    };
    Collections.sort(list, comparator);

    System.out.println("function sleep(numberMillis) {\n" +
        "    var now = new Date();\n" +
        "    var exitTime = now.getTime() + numberMillis;\n" +
        "    while (true) {\n" +
        "        now = new Date();\n" +
        "        if (now.getTime() > exitTime)\n" +
        "            return;\n" +
        "    }\n" +
        "}");
    int index = 1;
    for (Map.Entry<String, Integer> entry : list){
        System.out.print("sleep(500);");
        System.out.print(String.format("$(\"#to_add_vocabulary\").val(\"%s\");", entry.getKey()));
        System.out.print("add_vocabulary();");





        if(index++ > 200)
          break;
    }

  }
}
