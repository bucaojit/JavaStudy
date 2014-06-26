package trees;
import java.io.IOException;

import trees.impl.BST;
import trees.impl.node;

public class heightAndLevels{ 
	private BST tree;
	
	public heightAndLevels(int value) throws IOException {
		node firstnode = new node(value);
		tree = new BST(firstnode);
	}
	
	public void insert(int value) {
		if (tree.root() == null) {
			node firstnode = new node(value);
			tree = new BST(firstnode);
		}
		tree.insert(value);
	}
	
	public void printTree() {
		if(tree.root() == null) {
			System.out.println("No root");
			return;
		}
		System.out.println("Printing Tree:");
		try {
			tree.printTree();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		
		try {
			heightAndLevels t1 = new heightAndLevels(55);

		t1.insert(4);
		t1.insert(14);
		t1.insert(47);
		t1.insert(23);
		t1.insert(99);
		t1.insert(8);
		t1.insert(6);
		
		t1.checkBST(t1.tree.root());
		
		t1.printTree();
		} catch (Exception e) {
			System.out.println("Exception has occurred");
			e.printStackTrace();
		}
		
		
		//  Playing with binary search
		//  Is the array going to be 'global'?  Passed by reference instead of value
		int[] myArray = {1,3,55,100,120, 200, 300, 5000, 100000};
		
		System.out.println("Searching for 120: " + bsearch(myArray, 5000));
		/*
		secondbtree.sort(myArray);
		for(int currInt : myArray) {
			System.out.println("value: " + currInt);
		}
		*/
	}
	boolean checkBST(node n) {
		return checkBST(n,Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	boolean checkBST(node n, int minVal, int maxVal) {
		if (n == null) return true;
		if(n.data() <= minVal || n.data() > maxVal) {
			return false;
		}
		if (!checkBST(n.getLeft(), minVal, n.data()) || 
		    !checkBST(n.getRight(), n.data(), maxVal))
		{return false; }
		return true;
	}
	
	public static int bsearch(int[] intArray, int value) {
		try {
		    return bsearch(value, intArray, 0, intArray.length - 1);
		} catch (Exception e) {
			System.out.println("You tried to access past the end of the array");
			e.printStackTrace();
			return -1;
		}
	}
	
	public static int bsearch(int value, int[] intArray, int start, int end) throws RuntimeException {
		int midpoint = start + ((end - start) / 2);
		if(midpoint > intArray.length) {
			throw new RuntimeException("went past the end of the array");
		}
		if(intArray[midpoint] == value) return midpoint;
		if(start >= end)  return -1; 
		if(value > intArray[midpoint]) {
			return bsearch(value, intArray, midpoint + 1, end);
		}
		else {
			return bsearch(value, intArray, 0, midpoint);
		}
	}
	
	public static void sort(int[] intArray) {
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = 44;
		}
	}
}