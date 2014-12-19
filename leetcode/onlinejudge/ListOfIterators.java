package leetcode.onlinejudge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListOfIterators {
	
	public class IteratorOfLists<E> implements Iterator<E> {
		List<Iterator<E>> myList;
		Iterator<E> currentIterator;
		int currentIndex;
		
		IteratorOfLists (List<Iterator<E>> list) {
			myList = list;
			currentIterator = myList.get(0);
			currentIndex = 0;
		}
		
		@Override
		public boolean hasNext() {
			if(currentIterator.hasNext()) 
				return true;
			else {
				int nextIndex = currentIndex + 1;
				while (nextIndex < myList.size()) {
					if(myList.get(nextIndex).hasNext())
						return true;
					nextIndex++;
				}
			}
			return false;
		}

		@Override
		public E next() {
			if(currentIterator.hasNext()) 
				return currentIterator.next();
			else if (hasNext()) {
				int nextIndex = currentIndex + 1;
				while (nextIndex < myList.size()) {
					if(myList.get(nextIndex).hasNext()) {
						currentIndex = nextIndex;
						currentIterator = myList.get(nextIndex);
						return currentIterator.next();
					}
					nextIndex++;
				}				
			}
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}	
	}
	public static void main(String[] args) {
		ArrayList<Integer> array1 = new ArrayList<>();
		array1.add(444);
		array1.add(444);
		array1.add(444);
		array1.add(444);
		ArrayList<Integer> array2 = new ArrayList<>();
		array2.add(555);
		array2.add(555);
		array2.add(555);
		ArrayList<Integer> array3 = new ArrayList<>();
		array3.add(777);
		array3.add(777);
		array3.add(777);
		array3.add(777);
		array3.add(777);
		
		ArrayList<Iterator<Integer>> itArray = new ArrayList<>();
		itArray.add(array1.iterator());
		itArray.add(array2.iterator());
		itArray.add(array3.iterator());
		itArray.add(array1.iterator());
		
		ListOfIterators lof = new ListOfIterators();
		ListOfIterators.IteratorOfLists<Integer> iol = lof.new IteratorOfLists<>(itArray);
		
		while(iol.hasNext()) {
			System.out.println(iol.next());
		}
		
	}

}
