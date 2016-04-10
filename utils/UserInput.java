package com.bigwavedata.utils;

import java.util.Scanner;

public class UserInput {
	public static void waitForEnter() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Please hit ENTER to continue...");
		reader.nextLine();
		reader.close();
	}
	public static String getString() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter a string:");
		String retString = reader.next();
		reader.close();
		return retString;
	}
	
	public static int getInt() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter an int:"); 
		int retInt = reader.nextInt();
		reader.close();
		return retInt;
	}
	
	public static String getLine() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter an int:"); 
		String retLine = reader.nextLine();
		reader.close();
		return retLine;
	}
	
}
