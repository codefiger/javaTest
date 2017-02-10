import com.dr.coffee.common.util.JsonUtil;
import com.figer.tools.counter.PdfReader;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.sun.syndication.feed.atom.Person;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Foo {
	private static final int MAX_COUNT = 1000;
	private static int count = 0;
	
	public int bar() throws Exception{
		if (++count >= MAX_COUNT) {
			count = 0;
			throw new Exception("count overflow");
		}
		
		return count;
	}

  public static void main(String[] args) {
    PdfReader pdfReader = new PdfReader("");
    while (pdfReader.hasNext()){
      System.out.print(pdfReader.next());
    }
  }
}
