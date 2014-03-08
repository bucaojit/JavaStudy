package com.bigwavedata.utils;

import java.util.ArrayList;
import java.util.Iterator;

// Skeleton for writing custom iterator

public class iterator <E> implements Iterator<E> {
	private ArrayList<E> list;
	private int position;
	
	public iterator() {
		
	}

	public boolean hasNext() {
		return true;
	}
	
	public E next() {
		E returnVal = null;
		return returnVal;
	}
	
	public void remove() {
		
	}
}
