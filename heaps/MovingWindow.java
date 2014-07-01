package heaps;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * A long array A[] is given to you. 
 * There is a sliding window of size w which is moving from 
 * the very left of the array to the very right. 
 * You can only see the w numbers in the window. 
 * Each time the sliding window moves rightwards by one position. 
 * Following is an example:
 *      The array is [1 3 -1 -3 5 3 6 7], and w is 3.
 */



public class MovingWindow {
	final int ARRAY_LENGTH = 8;
	final int WINDOW_SIZE  = 3;
	// Can use pair AbstractMap.SimpleImmutableEntry<K,V>
	
	public class pairComparator implements 
	    Comparator<AbstractMap.SimpleImmutableEntry<Integer, Integer>> {
		@Override
		public int compare(AbstractMap.SimpleImmutableEntry<Integer, Integer> a,
		                   AbstractMap.SimpleImmutableEntry<Integer, Integer> b) {
			return 0;
		}
	}
	
	// Use arrayGen to generate the random unique-entry array
	public void integerArrayToPair(List<Integer> inputArray, 
								   List<AbstractMap.SimpleImmutableEntry
								   <Integer, Integer>> outputArray) {
		
	}
	
	
	public void movingWindowSolve(List<Integer> inputArray,
								  Integer sizeOfWindow,
								  List<Integer> outputArray) {
		// Length of outputArray will be inputArray.size() - (sizeOfWindow-1)
		// validate the inputs
		if(inputArray.size() < 1 || sizeOfWindow < 0)
			return;
		
		PriorityQueue<AbstractMap.SimpleImmutableEntry<Integer, Integer>> heap =
				new PriorityQueue<AbstractMap.SimpleImmutableEntry<Integer, Integer>>();
		
		// initial filling up of the window
		for(int i = 0; i < sizeOfWindow; i++)
			;
			//heap.add(e)
		
	}
	
	public static void main(String[] args) {
		
	}
}
