package com.bucaojit.utils;

import java.util.Random;

public class RandomInt {
	private final static int MAX = 37;
	
	public static void main(String[] args) {
		Random generator = new Random();
		
		System.out.println(generator.nextInt(MAX));
	}
}
