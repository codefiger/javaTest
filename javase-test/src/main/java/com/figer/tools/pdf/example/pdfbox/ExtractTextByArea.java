package com.figer.tools.pdf.example.pdfbox;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by figer on 25/05/2017.
 */
public class ExtractTextByArea {
  private ExtractTextByArea()
  {
    //utility class and should not be constructed.
  }


  /**
   * This will print the documents text in a certain area.
   *
   * @param args The command line arguments.
   *
   * @throws IOException If there is an error parsing the document.
   */
  public static void main( String[] args ) throws IOException
  {
    if( args.length != 1 )
    {
      usage();
    }
    else
    {
      try (PDDocument document = PDDocument.load(new File(args[0])))
      {
        PDFTextStripperByArea stripper = new PDFTextStripperByArea();
        stripper.setSortByPosition( true );
        Rectangle rect = new Rectangle( 10, 280, 275, 60 );
        stripper.addRegion( "class1", rect );
        PDPage firstPage = document.getPage(0);
        stripper.extractRegions( firstPage );
        System.out.println( "Text in the area:" + rect );
        System.out.println( stripper.getTextForRegion( "class1" ) );
      }
    }
  }

  /**
   * This will print the usage for this document.
   */
  private static void usage()
  {
    System.err.println( "Usage: java " + ExtractTextByArea.class.getName() + " <input-pdf>" );
  }
}
