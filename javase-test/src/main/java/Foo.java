
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
}
