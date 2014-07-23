package strings;

import com.bigwavedata.utils.StringUtils;
import com.bigwavedata.utils.UserInput;

// Find all permutations for a given string
public class Permutations {
	
	public static void permutate(String str) {
		if (str.length() == 0) {
			return;
		}
		permutate(str, 0, str.length() - 1);
	}
	private static void permutate(String str, int startIndex, int endIndex) {
		if(startIndex == endIndex) {
			System.out.println (str);
		}
		else {
			for (int j = startIndex ; j <= endIndex; j++) {
				str = StringUtils.swap(str, startIndex, j);
				permutate(str,startIndex + 1, endIndex);
				str = StringUtils.swap(str, startIndex, j);
			}
		}
	}
	public static void main(String[] args) {
		String input = UserInput.getString();
		System.out.println(input);
		Permutations.permutate(input);
	}

}
