package maps;

import java.util.Collection;
import java.util.HashSet;

public class HashSetWork {
	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<Integer>();
		
		set.add(10);
		set.add(100);
		set.add(555);
		set.add(12);
		
		// How to iterate through the set
		for(Integer myInt : set) {
			System.out.println(myInt);
		}
		
		Collection<Integer> myColl = set;
		System.out.println();		
		System.out.println(myColl.iterator().next());
	}
}
