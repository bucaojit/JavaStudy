package com.bucaojit.utils;


public class StringUtils {
	public static String swap(String str, int a, int b) throws ArrayIndexOutOfBoundsException{
		if(a >= str.length() || b >= str.length()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		char[] tempArray = str.toCharArray();
		char temp = tempArray[a];
		tempArray[a] = tempArray[b];
		tempArray[b] = temp;
		return new String(tempArray);		
	}
}
