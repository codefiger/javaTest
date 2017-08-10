
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

  public static void main(String[] args){

    /*PdfReader pdfReader = new PdfReader("");
    while (pdfReader.hasNext()){
      System.out.print(pdfReader.next());
    }*/

    /*long startTime = System.nanoTime();
    printMatrix("# ");
    long firstEndTime = System.nanoTime();
    printMatrix("# ");
    long secondEndTime = System.nanoTime();

    System.out.println("# executed time : " + (firstEndTime - startTime));
    System.out.println("B executed time : " + (secondEndTime - firstEndTime));*/
  }

  private static void printMatrix(String input){
    for (int i = 0; i < 1000; i++) {
      for (int j = 0; j < 1000; j++) {
        System.out.print(input); //only line changed
      }

      System.out.println("");
    }
  }
}
