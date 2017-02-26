package sortWork;

import java.util.ArrayList;
import java.util.List;

import com.bucaojit.utils.ArrayGen;
import com.bucaojit.utils.Trace;
import com.bucaojit.utils.myTimer;

public class TestDriver {
	Trace LOG;
	TestDriver() {
		LOG = new Trace(this.getClass().toString());
	}
	
	public static void main(String[] args) {
		
		List<Integer> myList = ArrayGen.generate(10000);
		List<Integer> myList2 = new ArrayList<Integer>(myList);
		List<Integer> myList3 = new ArrayList<Integer>(myList);
		List<Integer> myList4 = new ArrayList<Integer>(myList);
		
		TestDriver myT = new TestDriver();
		myTimer.beginTime();
		myT.LOG.logDebug("selection sort: " + selectionSort.sort(myList).toString());
		//selectionSort.sort(myList);
		myTimer.endTime();
		myTimer.beginTime();
		myT.LOG.logDebug("insertion sort: " + insertionSort.sort(myList2).toString());
		//insertionSort.sort(myList2);
		myTimer.endTime();
		
		myTimer.beginTime();
		myT.LOG.logDebug("merge sort: " + mergeSort.sort(myList3).toString());
		//mergeSort.merge(myList3);
		myTimer.endTime();
		
		myTimer.beginTime();
		myT.LOG.logDebug("quick sort: " + quickSort.sort(myList4).toString());
		myTimer.endTime();
		
		// Now try sorting already-sorted array and seeing differences in time
		System.out.println("------------- Sorted Versions -------------");
		myTimer.beginTime();
		myT.LOG.logDebug("selection sort: " + selectionSort.sort(myList).toString());
		//selectionSort.sort(myList);
		myTimer.endTime();
		myTimer.beginTime();
		myT.LOG.logDebug("insertion sort: " + insertionSort.sort(myList).toString());
		//insertionSort.sort(myList2);
		myTimer.endTime();
		
		myTimer.beginTime();
		myT.LOG.logDebug("merge sort: " + mergeSort.sort(myList).toString());
		//mergeSort.merge(myList3);
		myTimer.endTime();
		
		myTimer.beginTime();
		myT.LOG.logDebug("quick sort: " + quickSort.sort(myList).toString());
		myTimer.endTime();
		
	}
	
}
