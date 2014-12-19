package leetcode.onlinejudge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Author: Oliver

/*
 *   Solution for HackerRank question:
 *   You are given a string of lowercase letters. 
 *   Your task is to figure out the index of the character on whose 
 *   removal will make the string a palindrome. 
 *   
 *   There will always be a valid solution. 
 *   
 *   In case string is already palindrome, 
 *   then -1 is also a valid answer along with possible indices.
 */
public class PalindromeRemove {
	
	
	public void palindInt(List<String> stringArray) {
		
		for(String input : stringArray) {
			boolean isPalindrome = true;
			for(int i=0, j = input.length()-1; i<j; i++,j--) {
				if(input.charAt(i) != input.charAt(j)) {
					// not matching, non-matching indexes are i,j
					isPalindrome = false;
					if(isPal(remChar(input,i)))
						System.out.println(i);
					else 
						System.out.println(j);
				}
				if(isPalindrome) 
					System.out.println(-1);
			}
		}
	}
	
	public boolean isPal(String word) {
		for(int i = 0, j = word.length()-1; i<j; i++,j--) {
			if(word.charAt(i) != word.charAt(j))
				return false;
		}
		return true;
	}
	
	public String remChar(String word, int index) {
		StringBuilder sb = new StringBuilder(word);
		sb.deleteCharAt(index);
		return sb.toString();		
	}
	
	static public List<String> getStringInputs() {
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();
		scan.nextLine();
		ArrayList<String> retArray = new ArrayList<String>();
		for(int i = 0; i < count; i++) {
			retArray.add(scan.nextLine());
		}
		scan.close();
		return retArray;
	}
	
	public static void main(String[] args) {
		PalindromeRemove pr = new PalindromeRemove();
		pr.palindInt(PalindromeRemove.getStringInputs());
	}
}
