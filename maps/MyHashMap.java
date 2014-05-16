package maps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MyHashMap {
	List<intString> hashmap;
	int inputSize;
	int arrayLength;
	
	public MyHashMap() {
		hashmap = new ArrayList<intString>(10);
		inputSize = 0;
		arrayLength = 10;
	}
	
	public MyHashMap(int defaultSize) {
		hashmap = new ArrayList<intString>(defaultSize);
		inputSize = 0;
		arrayLength = defaultSize;
	}
	
	private int getHash(String data) {
		System.out.println("Hash Value: " + data.hashCode());
		Integer hashIndex = data.hashCode() % arrayLength;
		
		int retIndex = Math.abs(hashIndex);
		System.out.println("Size of hashmap: " + hashmap.size() + " Hash index: " + retIndex);
		return retIndex;
	}
	
	private int getIndex(String value) {
		// TODO:
		//	1) check if hashed index is correct value
		//	2) if not then increment until we get correct value or initial location is revisited
		return 0;
	}
	
	public String getData(int key) {
		// TODO:
		//	1) find the correct index
		//	2) return hash @ index
		return new String();
	}
	
	private void insertToIndex(int key, String value) {
		// Try to add to hashed position first, if unable to insert, try next. 
		
	}
	
	private void checkAndResize() {
		if(hashmap.size() >= inputSize) {
			try {
				resizeMap();
			} catch (IOException e) {
				System.out.println("ERROR: Unable to allocate larger array");
				e.printStackTrace();
				System.exit(1);
			}
		}
		
	}
	
	public long insertData(String data) {
		// get the hash value from the String object itself
		// try to insert the value into the arraylist, if value is present then add to 
		//    1. Next entry in ArrayList
		//    2. Linked List at arraylist
		//           -implement #2 in another class
		checkAndResize();

		insertToIndex(getIndex(data), data);
		
		inputSize++;
		

		return 0;
	}
	
	// Takes current hashmap and rehashes into hashmap of double size
	private void resizeMap() throws IOException {
		
	}
	
	
	public static void main(String[] args) {
		System.out.println("Hello World");
		MyHashMap mymap = new MyHashMap();
		
		String newstring = "this is an example string2";
		System.out.println("The String = " + newstring);
		System.out.println("The Hash = " + newstring.hashCode());
		//System.out.println(String.format("%d",newstring.hashCode()));
		mymap.getHash(newstring);
		
	}
	
	
	// Java always has the hash automatically included as parent class -- no need to add both as a tuple
	private class intString {
		int theInt;
		String data;
		
		intString(int hash, String data) {
			this.theInt = hash;
			this.data = data;
		}
	}

}
 