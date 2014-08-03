package arrays;
// Author: Oliver
import java.util.ArrayList;
import java.util.List;

public class hashTable <E,F>{
	private List<element<E,F>> list; 
	
	public hashTable() {
		this(10);
	}

	public hashTable(int size) {
		list = new ArrayList<element<E,F>>(size);
	}
	
	private int hash(E key) {
		return 0;
	}
	
	public class element<E,F> {
		private E key;
		private F value;
		element<E,F> el;
		
		public element(E key, F value) {
			this.key = key;
			this.value = value;
		}
		public E getKey() {
			return key;
		}
		public F getValue() {
			return value;
		}
	}
}