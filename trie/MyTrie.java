package trie;
/**
 * {@code MyTrie} is a simple implementation of a trie <p>
 * No deletion of values in this current version 
 * <p>
 * @author Oliver B
 */

public class MyTrie {
	
	TrieNode<Container> root;
	Integer size;
	Integer numContainers;
	
	void addValue(String key, Container data) {
		// TODO
			size++;
	}
	
	Container getValue(String key) {
		// Iterate through the values and see if 'key' exists
		if (key == null) 
			return null;
		
		return new Container();
	}
	
	
	class TrieNode<T>{
		public boolean isWord;
		public T data;
		public TrieNode<T>[] children;
		public String value;
		
		void addChild() {
			// TODO
		}
		void sortChildren() {
			// TODO
		}
	}
	
	// Contains trie data
	class Container {
		String information;
		Integer version;		
	}
}
