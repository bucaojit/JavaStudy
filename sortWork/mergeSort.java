package sortWork;

import java.util.ArrayList;
import java.util.List;
/*
Algorithm:
	Split each element to a separate list until one per element. 
	final_merge will merge separate lists until left with one final list
	of all sorted data
*/

/* NOTE:
 *   During development of this sort, encountered issues that dealt with
 *   having to understand list.subList() method.
 *   List.subList(begin, end);
 *                begin is inclusive
 *                end is exclusive
 *                [ begin, end )
 *                
 *   Also, during performance testing, finding that mergeSort is slower
 *   than insertionSort.  May need to add trace lines to find out the 
 *   slow areas.  Suspect the constant creation of lists may add to the
 *   slowness.
 */
public class mergeSort {
	
	public static List<Integer> merge(List<Integer> list) {
		if(list.size() == 1) {
			return list;
		}
		List<Integer> left;
		List<Integer> right;
		
		int middle = list.size()/2;
		// Add to left and right of list
		left = list.subList(0, middle);
		right = list.subList(middle, list.size());
		
		left = merge(left);
		right = merge(right);
		
		return final_merge(left, right);
	}
	
	// Sort the left/right lists, return the final list
	// Optimization to not create new lists.  Just use the list we are given and no need to 
	//   edit listA, listB.  Only modifying result.
	public static List<Integer> final_merge(List<Integer> listA, List<Integer> listB) {		
		List<Integer> result = new ArrayList<Integer>(listA.size() + listB.size());
		// In order to not have to delete and re-copy array, just keep indexes of current loc
		
		// addAll(Collection<? extends E> c)
		int listAIndex=0, listBIndex=0;
		while(listAIndex < listA.size() || listBIndex < listB.size()) {
			if(listAIndex < listA.size() && listBIndex < listB.size()) {
				if(listA.get(listAIndex) < listB.get(listBIndex)) {
					result.add(listA.get(listAIndex));
					listAIndex++;
				}
				else {
					result.add(listB.get(listBIndex));
					listBIndex++;
				}
			}
			else {
				if(listAIndex == listA.size()) {
					// listB is complete, append the rest of listA to result
					for (int i = listBIndex; i < listB.size(); i++) {						
						result.add(listB.get(i));
					}					
					return result;
				}
				else {
					for (int i = listAIndex; i < listA.size(); i++) {					
						result.add(listA.get(i));
					}
					return result;
				}
			}
			
		}
		return result;
	}
	
	public static List<Integer> sort(List<Integer> list) {
		return merge(list);
	}
}
