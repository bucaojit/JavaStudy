package search;

import java.util.ArrayList;
import java.util.List;

/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand. 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). 
 * How do you find an element in the rotated array efficiently? 
 * You may assume no duplicate exists in the array.
 */

public class BinarySearchRotated {
	public void createArray(List<Integer> ar, int size) {
		if(ar.size() > 0) {
			System.out.println("WARN: Not using an empty list, clearing input list.");
			ar.clear();
		}
		//ArrayList<Integer> array = new ArrayList<Integer>();
		for(int i = 0; i < size; i++) {
			ar.add(i);			
		}
		//ar = array;
	}
	
	public void rotateArray(List<Integer> ar, int rotations) {
		if (ar.size() < 1) {
			System.out.println("ERROR: Array size is less than 1");
			return;
		}
		int rots = rotations % ar.size();
		for (int i = 0; i < ar.size(); i++) {
			swap(ar, i, (i + rots)%ar.size());
		}		
		System.out.println(ar.toString());
	}
	
	public void swap(List<Integer> ar, int firstIndex, int secondIndex) {
		Integer temp = (Integer)ar.get(firstIndex);
		ar.set(firstIndex, (Integer)ar.get(secondIndex)); 
		ar.set(secondIndex,  temp);
	}
	
	public void createArrayRotated(List<Integer> ar, int size, int rotations) {
		List<Integer> newList = new ArrayList<Integer>(size);
		createArray(newList, size);
		rotateArray(newList, rotations);
	}
	
	public int findIndex(List<Integer> ar, int key) {
		return 0;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		BinarySearchRotated bsr = new BinarySearchRotated();
		bsr.createArrayRotated(list, 10, 12);
	}
}
