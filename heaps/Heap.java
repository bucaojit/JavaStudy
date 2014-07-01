package heaps;

import java.util.ArrayList;

// Program a heap complete with comparator class that can be 
// overridden to customize comparator functionality. 
public class Heap {
	// Implementing as an array
	// First as fixed size, then as a resizing array
	//private int nextFreeIndex;
	private static final int INITIAL_SIZE = 10;
	private ArrayList<Integer> heap;
	
	public Heap() {
		//nextFreeIndex = 0;
		heap = new ArrayList<Integer>(INITIAL_SIZE);
	}
	
	public Heap(int initialSize) {
		//nextFreeIndex = 0;
		heap = new ArrayList<Integer>(initialSize);
	}
	
	public void add(int value) {
		heap.add(value);
		addRefactor();
		System.out.println(heap.toString());
	}
	
	private void addRefactor() {
		// An item was added to the end of the array,
		// check if it is larger than the parent, if so swap
		int currentIndex = heap.size()-1;
		while(heap.get(currentIndex) > heap.get(getParentIndex(currentIndex)) && 
			   currentIndex > 0) {
			swap(currentIndex, getParentIndex(currentIndex));
			currentIndex = getParentIndex(currentIndex);
		}
	}
	
	void swap(int firstIndex, int secondIndex) {
		int temp = heap.get(firstIndex);
		heap.set(firstIndex, heap.get(secondIndex));
		heap.set(secondIndex, temp);
	}
	
	private void remRefactor() {
		
	}
	
	private int getParentIndex(int index) {
		return (index-1)/2;
	}
	
	private int getLeftIndex(int index) {
		return 2*index+1;
	}
	
	private int getRightIndex(int index) {
		return 2*index+2;
	}
	
	public void deleteTop() {
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		
		remRefactor();
	}
	
	public static void main(String[] args) {
		Heap heap = new Heap();
		heap.add(5);
		heap.add(66);
		heap.add(15);
		heap.add(23);
		heap.add(54);
		heap.add(100);
		heap.add(0);
		heap.add(3);
		heap.add(101);
	}
}
