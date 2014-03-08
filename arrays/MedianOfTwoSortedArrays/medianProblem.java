package arrays.MedianOfTwoSortedArrays;

import java.util.ArrayList;
import java.util.List;


// Work in progress, revisit later

public class medianProblem {
	
	public static int medianSearch(List<Integer> firstList, List<Integer> secondList, int lengthA, int lengthB,
			                       int nA, int nB) {
		System.out.println("TRACE: medianSearch -- ENTRY -- size left: " + 
				lengthA + " size right: " + lengthB);
		if(lengthA < lengthB)  {
			// Want to have the array with fewer entries in left position
			System.out.println("TRACE: medianSearch -- EXIT 1");
			return medianSearch(secondList, firstList, Math.max(0, (nA + nB)/2 - nA), 
					                                   Math.min(nB, (nA + nB)/2), nB, nA);
		}
		double i = Math.floor((((double)lengthA + (double)lengthB) /2));
		double j = Math.ceil((( (double)nA + (double)nB) /2) - i);
		
		if(((j == 0) || (firstList.get((int)i) > secondList.get((int)j)) && 
		   ((int)j == lengthB) || (firstList.get((int)i) <= secondList.get((int)j + 1)))) {
			System.out.println("TRACE: medianSearch -- EXIT 2");
			return firstList.get((int)i);
		}
		else if(((j == 0) || firstList.get((int)i) > secondList.get((int)j)) && 
				(j != lengthB) && firstList.get((int)i) > secondList.get((int)j + 1)) {
			System.out.println("TRACE: medianSearch -- EXIT 3");
			return medianSearch(firstList, secondList, lengthA, (int)i - 1, nA, nB);
		}
		else  {
			System.out.println("TRACE: medianSearch -- EXIT 4");
			return medianSearch(firstList, secondList, (int)i + 1, lengthB, nA, nB);
		}
	}
	
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		
		list1.add(1);
		list1.add(4);
		list1.add(55);
		list1.add(56);
		list1.add(100);
		
		list2.add(2);
		list2.add(3);
		list2.add(5);
		list2.add(101);
		
		// output the lists
		System.out.println("First List: ");
		for(Integer myInt : list1) {
			System.out.print(myInt + " ");
		}
		System.out.println();
		
		System.out.println("Second List: ");
		for(Integer myInt : list2) {
			System.out.print(myInt + " ");
		}
		System.out.println();
		
		int ret = medianProblem.medianSearch(list2, list1, list2.size(), list1.size(), list2.size(), list1.size());
		System.out.println("Output: " + ret);
		
	}
}
