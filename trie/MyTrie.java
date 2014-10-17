package trie;

import java.util.ArrayList;

/**
 * {@code MyTrie} is a simple implementation of a trie <p>
 * No deletion of values in this current version 
 * Character node values
 * <p>
 * @author Oliver B
 */

public class MyTrie {
	
	TrieNode root;
	Integer size;
	Integer numContainers;
	
	boolean addValue(String key, Container data) {
		// need to find where to add the key
		// 1) check if it exists
		//    -if exists and is already isWord then false
		//    -else make into isWord and set data
		// 2) if not exist, then add the value. 
		//    -for each intermediate node check if the
		//       next char exists, if not create otherwise traverse
		//    -create node, return true
		           
		
			size++;
			return true;
	}
	
	Container getValue(String key) {
		// Iterate through the values and see if 'key' exists
		if (key == null) 
			return null;
		
		return new Container();
	}
	
	// Each TrieNode can have any number of children, different from a 
	// binary tree. 
	class TrieNode{
		public boolean isWord;
		public char data;
		public ArrayList<TrieNode> children;
		public String value;
		
		// Other information stored in the trie node
		public Container info;
		
		public TrieNode() {
			isWord = false;			
			children = new ArrayList<TrieNode>(1);
			value = null;
		}
		
		void addChild(char value) {
			TrieNode child = new TrieNode();
			child.data = value;
			sortChildren();
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
