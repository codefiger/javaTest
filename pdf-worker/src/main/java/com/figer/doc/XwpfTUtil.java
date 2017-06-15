package com.figer.doc;
import org.apache.poi.xwpf.usermodel.*;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XwpfTUtil {

    String filePath = "/Users/figer/Downloads/docx.docx";
    InputStream is;
    XWPFDocument doc;
    Map<String, Object> params = new HashMap<String, Object>();

    {
        params.put("${name}", "中文");
        /*params.put("${sex}", "男");
        params.put("${political}", "共青团员");
        params.put("${place}", "sssss");
        params.put("${classes}", "3102");
        params.put("${id}", "213123123");
        params.put("${qq}", "213123");
        params.put("${tel}", "312313213");
        params.put("${oldJob}", "sadasd");
        params.put("${swap}", "是");
        params.put("${first}", "asdasd");
        params.put("${second}", "综合事务部");
        params.put("${award}", "asda");
        params.put("${achievement}", "完成科协网站的开发");
        params.put("${advice}", "没有建议");
        params.put("${attach}", "无");*/

        try {
            is = new FileInputStream(filePath);
            doc = new XWPFDocument(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


  /**
   * 用一个docx文档作为模板，然后替换其中的内容，再写入目标文档中。
   *
   * @throws Exception
   */
    @Test
    public void testTemplateWrite() throws Exception {
        //替换段落里面的变量
        this.replaceInPara(doc, params);
        //替换表格里面的变量
        this.replaceInTable(doc, params);
        OutputStream os = new FileOutputStream("/Users/figer/Downloads/pdfedit/modify.docx");
        doc.write(os);
        this.close(os);
        this.close(is);
    }

    @Test
    public void myTest1() throws Exception {
        Iterator<XWPFParagraph> iterator = doc.getParagraphsIterator();
        XWPFParagraph para;
        while (iterator.hasNext()) {
            para = iterator.next();
            List<XWPFRun> runs = para.getRuns();
            para.removeRun(0);
            para.insertNewRun(0).setText("hello");
        }

        OutputStream os = new FileOutputStream("/Users/figer/Downloads/pdfedit/modify.docx");
        doc.write(os);
        this.close(os);
        this.close(is);

        System.out.println(this.matcher("报告日期：${reportDate}").find());

    }

    @Test
    public void myReplaceInPara() {
//        Iterator<XWPFParagraph> iterator = doc.getParagraphsIterator();
//        XWPFParagraph para;
//        while (iterator.hasNext()) {
//            para = iterator.next();
//            List<XWPFRun> runs = para.getRuns();
//
//
//        }

        System.out.println('{'=='{');

    }

  /**
   * 替换段落里面的变量
   *
   * @param doc    要替换的文档
   * @param params 参数
   */
  public void replaceInPara(XWPFDocument doc, Map<String, Object> params) {
    Iterator<XWPFParagraph> iterator = doc.getParagraphsIterator();
    XWPFParagraph para;
    while (iterator.hasNext()) {
      para = iterator.next();
      this.replaceInPara(para, params);
    }
  }

  /**
   * 替换段落里面的变量
   *
   * @param para   要替换的段落
   * @param params 参数
   */
  public void replaceInPara(XWPFParagraph para, Map<String, Object> params) {
    List<XWPFRun> runs;
    Matcher matcher;
    if (this.matcher(para.getParagraphText()).find()) {
      runs = para.getRuns();

      int start = -1;
      int end = -1;
      String str = "";
      for (int i = 0; i < runs.size(); i++) {
        XWPFRun run = runs.get(i);
        String runText = run.toString();
        System.out.println("------>>>>>>>>>" + runText);
        if ('$' == runText.charAt(0)&&'{' == runText.charAt(1)) {
          start = i;
        }
        if ((start != -1)) {
          str += runText;
        }
        if ('}' == runText.charAt(runText.length() - 1)) {
          if (start != -1) {
            end = i;
            break;
          }
        }
      }
      System.out.println("start--->"+start);
      System.out.println("end--->"+end);

      System.out.println("str---->>>" + str);

      for (int i = start; i <= end; i++) {
        para.removeRun(i);
        i--;
        end--;
        System.out.println("remove i="+i);
      }

      for (String key : params.keySet()) {
        if (str.equals(key)) {
          para.createRun().setText((String) params.get(key));
          break;
        }
      }


    }
  }

  /**
   * 替换表格里面的变量
   *
   * @param doc    要替换的文档
   * @param params 参数
   */
  public void replaceInTable(XWPFDocument doc, Map<String, Object> params) {
    Iterator<XWPFTable> iterator = doc.getTablesIterator();
    XWPFTable table;
    List<XWPFTableRow> rows;
    List<XWPFTableCell> cells;
    List<XWPFParagraph> paras;
    while (iterator.hasNext()) {
      table = iterator.next();
      rows = table.getRows();
      for (XWPFTableRow row : rows) {
        cells = row.getTableCells();
        for (XWPFTableCell cell : cells) {
          paras = cell.getParagraphs();
          for (XWPFParagraph para : paras) {
            this.replaceInPara(para, params);
          }
        }
      }
    }
  }

  /**
   * 正则匹配字符串
   *
   * @param str
   * @return
   */
  private Matcher matcher(String str) {
    Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(str);
    return matcher;
  }

  /**
   * 关闭输入流
   *
   * @param is
   */
  public void close(InputStream is) {
    if (is != null) {
      try {
        is.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * 关闭输出流
   *
   * @param os
   */
  public void close(OutputStream os) {
    if (os != null) {
      try {
        os.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

}