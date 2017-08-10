package com.figer.doc;

import com.documents4j.api.DocumentType;
import com.documents4j.api.IConverter;
import com.documents4j.job.LocalConverter;

import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by figer on 16/06/2017.
 */
public class DocumentConversion {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    String filePath = "/Users/figer/Downloads/pdfedit/";
    String to = "/Users/figer/Downloads/pdfedit/modify.pdf";
    File wordFile = new File(filePath + "modify.docx"), target = new File(to);
    IConverter converter = LocalConverter.builder().
        baseFolder(new File(filePath)).
        workerPool(20, 25, 2, TimeUnit.SECONDS).
        processTimeout(5, TimeUnit.SECONDS).
        build();
    Future<Boolean> conversion = converter
        .convert(wordFile).as(DocumentType.MS_WORD)
        .to(target).as(DocumentType.PDF)
        .prioritizeWith(1000) // optional
        .schedule();
    /*boolean success = conversion.get();
    System.out.println("result:" + success);*/
  }
}
