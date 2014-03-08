package com.bigwavedata.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class arrayGen {
	Trace LOG;
	public arrayGen() {
		LOG = new Trace(this.getClass().toString());
	}
	
	public void swap(List<Integer> list, int indexA, int indexB) {
		LOG.logEntry();
		int temp = list.get(indexA);
		list.set(indexA, list.get(indexB));
		list.set(indexB, temp);
		LOG.logExit();
	}
	
	public List<Integer> generate(int size) {
		LOG.logEntry();
		// Create list
		List<Integer> list = new ArrayList<Integer>(size);
		for (int i = 0; i < size; i++) {
			list.add(i);
		}
		
		// Fisher-Yates shuffle
		for (int j = size-1; j >= 0; j--) {
			// swap the values
			Random rand = new Random();
			Integer swapIndex = rand.nextInt(size-1);
			//LOG.logTrace(swapIndex.toString());
			swap(list, j, swapIndex);			
		}
		LOG.logDebug(list.toString());
		LOG.logExit();
		return list;
	}
}
