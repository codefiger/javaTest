package com.figer.tools.shanbay;

/**
 * Created by figer on 20/11/2016.
 */
public class Data {
  private WordList wordlist;

  public WordList getWordlist() {
    return wordlist;
  }

  public void setWordlist(WordList wordlist) {
    this.wordlist = wordlist;
  }

  @Override
  public String toString() {
    return "Data{" +
        "wordList=" + wordlist +
        '}';
  }
}
