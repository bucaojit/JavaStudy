package trees.impl;

import java.io.IOException;
import java.util.Iterator;

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

	@Override
	public Iterator iterator() {
		BSTiterator myIterator = new BSTiterator(this);
		return myIterator;
	}
}
