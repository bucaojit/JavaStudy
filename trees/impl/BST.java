package trees.impl;

import java.io.IOException;
import java.util.Iterator;
import java.util.Stack;

public class BST implements Iterable<Integer>{
	private Node root;
	
	public BST(Node root) {
		this.root = root;
	}
	
	public BST(int value) {
		this.root = new Node(value);
	}
	
	public Node root() {
		return root;
	}
	
	public Node findNode(int value) {
		return findNode(root, value);
	}
	
	public Node findNode(Node currentNode, int value) {
		if (currentNode == null) 
			return null;
		if (currentNode.data() == value) 
			return currentNode;
		if (value > currentNode.data())
			return findNode(currentNode.getRight(), value);
		else
			return findNode(currentNode.getLeft(), value);
	}
	
	// To delete, need to find the parent
	public Node findParent(int value) {
				
		return findParent(root, value);
	}
	
	public Node findParent(Node currentNode, int value) {
		if (currentNode == null) {
			return null;
		}
		if(currentNode.data() == value) {
			// Cannot get parent, root is parent
			return null;
		}
		if((currentNode.getLeft().data() == value) || currentNode.getRight().data() == value) {
			return currentNode;
		}
		if(value > currentNode.data()) {
			return findParent(currentNode.getRight(), value);
		}
		else
			return findParent(currentNode.getLeft(), value);
	}
	
	public void delete(int value) {
		if(root == null) {
			return;
		}
		delete(root, value);
	}
	
	/*
	  1. the value to remove is a leaf Node; or
      2. the value to remove has a right subtree, but no left subtree; or
      3. the value to remove has a left subtree, but no right subtree; or
      4. the value to remove has both a left and right subtree in which case we
         promote the largest value in the left subtree.
	 */
	public void delete(Node currentNode, int value) {
		if(currentNode == null) {
			return;
		}
		Node parent = findParent(value);
		
		
	}
	
	public void insert(int value) {
		if(root == null) {
			root = new Node(value); 
			return;
		}
		insertNode(root, value);
	}
	
	public void insertNode(Node currentNode, int value) {
		// if value > current Node, insert into right
		if (value > currentNode.data()) {
			if(currentNode.getRight() == null)  {
				currentNode.setRight(new Node(value));
				return;
			}
			insertNode(currentNode.getRight(), value);
		}
		else {
			if(currentNode.getLeft() == null) {
				currentNode.setLeft(new Node(value));
				return;
			}
			insertNode(currentNode.getLeft(), value);
		}
	}
	
	public void printTree() throws IOException {
		printTree(root);
		//System.out.println("second print");
		//anotherPrintTree(root);
	}
	
	public void printTree(Node inputNode) throws IOException {
		if(inputNode == null) {
			return;
		}
		printTree(inputNode.getLeft());
		System.out.println("Data: " + inputNode.data());
		printTree(inputNode.getRight());
	}
	
	public void anotherPrintTree(Node inputNode) throws IOException {
		BSTPrintPretty.printTree(inputNode);
	}
	
	public int maxHeight() {
		return maxHeight(root);
	}
	
	public int maxHeight(Node input) {
		if(input == null) 
			return 0;
		int leftHeight  = maxHeight(input.getLeft());
		int rightHeight = maxHeight(input.getRight());
		return (leftHeight > rightHeight? leftHeight + 1 : rightHeight + 1);
	}
	
	public void traverseNonRecursive() {
		traverseNonRecursive(root);
	}

	public void traverseNonRecursive(Node inputNode) {
		if (inputNode == null) 
			return;

		Stack<Node> treeNodes = new Stack<Node> ();

		Node topNode = inputNode;
		do {
			// need a current Node state so you don't traverse from wherever you are
			//Node currentNode = treeNodes.peek();
			// left, root, right
			// remove item from top of stack
			//Node topNode = treeNodes.pop();			
			// if left, add to stack
			if(topNode != null) {
				treeNodes.add(topNode);
				topNode = topNode.getLeft();
				//continue;
			}		
			else {
				// else remove from stack, print data
				topNode = treeNodes.pop();
				System.out.println("Data: " + topNode.data);									
				topNode = topNode.getRight();

			}
		}while(treeNodes.size() > 0 || topNode != null);
	}
	
	
	@Override
	public Iterator iterator() {
		BSTiterator myIterator = new BSTiterator(this);
		return myIterator;
	}
}
