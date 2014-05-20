package trees.impl;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

// my Java implementation of:
//    http://leetcode.com/2010/09/how-to-pretty-print-binary-tree.html
//    3/11 -- Taking a break to work on other things
//    5/19 -- revisiting. need to figure out spacing calculations
public class BSTPrintPretty2 {
	public static void printTree(node inputNode) throws IOException {
		if(inputNode == null) {
			//System.out.println("NULL");
			return;
		}		
		printTree(inputNode.getLeft());
		System.out.println("Data: " + inputNode.data());
		printTree(inputNode.getRight());
	}
	
	public static void printTreePretty(node inputNode) throws IOException {
		if(inputNode == null) {
			System.out.println("NULL");
			return;
		}		
		System.out.println("Print");
		print(inputNode, 0);
	}
	
	public static void print(node inputNode, int level) {
		int height = maxHeight(inputNode);
		int nodesInThisLevel = 1;
		
		// eq of the length of branch for each node of each level
		int nodeSpaceLen = (int)Math.pow(2.0,height);
		int branchLength = 2*nodeSpaceLen;
		// distance between left neighbor node's right arm and right neighbor node's left arm
		//int nodeSpaceLen = (int)Math.pow(2.0,height);
		// starting space to the first node to print of each level (for the left most node of each level only)
		int startLen = branchLength; 
		
		Deque<node> nodesQueue = new ArrayDeque<node>();
		nodesQueue.add(inputNode);
		
		for (int i =1; i < height; i++) {
			printBranches(branchLength, nodeSpaceLen, startLen, nodesInThisLevel, nodesQueue);
			branchLength = branchLength/2;
			nodeSpaceLen = nodeSpaceLen/2;
			startLen = branchLength;
			printNodes(branchLength, nodeSpaceLen, startLen, nodesInThisLevel, nodesQueue);
			
			for(int j = 0; j < nodesInThisLevel; j++) {
				//node currNode = nodesQueue.getFirst();
				node currNode = nodesQueue.pop();
				if (currNode != null) {
					nodesQueue.addLast(currNode.getLeft());
					nodesQueue.addLast(currNode.getRight());
				}
				else {
					nodesQueue.addLast(null);
					nodesQueue.addLast(null);
				}				
			}
			nodesInThisLevel *= 2;
		}
		printBranches(branchLength, nodeSpaceLen, startLen, nodesInThisLevel, nodesQueue);
		printLeaves(level, nodesInThisLevel, nodesQueue);
	}
	
	public static void printBranches(int branchLen, int nodeSpaceLen, int startLen, 
			                         int nodesInThisLevel, final Deque<node> nodesQueue) {
		Iterator<node> it = nodesQueue.iterator();
		for (int i = 0; i < nodesInThisLevel/2; i++) {
		    System.out.print(String.format("%" + ((i == 0) ? startLen-1 : nodeSpaceLen-2) + "s", " ") + 
		    		((it.equals(null)) ? "/" : " "));
		    it.next();
		    int length = 2*branchLen+1;
		    System.out.print(String.format("%"+length+"s",""));
		    System.out.print((it.equals(null) ? " " : "\\"));
			//out << ((i == 0) ? setw(startLen-1) : setw(nodeSpaceLen-2)) << "" << ((*iter++) ? "/" : " ");
		    //out << setw(2*branchLen+2) << "" << ((*iter++) ? "\\" : " ");
		}
		System.out.println();
	}
	
	public static void printLeaves(int level, int nodesInThisLevel,
			                       Deque<node> nodesQueue) {
		Iterator<node> it = nodesQueue.iterator();
		for(int i = 0; i < nodesInThisLevel; i++,it.next()) {
			
		}
		System.out.println();
		/*
		 *   deque<BinaryTree*>::const_iterator iter = nodesQueue.begin();
  for (int i = 0; i < nodesInThisLevel; i++, iter++) {
    out << ((i == 0) ? setw(indentSpace+2) : setw(2*level+2)) << ((*iter) ? intToString((*iter)->data) : "");
  }
  out << endl;
		 */
	}
	
	public static void printNodes(int branchLen, int nodeSpaceLen, int startLen, 
			int nodesInThisLevel, final Deque<node>nodesQueue) {
		Iterator<node> myIt = nodesQueue.iterator();
		for(int i = 0; i < nodesInThisLevel; i ++) {
			
		}
	}
	
	public static int maxHeight(node input) {
		if(input == null) 
			return 0;
		int leftHeight  = maxHeight(input.getLeft());
		int rightHeight = maxHeight(input.getRight());
		return (leftHeight > rightHeight? leftHeight + 1 : rightHeight + 1);
	}
}
