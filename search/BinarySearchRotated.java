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
		//System.out.println(ar.toString());
		int rots = rotations % ar.size();
		for ( int j =0; j < rots; j++)
			for (int i = 0; i < ar.size()-1; i++) {
				swap(ar, i, i+1);
				//System.out.println(ar.toString());
			}		
		//System.out.println(ar.toString());
	}
	
	public void swap(List<Integer> ar, int firstIndex, int secondIndex) {
		Integer temp = (Integer)ar.get(firstIndex);
		ar.set(firstIndex, (Integer)ar.get(secondIndex)); 
		ar.set(secondIndex,  temp);
	}
	
	public void createArrayRotated(List<Integer> ar, int size, int rotations) {				
		//List<Integer> newList = new ArrayList<Integer>(size);
		createArray(ar, size);
		rotateArray(ar, rotations);
	}
	
	public int findIndex(List<Integer> ar, int key) {
		// Characteristics of a rotated array:
		// Center to right, if center < right then right side is sorted
		// Center to left, if left < center then left side is sorted
		// Both sides may be sorted, meaning the array is not rotated.
		// Still only need to check one side is sorted. 
		if (ar.size() == 0) {
			System.out.println("ERROR passed in empty array");
			return -1;
		}
		
		return findIndex(ar, key, 0, ar.size()-1);		
	}
	
	private int getMid(int a, int b){
		return (a + b)/2;
	}
	public int findIndex(List<Integer> ar, int key, int leftIndex, int rightIndex) {
		int midPoint = getMid(leftIndex, rightIndex);
		if(ar.get(midPoint) == key) return midPoint;
		
		if(leftIndex >= rightIndex) return -1;
		
		if(ar.get(midPoint) < ar.get(rightIndex)) {
			// Right side is sorted
			if(key >= ar.get(midPoint) && key <= ar.get(rightIndex)) 
				return findIndex(ar, key, midPoint + 1, rightIndex);
			else 
				return findIndex(ar, key, leftIndex, midPoint -1);
		}
		else {
			// Left side is sorted
			if(key >= ar.get(leftIndex) && key <= ar.get(midPoint)) 
				return findIndex(ar, key, leftIndex, midPoint - 1);
			else
				return findIndex(ar, key, midPoint + 1, rightIndex);
		}
	}
	
	public static void main(String[] args) {
                Integer searchKey = 9;
                Integer rotations = 2;
                Integer arraySize = 10;
		ArrayList<Integer> list = new ArrayList<Integer>();
		BinarySearchRotated bsr = new BinarySearchRotated();
		bsr.createArrayRotated(list, arraySize, rotations);
		
        System.out.println("Looking for key: " + searchKey + " in array --");
        System.out.println(list.toString());
        System.out.print("The index is: ");
        System.out.println(bsr.findIndex(list, searchKey));
	}
}
 
