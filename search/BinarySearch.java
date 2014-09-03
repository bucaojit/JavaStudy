package search;

import java.util.ArrayList;
import java.util.List;

import com.bigwavedata.utils.ArrayGen;

public class BinarySearch {

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
		//List<Integer> ar = new ArrayList<Integer>(size);
		ar = ArrayGen.generate(size, false);
		//createArray(ar, size);
		//rotateArray(ar, rotations);
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
	
		if(key >= ar.get(midPoint) && key <= ar.get(rightIndex)) 
			return findIndex(ar, key, midPoint + 1, rightIndex);
		else 
			return findIndex(ar, key, leftIndex, midPoint -1);
	}
	
	public static void main(String[] args) {
        Integer searchKey = 2;
        Integer arraySize = 10;
        
		List<Integer> list = ArrayGen.generate(arraySize, false);
		BinarySearch bsrch = new BinarySearch();
		//bsr.createArrayRotated(list, arraySize, rotations);
		
        System.out.println("Looking for key: " + searchKey + " in array --");
        System.out.println(list.toString());
        System.out.print("The index is: ");
        System.out.println(bsrch.findIndex(list, searchKey));
	}
}
 
