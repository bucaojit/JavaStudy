package heaps;

import java.util.AbstractMap;
import java.util.ArrayList;
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
	static final int ARRAY_LENGTH = 8;
	static final int WINDOW_SIZE  = 3;
	// Can use pair AbstractMap.SimpleImmutableEntry<K,V>
	
	public class pairComparator implements 
	    Comparator<AbstractMap.SimpleImmutableEntry<Integer, Integer>> {
		@Override
		public int compare(AbstractMap.SimpleImmutableEntry<Integer, Integer> a,
		                   AbstractMap.SimpleImmutableEntry<Integer, Integer> b) {
			
			if (a.getKey() < b.getKey()) 
				return 1;
			
			if (a.getKey() > b.getKey()) 
				return -1;
			
			return 0;
		}
	}
	
	// Use arrayGen to generate the random unique-entry array
	public void integerArrayToPair(List<Integer> inputArray, 
								   List<AbstractMap.SimpleImmutableEntry
								   <Integer, Integer>> outputArray) {
		if(inputArray.size() < 1)
			return;
		if(outputArray.size() > 0) {
			System.out.println("WARNING: Array size is greater than 0, integerArrayToPair");
			outputArray.clear();
		}		
		for(int i = 0; i < inputArray.size(); i++) {
			outputArray.add(new AbstractMap.SimpleImmutableEntry<Integer, Integer>(inputArray.get(i), i));					                                                                
		}		
	}	
	
	public void movingWindowSolve(List<Integer> inputArray,
								  Integer sizeOfWindow,
								  List<Integer> outputArray) {
		// Length of outputArray will be inputArray.size() - (sizeOfWindow-1)
		// validate the inputs
		if(inputArray.size() < 1 || sizeOfWindow < 0)
			return;
		
		ArrayList<AbstractMap.SimpleImmutableEntry<Integer, Integer>> convertedArray = 
				new ArrayList<AbstractMap.SimpleImmutableEntry<Integer, Integer>>();
		integerArrayToPair(inputArray, convertedArray);
		
		Comparator<AbstractMap.SimpleImmutableEntry<Integer, Integer>> comp = new pairComparator();
		
		PriorityQueue<AbstractMap.SimpleImmutableEntry<Integer, Integer>> heap =
				new PriorityQueue<AbstractMap.SimpleImmutableEntry<Integer, Integer>>(10, comp);
		
		// initial filling up of the window
		for(int i = 0; i < sizeOfWindow; i++)
			heap.add(convertedArray.get(i));
	
		for(int i = sizeOfWindow; i < inputArray.size(); i++) {
			AbstractMap.SimpleImmutableEntry<Integer, Integer> entry = heap.peek();
			outputArray.add(entry.getKey());
			// Only care about the top value and when it is phased out of the window
			// Other values won't matter until they get promoted
			while(entry.getValue() <= i-sizeOfWindow) {
				heap.remove();
				entry = heap.peek();
			}
			heap.add(convertedArray.get(i));
		}
		outputArray.add(heap.peek().getKey());
	}	
	
	public static void main(String[] args) {
		MovingWindow mw = new MovingWindow();
		ArrayList<Integer> array = new ArrayList<Integer>(10);
		array.add(1);
		array.add(3);
		array.add(-1);
		array.add(-3);
		array.add(5);
		array.add(3);
		array.add(6);
		array.add(7);
		
		ArrayList<Integer> outputArray = new ArrayList<Integer>(10);
		mw.movingWindowSolve(array, WINDOW_SIZE, outputArray);
		System.out.println("Output array: " + outputArray.toString());
	}
}
