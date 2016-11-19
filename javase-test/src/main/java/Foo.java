import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.UnsupportedEncodingException;
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
    UUID uuid = UUID.randomUUID();

    System.out.println(uuid.toString());
    String str = "Hello World";
    try{
      System.out.println(uuid);
      String encodeBase64 = Base64.encode(uuid.toString().getBytes("UTF-8"));
      System.out.println("RESULT: " + encodeBase64);
    } catch(UnsupportedEncodingException e){
      e.printStackTrace();
    }
  }
}
