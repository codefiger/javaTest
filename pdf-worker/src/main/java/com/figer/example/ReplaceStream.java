package com.figer.example;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PRStream;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class ReplaceStream {
  public static final String SRC = "/Users/figer/Downloads/pdfedit/worker/demo.pdf";
  public static final String DEST = "/Users/figer/Downloads/pdfedit/worker/hello-example-changed.pdf";

  public static void main(String[] args) throws IOException, DocumentException {
    File file = new File(DEST);
    file.getParentFile().mkdirs();
    new ReplaceStream().manipulatePdf(SRC, DEST);
  }

  public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
    PdfReader reader = new PdfReader(src);

    PdfDictionary dict = reader.getPageN(1);
    PdfObject object = dict.getDirectObject(PdfName.CONTENTS);
    if (object instanceof PRStream) {
      PRStream stream = (PRStream)object;
      byte[] data = PdfReader.getStreamBytes(stream);

      String chinese = "中文";
      stream.setData(new String(data).replace("Hello World", chinese).getBytes());
    }
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
    stamper.close();
    reader.close();
  }
}