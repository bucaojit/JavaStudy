package trees;

import java.util.Deque;
import java.util.LinkedList;

import trees.impl.BST;
import trees.impl.BSTPrintTree;
import trees.impl.Node;

public class TraverseWithoutRecursion {

	public static void traversal(Node root) {
		// In-order first: left, root, right
		
		// Deque methods for stack: 
		//       addFirst, removeFirst, peekFirst
		Deque<Node> stack = new LinkedList<Node>();
		
		Node currentNode = root;
		while(!stack.isEmpty() || currentNode != null) {
			if(currentNode != null) {
				stack.addFirst(currentNode);
				currentNode = currentNode.getLeft();
			}
			else {
				currentNode = stack.removeFirst();
				System.out.println("Value: " + currentNode.data());
				currentNode = currentNode.getRight();
			}
		}
	}
	
	public static void main(String[] args) {
		BST tree = new BST(50);
		tree.insert(10);
		tree.insert(51);
		tree.insert(60);
		tree.insert(1);
		tree.insert(100);
		
		BSTPrintTree.print(tree.root());
		TraverseWithoutRecursion.traversal(tree.root());
	}
}
