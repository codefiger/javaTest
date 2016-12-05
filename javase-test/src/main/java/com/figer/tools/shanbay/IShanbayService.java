package com.figer.tools.shanbay;

/**
 * Created by figer on 20/11/2016.
 */
public interface IShanbayService {
  void login(String userName, String password);
  /**
   * return wordList id
   */
  String createWordList(String wordBookId, String name, String desc);
  boolean addVocabulary(String vocabulary, String wordListId);
  void createShanbayWordBook(String filePath, String wordBookId, String userName, String password);
}
