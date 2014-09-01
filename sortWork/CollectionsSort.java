package sortWork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.bigwavedata.utils.ArrayGen;

// Similar to Arrays.sort, Collections.sort uses Arrays.sort to do the actual sorting anyways
// Implementing custom Comparator
public class CollectionsSort {
	public static void main(String[] args) {
		List<Integer> myList = ArrayGen.generate(100);
		List<Integer> myList2 = new ArrayList<Integer>(myList);
		System.out.println("Array: \n" + myList.toString());
		System.out.println("Second Array: \n" + myList2.toString());
		
		Collections.sort(myList);
		System.out.println("Array after Sort: \n" + myList.toString());
		
		Collections.sort(myList2,
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
		
		System.out.println("Array after Sort: \n" + myList2.toString());
	}
}
