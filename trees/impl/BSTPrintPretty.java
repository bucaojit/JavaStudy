package trees.impl;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

// my Java implementation of:
//    http://leetcode.com/2010/09/how-to-pretty-print-binary-tree.html
//    3/11 -- Taking a break to work on other things
public class BSTPrintPretty {
	public static void printTree(Node inputNode) throws IOException {
		if(inputNode == null) {
			//System.out.println("NULL");
			return;
		}		
		printTree(inputNode.getLeft());
		System.out.println("Data: " + inputNode.data());
		printTree(inputNode.getRight());
	}
	
	public static void printTreePretty(Node inputNode) throws IOException {
		if(inputNode == null) {
			System.out.println("NULL");
			return;
		}		
		System.out.println("Print");
		print(inputNode, 0, 0);
		//printTree(inputNode.getLeft());
		//System.out.println("Data: " + inputNode.data());
		//printTree(inputNode.getRight());
	}
	
	public static void print(Node inputNode, int level, int indentSpace) {
		int height = maxHeight(inputNode);
		int NodesInThisLevel = 1;
		
		// eq of the length of branch for each Node of each level
		int branchLength = 2*((int)Math.pow(2.0, height)-(3-level)*(int)Math.pow(2.0,height-1));
		// distance between left neighbor Node's right arm and right neighbor Node's left arm
		int NodeSpaceLen = 2 + (level+1)*(int)Math.pow(2.0,height);
		// starting space to the first Node to print of each level (for the left most Node of each level only)
		int startLen = branchLength + (3-level) + indentSpace; 
		
		Deque<Node> NodesQueue = new ArrayDeque<Node>();
		NodesQueue.add(inputNode);
		
		for (int i =1; i < NodesInThisLevel; i++) {
			printBranches(branchLength, NodeSpaceLen, startLen, NodesInThisLevel, NodesQueue);
			branchLength = branchLength/2-1;
			NodeSpaceLen = NodeSpaceLen/2+1;
			startLen = branchLength + (3-level) + indentSpace;
			printNodes(branchLength, NodeSpaceLen, startLen, NodesInThisLevel, NodesQueue);
			
			for(int j = 0; j < NodesInThisLevel; j++) {
				//Node currNode = NodesQueue.getFirst();
				Node currNode = NodesQueue.pop();
				if (currNode != null) {
					NodesQueue.addLast(currNode.getLeft());
					NodesQueue.addLast(currNode.getRight());
				}
				else {
					NodesQueue.addLast(null);
					NodesQueue.addLast(null);
				}				
			}
			NodesInThisLevel *= 2;
		}
		printBranches(branchLength, NodeSpaceLen, startLen, NodesInThisLevel, NodesQueue);
		printLeaves(indentSpace, level, NodesInThisLevel, NodesQueue);
	}
	
	public static void printBranches(int branchLen, int NodeSpaceLen, int startLen, 
			                         int NodesInThisLevel, final Deque<Node> NodesQueue) {
		Iterator<Node> it = NodesQueue.iterator();
		for (int i = 0; i < NodesInThisLevel/2; i++) {
		    System.out.print(String.format("%" + ((i == 0) ? startLen-1 : NodeSpaceLen-2) + "s", " ") + 
		    		((it.equals(null)) ? "/" : " "));
		    it.next();
		    int length = 2*branchLen+1;
		    System.out.print(String.format("%"+length+"s",""));
		    System.out.print((it.equals(null) ? " " : "\\"));
			//out << ((i == 0) ? setw(startLen-1) : setw(NodeSpaceLen-2)) << "" << ((*iter++) ? "/" : " ");
		    //out << setw(2*branchLen+2) << "" << ((*iter++) ? "\\" : " ");
		}
		System.out.println();
	}
	
	public static void printLeaves(int indentSpace, int level, int NodesInThisLevel,
			                       Deque<Node> NodesQueue) {
		Iterator<Node> it = NodesQueue.iterator();
		for(int i = 0; i < NodesInThisLevel; i++,it.next()) {
			
		}
		System.out.println();
		/*
		 *   deque<BinaryTree*>::const_iterator iter = NodesQueue.begin();
  for (int i = 0; i < NodesInThisLevel; i++, iter++) {
    out << ((i == 0) ? setw(indentSpace+2) : setw(2*level+2)) << ((*iter) ? intToString((*iter)->data) : "");
  }
  out << endl;
		 */
	}
	
	public static void printNodes(int branchLen, int NodeSpaceLen, int startLen, 
			int NodesInThisLevel, final Deque<Node>NodesQueue) {
		
	}
	
	public static int maxHeight(Node input) {
		if(input == null) 
			return 0;
		int leftHeight  = maxHeight(input.getLeft());
		int rightHeight = maxHeight(input.getRight());
		return (leftHeight > rightHeight? leftHeight + 1 : rightHeight + 1);
	}
}
