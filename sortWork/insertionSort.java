package sortWork;

import java.util.List;

// Algorithm:
// Start at position 1 of 0-based array
// Compare current value to previous index
// If current value is greater than previous index, no op
// If current value is less than previous index, continue comparing until
//   it is greater
// Rotate elements so that current value is in position that is greater than
//   the element before it
public class insertionSort {
	public static void rotateArray(List<Integer> list, int lowIndex, int currIndex) {
		Integer currValue = list.get(currIndex);
		while (currIndex > lowIndex) {
			list.set(currIndex, list.get(currIndex - 1));
			currIndex--;
		}
		list.set(lowIndex, currValue);
	}
	public static List<Integer> sort(List<Integer> list) {
		int prevIndex;
		
		for(int i=1; i < list.size(); i++) {
			prevIndex = i - 1;

			while((list.get(i) < list.get(prevIndex))&&(prevIndex>=0)) {
				prevIndex--;
				if (prevIndex == -1)
					break;
			}
			prevIndex++;
			
			if(prevIndex != i) {
				rotateArray(list, prevIndex, i);
			}
			
		}
		return list;
	}
}
