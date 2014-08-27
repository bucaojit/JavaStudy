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
				// Current node that we are pointing to exists, add it to the stack
				// Move pointer to the LEFT child even if it is NULL, 
				//     we will know on next iteration
				stack.addFirst(currentNode);
				currentNode = currentNode.getLeft();
			}
			else {
				// The node we pointed to was NULL, so we have to refer back to
				//     the stack for the next node to process.  We will not check
				//     the left child because that would have already been added to 
				//     stack.  We will instead check if a right child exists by 
				//     setting current node to the right child.
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
		
		System.out.println("Tree Size = " + tree.treeSize());
	}
}
