package trees.impl;


public class node {
	private node leftnode;
	private node rightnode;
	int data;
	
	public node(int data_input) {
		data = data_input;
	}
	
	public int data() {
		return data;
	}
	
	public node getRight() {
		return rightnode;
	}
	
	public node getLeft() {
		return leftnode;
	}
	
	public void setRight(node insert) {
		rightnode = insert;
	}
	
	public void setLeft(node insert) {
		leftnode = insert;
	}
			
}
