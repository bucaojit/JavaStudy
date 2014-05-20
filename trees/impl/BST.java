package trees.impl;

import java.io.IOException;
import java.util.Iterator;
import java.util.Stack;

public class BST implements Iterable<Integer>{
	private node root;
	
	public BST(node root) {
		this.root = root;
	}
	
	public BST(int value) {
		this.root = new node(value);
	}
	
	public node root() {
		return root;
	}
	
	public void insert(int value) {
		if(root == null) {
			root = new node(value); 
			return;
		}
		insertNode(root, value);
	}
	
	public void insertNode(node currentNode, int value) {
		// if value > current Node, insert into right
		if (value > currentNode.data()) {
			if(currentNode.getRight() == null)  {
				currentNode.setRight(new node(value));
				return;
			}
			insertNode(currentNode.getRight(), value);
		}
		else {
			if(currentNode.getLeft() == null) {
				currentNode.setLeft(new node(value));
				return;
			}
			insertNode(currentNode.getLeft(), value);
		}
	}
	
	public void printTree() throws IOException {
		printTree(root);
		System.out.println("second print");
		anotherPrintTree(root);
	}
	
	public void printTree(node inputNode) throws IOException {
		if(inputNode == null) {
			return;
		}
		printTree(inputNode.getLeft());
		System.out.println("Data: " + inputNode.data());
		printTree(inputNode.getRight());
	}
	
	public void anotherPrintTree(node inputNode) throws IOException {
		BSTPrintPretty.printTree(inputNode);
	}
	
	public int maxHeight() {
		return maxHeight(root);
	}
	
	public int maxHeight(node input) {
		if(input == null) 
			return 0;
		int leftHeight  = maxHeight(input.getLeft());
		int rightHeight = maxHeight(input.getRight());
		return (leftHeight > rightHeight? leftHeight + 1 : rightHeight + 1);
	}
	
	public void traverseNonRecursive() {
		traverseNonRecursive(root);
	}

	public void traverseNonRecursive(node inputNode) {
		if (inputNode == null) 
			return;

		Stack<node> treeNodes = new Stack<node> ();

		node topNode = inputNode;
		do {
			// need a current node state so you don't traverse from wherever you are
			//node currentNode = treeNodes.peek();
			// left, root, right
			// remove item from top of stack
			//node topNode = treeNodes.pop();			
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
