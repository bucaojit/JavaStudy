package sortWork;

import java.util.List;

import com.bucaojit.utils.Trace;

// Algorithm:
// Find the lowest index 
// Swap current index with the lowest index
// Increment current index position and repeat until end
// O(n^2) operation
public class selectionSort {
	final Trace.Level TRACE_LEVEL=Trace.Level.TRACE;
	Trace LOG;
	selectionSort() {
		LOG = new Trace(this.getClass().toString(), TRACE_LEVEL);
	}
	
	public static void swap(List<Integer> list, int indexA, int indexB) {
		int temp = list.get(indexA);
		list.set(indexA, list.get(indexB));
		list.set(indexB, temp);
	}
	
	public static int getLeastIndex(List<Integer> list, int currentIndex) {
		// from currentIndex to end of list, find the lowest index
		int index = currentIndex;
		
		int lowestIndex = currentIndex;
		int lowestVal = list.get(currentIndex);
		
		do {
			if(lowestVal > list.get(index)) {
				lowestIndex = index;
				lowestVal = list.get(index);
			}
			
			index++;
		} while (index < list.size());
		return lowestIndex;
	}
	
	public static List<Integer> sort(List<Integer> list) {		
		for(int i=0; i < list.size(); i++) {
			swap(list,getLeastIndex(list, i), i);
		}		
		return list;
	}
}
