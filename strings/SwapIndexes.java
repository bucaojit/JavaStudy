package strings;

import java.io.IOException;

public class SwapIndexes {
	
	public static String swap(String s, int a, int b) throws IOException{
		// validate input
		if(a > s.length() || b > s.length())
			throw new IOException("String length is less than index");
		
		char[] array = s.toCharArray();
		
		char temp = array[a];
		array[a] = array[b];
		array[b] = temp;
		
		return new String(array);	
	}
	
	public static void modifyParm(String s) {
		// didn't work 
		//s = new String ("is this new");
		
		s = s + " another";
		System.out.println("in method: " + s);
	}
	
	public static void modifySB(StringBuilder sb) {
		sb.append(" Appending more");
	}
	
	public static void intImm(Integer[] i) {
		i[0] = 66;
		i[1] = 555;
	}
	
	public static void main(String[] args) {
		int a = 2;
		int b = 7;
		
		String str = new String("stringtoswap");
		System.out.println("Original: " + str);
		
		System.out.println("Swapping indexes: " + a + " and " + b);
		try {
			System.out.println(SwapIndexes.swap(str, a, b));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		String mystr = new String ("original string");
		System.out.println(mystr);
		SwapIndexes.modifyParm(mystr);
		
		System.out.println(mystr);
		
		StringBuilder mysb = new StringBuilder("initial value");
		System.out.println("sb before: " + mysb);
		SwapIndexes.modifySB(mysb);
		System.out.println("sb after: " + mysb);
		
		Integer[] myint = null;
		myint = new Integer[]{55, 55};
		System.out.println("Int: " + myint[0]);
		SwapIndexes.intImm(myint);
		System.out.println("Int: " + myint[0]);
		System.out.println("Int: " + myint[1]);
		
	}
}
