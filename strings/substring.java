package strings;

// Write code to implement the strstr (Search for a substring) function. 
// Do not use any system library such as strlen.
public class substring {
	
	public static int strstr(String target, String substr) {
		
		for (int i = 0; i <= target.length() - substr.length(); i ++) {
			if (target.charAt(i) == substr.charAt(0)) {
				int j = 0;
				for(; j < substr.length(); j++) {
					if(target.charAt(i + j) != substr.charAt(j)) 
						break;
				}
				if(j == (substr.length()))
					return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		String string = "This is the full sentence";
		String substr = "sentence";
		System.out.println(string + "\n" + substr);
		System.out.println("This is the location of the substring: " + strstr(string,substr));
	}
}
