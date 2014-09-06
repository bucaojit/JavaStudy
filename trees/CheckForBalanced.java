package trees;

import trees.impl.BST;
import trees.impl.BSTPrintTree;
import trees.impl.Node;

public class CheckForBalanced {
	
	public static boolean isBalanced(Node a) {
		if(a == null) {
			return true;
		}
		if(Math.abs(BST.maxHeight(a.getLeft()) - 
				    BST.maxHeight(a.getRight())) > 1)
				    return false;
		
		return(isBalanced(a.getLeft()) && isBalanced(a.getRight()));		
	}
	
	
	public static void main(String[] args) {
		BST myTree = new BST(50);
		System.out.println("Beginning Unit Test...\n");
		myTree.insert(5);			
		myTree.insert(55);				
		myTree.insert(42);				
		myTree.insert(71);				
		myTree.insert(72);
		myTree.insert(3);
		myTree.insert(53);
		BSTPrintTree.print(myTree.root());		
		System.out.println("Running isBalanced() method. Is tree balanced: " +
		    CheckForBalanced.isBalanced(myTree.root()));
	}
}
