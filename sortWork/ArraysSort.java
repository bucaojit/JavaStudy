package sortWork;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.bucaojit.utils.ArrayGen;

// Use the Arrays class to sort the given arrays
// Will modify the comparator to sort a different way
public class ArraysSort {	
	
	public static void main(String[] str) {
		List<Integer> myList = ArrayGen.generate(100);
		Integer intArray[] = new Integer[myList.size()];
		Integer intArray2[] = new Integer[myList.size()];
		Integer intArray3[] = new Integer[myList.size()];
		
		intArray = myList.toArray(intArray);
		intArray2 = myList.toArray(intArray2);
		intArray3 = myList.toArray(intArray3);
		
		// Print each value in the array, doing a toString() on the 
		//  Array object will only print the object itself not the values
		System.out.println("First Array:");
		for (Integer value : intArray) {
			System.out.print(value + " ");
		}
		System.out.println();
		
		System.out.println("Second Array:");
		for (Integer value : intArray2) {
			System.out.print(value + " ");
		}
		System.out.println();
		
		System.out.println("Third Array:");
		for (Integer value : intArray3) {
			System.out.print(value + " ");
		}
		System.out.println();
		
		Arrays.sort(intArray);
		
		System.out.println("First Array Sorted with Arrays.sort:");
		for (Integer value : intArray) {
			System.out.print(value + " ");
		}
		System.out.println();
		
		// Implementing my own comparator class to reverse the order
		Arrays.sort(intArray2, 
				new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				if (arg1 < arg0) {
					return -1;
				}
				else if(arg1 > arg0)
					return 1;
				
				return 0;
			}				
		});
		
		System.out.println("Second Array Sorted with custom reverse Comparator:");
		for (Integer value : intArray2) {
			System.out.print(value + " ");
		}
		System.out.println();
				
		System.out.println("Third Array, before sort:");
		for (Integer value : intArray3) {
			System.out.print(value + " ");
		}
		System.out.println();
		// Implementing my own comparator class to make values between 10 and 20 
		//   higher on the list
		Arrays.sort(intArray3, 
				new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				if (arg0 < 20 && arg0 > 10){
					if (arg1 < 20 && arg1 > 10) {
						return 0;
					}
					return -1;
				}
				else {
					if (arg1 < 20 && arg1 > 10) {
						return 1;
					}
					else return 0;
				}
			}				
		});
		System.out.println("Third Array Sorted with custom Comparator, values between 10 and 20 have higher priority:");
		for (Integer value : intArray3) {
			System.out.print(value + " ");
		}
		System.out.println();
	}
	
}
