package sortWork;

import java.util.List;

/*
 * Algorithm:
 * 		Divide a large list by a pivot point, resulting in 2 sub-lists.
 * 		Recursively sort the sublists. 
 */
public class quickSort {
	
	public static void swap(List<Integer> array, int first, int second) {
		int temp = array.get(first);
		array.set(first, array.get(second));
		array.set(second, temp);		
	}
	
	public static int partition(List<Integer> array, int left, int right, int pivotIndex) {
		int pivotValue = array.get(pivotIndex);
		swap(array, pivotIndex, right);
		int storeIndex = left;
		for(int i = left; i < right; i++) {
			if(array.get(i) <= pivotValue) {
				swap(array, i, storeIndex);
				storeIndex++;
			}			
		}		
		swap(array, storeIndex, right);
		return storeIndex;
	}
	
	// Choosing the median of the left, right, and middle for pivot index
	public static int choosePivotIndex(List<Integer> array, int left, int right) {
		int middle = (left + right)/2;
		int a = array.get(left);
		int b = array.get(middle);
		int c = array.get(right);
		
		// sort and choose middle(?), different approach requires 3 comparison max		
		/*
		 *          a > b > c                  B
		 *          a > b && b < c && a < c    A             
		 *          a > b && a > c && b > c    C
		 *          
		 *          c < a < b                  A
		 *          a < b && a < c && b > c    C
		 *          a < b && a < c && b < c    B
		 */
		if(a > b) {
			if(b > c) 
				return middle;			
			if(a > c) 
				return right;			
			else 
				return left;						
		}
		else {
			if(a > c) 
				return left;			
			if(b > c) 
				return right;			
			else 
				return middle;							
		}    				
	}
	
	public static List<Integer> qSort(List<Integer> array, int left, int right) {
		if(left < right) {
			int index = choosePivotIndex(array, left, right);
			int newIndex = partition(array, left, right, index);
			qSort(array, left, newIndex - 1);
			qSort(array, newIndex + 1, right);
		}
		return array;
	}
	
	public static List<Integer> sort(List<Integer> array) {
		return qSort(array, 0, array.size() - 1);
	}
}