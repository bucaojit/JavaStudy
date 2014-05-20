package trees;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import trees.impl.BST;
import trees.impl.node;

// 1) Coding a breadth first search
//    -Uses a queue to store data
// 2) Measure the height
// 3) Output height with each data point
public class breadthFirstSearch extends BST{
	//BST tree;
	
	public void breadth_first_search() {
	   if(root() == null) {
		   return;
	   }
	   
	   //Depth-first would be the same but a Stack
	   //  - The order of which node is which flips
	   //  If the queue does not have an int value, then 
	   //  you can have a separate queue
	   Queue<node> nodeQ = new LinkedList<node>();
	   node currNode;
	   node currLevel;
	   //int height = 1;
	   
	   nodeQ.add(root());
	   node levelNode = new node(1);
	   nodeQ.add(levelNode);
	   
	   System.out.println("Printing tree in BFS");
	   while(!nodeQ.isEmpty()) {
		   currNode = nodeQ.remove();
		   currLevel = nodeQ.remove();
		   
		   System.out.println("value: " + currNode.data());
		   System.out.println("level: " + currLevel.data());
		   node newLevel = new node(currLevel.data() + 1);
		   if (currNode.getLeft() != null) {
			   nodeQ.add(currNode.getLeft());
			   nodeQ.add(newLevel);
			   
		   }
		   if (currNode.getRight() != null) {
			   nodeQ.add(currNode.getRight());
			   nodeQ.add(newLevel);
		   }
		   
	   }
	   // Algorithm 
	   // 1) Add values to the queue starting with the root
	   // 2) remove from queue and add children to queue
	   // 3) mark as visited or just print the value
	}
	
	public int getHeight() {
		if (root() == null) {
			return 0;
		}
		
		return 0;
	}
	
	public int getHeight(node root) {
		if (root == null) {
			return 0;
		}
		return 0;
	}
	
	public int heightOfBinaryTree() {
		return heightOfBinaryTree(root());
	}
	
	public int heightOfBinaryTree(node node)
	{
	    if (node == null)
	    {
	        return 0;
	    }
	    else
	    {
	    	// Recurse through all the nodes and at the leaf return 0
	    	// At every other root node you add 1 and return the greater
	    	// of you children's heights
	        return 1 +
	        Math.max(heightOfBinaryTree(node.getLeft()),
	            heightOfBinaryTree(node.getRight()));
	    }
	}
	
	public void insert(int value) {
		super.insert(value);
	}
	
	public static void main(String[] args) throws IOException {
		breadthFirstSearch btree = new breadthFirstSearch(5);
		
		btree.insert(7);
		btree.insert(10);
		btree.insert(4);
		btree.insert(3);
		btree.insert(100);
		btree.printTree();
		btree.traverseNonRecursive();
		//btree.anotherPrintTree();
		
		Iterator<Integer> myIt = btree.iterator();
		if(myIt.hasNext()) {
			System.out.println("value: " + myIt.next());
		}
		//btree.printTree();
		//btree.
		
		//btree.breadth_first_search();
		//System.out.println("Height: " + btree.heightOfBinaryTree());
		btree.printTreeWithLevel();
		
		
		//Stack example
		Stack<String> strStack = new Stack<String>();
		strStack.add("first");
		strStack.add("second");
		strStack.add("third");
		//Last in
		strStack.add("fourth");
		
		System.out.println("Printing Stack values:");
		while(!strStack.empty()) {
			System.out.println(strStack.pop());
		}
	}
	
	// I like to have these empty methods so user does not need to 
	// know what to enter. for default
	/*
	public void printTree() {
		printTree(tree.root());
		System.out.println("");
	}
	
	public void printTree(node root) {
		// breadth first search -- fifo -- implement next
		
		// for now implement pre-order
		if (root == null) {
			return;
		}
		

		printTree(root.getLeft());
		System.out.print(root.data());
		System.out.print(" ");
		printTree(root.getRight());
		// print root
		// traverse left
		// traverse right
		
	}
	*/
	public void printTreeWithLevel() {
		printTreeWithLevel(root(), 1);
		System.out.println("");
	}
	
	public void printTreeWithLevel(node root, int level) {
		// breadth first search -- fifo -- implement next
		
		// for now implement pre-order
		if (root == null) {
			return;
		}
		

		printTreeWithLevel(root.getLeft(), level + 1);
		System.out.print(root.data());
		System.out.print(" ");
		System.out.print(" Level: " + level);
		System.out.println("");
		printTreeWithLevel(root.getRight(), level + 1);
	}
	
	public breadthFirstSearch(int value) {
		super(value);
		//node firstnode = new node(value);
		//tree = new BST(firstnode);
	}
	
	
	

}