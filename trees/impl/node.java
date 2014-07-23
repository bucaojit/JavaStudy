package trees.impl;


public class Node {
	private Node leftNode;
	private Node rightNode;
	int data;
	
	public Node(int data_input) {
		data = data_input;
	}
	
	public int data() {
		return data;
	}
	
	public Node getRight() {
		return rightNode;
	}
	
	public Node getLeft() {
		return leftNode;
	}
	
	public void setRight(Node insert) {
		rightNode = insert;
	}
	
	public void setLeft(Node insert) {
		leftNode = insert;
	}
			
}
