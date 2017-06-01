package com.figer.tools.pdf.example.pdfbox;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdfparser.PDFStreamParser;
import org.apache.pdfbox.pdfwriter.ContentStreamWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.common.PDStream;

public class ReplaceMessageToPage {
  /**
   * Locate a string in a PDF and replace it with a new string.
   *
   * @param inputFile The PDF to open.
   * @param outputFile The PDF to write to.
   * @param strToFind The string to find in the PDF document.
   * @param message The message to write in the file.
   *
   * @throws IOException If there is an error writing the data.
   */
  public void doIt( String inputFile, String outputFile, String strToFind, String message)
      throws IOException
  {
    // the document
    PDDocument doc = null;
    try
    {
      doc = PDDocument.load(new File(inputFile));
//            PDFTextStripper stripper=new PDFTextStripper("ISO-8859-1");
      PDPageTree pages = doc.getDocumentCatalog().getPages();
      for( PDPage page : pages)
      {
        PDFStreamParser parser = new PDFStreamParser(page);
        parser.parse();
        List tokens = parser.getTokens();
        for( int j=0; j<tokens.size(); j++ )
        {
          Object next = tokens.get( j );
          if( next instanceof Operator)
          {
            Operator op = (Operator)next;
            //Tj and TJ are the two operators that display
            //strings in a PDF
            if( op.getName().equals( "Tj" ) )
            {
              //Tj takes one operator and that is the string
              //to display so lets update that operator
              COSString previous = (COSString)tokens.get( j-1 );
              String string = previous.getString();
              string = string.replaceFirst( strToFind, message );
              System.out.println(string);
              System.out.println(string.getBytes("GBK"));
              previous.setValue(string.getBytes("GBK"));
            }
            else if( op.getName().equals( "TJ" ) )
            {
              COSArray previous = (COSArray)tokens.get( j-1 );
              for( int k=0; k<previous.size(); k++ )
              {
                Object arrElement = previous.getObject( k );
                if( arrElement instanceof COSString )
                {
                  COSString cosString = (COSString)arrElement;
                  String string = cosString.getString();
                  string = string.replaceFirst( strToFind, message );
                  cosString.setValue(string.getBytes("GBK"));
                }
              }
            }
          }
        }
        //now that the tokens are updated we will replace the
        //page content stream.
        PDStream updatedStream = new PDStream(doc);
        OutputStream out = updatedStream.createOutputStream();
        ContentStreamWriter tokenWriter = new ContentStreamWriter(out);
        tokenWriter.writeTokens( tokens );
        page.setContents( updatedStream );
      }
      doc.save( outputFile );
    }
    finally
    {
      if( doc != null )
      {
        doc.close();
      }
    }
  }

  public PDDocument replaceText(String inputFile, String outputFile, String searchString, String replacement) throws IOException {
    PDDocument document = PDDocument.load(new File(inputFile));
    PDPageTree pages = document.getDocumentCatalog().getPages();
    for (PDPage page : pages) {
      PDFStreamParser parser = new PDFStreamParser(page);
      parser.parse();
      List tokens = parser.getTokens();
      for (int j = 0; j < tokens.size(); j++) {
        Object next = tokens.get(j);
        if (next instanceof Operator) {
          Operator op = (Operator) next;
          //Tj and TJ are the two operators that display strings in a PDF
          if (op.getName().equals("Tj")) {
            // Tj takes one operator and that is the string to display so lets update that operator
            COSString previous = (COSString) tokens.get(j - 1);
            String string = previous.getString();
            if(string.equals(searchString)) {
              //string = string.replaceFirst(searchString, replacement);
              previous.setValue(replacement.getBytes("GBK"));
            }
          } else if (op.getName().equals("TJ")) {
            COSArray previous = (COSArray) tokens.get(j - 1);
            for (int k = 0; k < previous.size(); k++) {
              Object arrElement = previous.getObject(k);
              if (arrElement instanceof COSString) {
                COSString cosString = (COSString) arrElement;
                String string = cosString.getString();
                if(string.equals(searchString)) {
                  //string = StringUtils.replaceOnce(string, searchString, replacement);
                  cosString.setValue(replacement.getBytes("GBK"));
                }
              }
            }
          }
        }
      }
      // now that the tokens are updated we will replace the page content stream.
      PDStream updatedStream = new PDStream(document);
      OutputStream out = updatedStream.createOutputStream();
      ContentStreamWriter tokenWriter = new ContentStreamWriter(out);
      tokenWriter.writeTokens(tokens);
      page.setContents(updatedStream);
      out.close();
    }
    document.save(outputFile);
    return document;
  }

  public static void main(String[] args) throws IOException
  {
    ReplaceMessageToPage app = new ReplaceMessageToPage();
    app.replaceText( args[0], args[1], args[2], args[3]);
  }
}
