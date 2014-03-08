package trees.impl;

import java.util.ArrayList;
import java.util.Iterator;

public class BSTiterator implements Iterator<Integer> {
	private ArrayList<Integer> list;
	private int position;
	
	public BSTiterator(BST tree) {
		// Add contents of the tree to list
		//    This will require in-order traversal. 
		//    Try with recursion then without
		//    Without recursion: 
		//      http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
		if(tree.root() == null) {
			// nothing to do
			return;
		}
		list = new ArrayList<Integer>();
		traverseAndAdd(tree.root());
		position = 0;
	}
	
	public void traverseAndAdd(node current) {
		if(current == null) 
			return;
		traverseAndAdd(current.getLeft());
		list.add(current.data());
		traverseAndAdd(current.getRight());
	}

	public boolean hasNext() {
		if(position < list.size())
			return true;
		else 
			return false;
	}
	
	public Integer next() {
		Integer returnVal = list.get(position);
		position++;
		return returnVal;
	}
	
	
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
}
