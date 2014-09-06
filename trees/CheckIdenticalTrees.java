package trees;

import trees.impl.BST;
import trees.impl.Node;

public class CheckIdenticalTrees {
	
	public static boolean checkIdentical(Node a, Node b) {
		if((a == null && b != null) || (a!= null && b == null))
			return false;
		if(a == null && b == null) 
			return true;
		
		if((a.data() == b.data()) && 
			checkIdentical(a.getLeft(), b.getLeft()) && 
		    checkIdentical(a.getRight(), b.getRight()))
			return true;
		else 
			return false;		 						
	}
	
	public static void main(String[] args) {
		BST firstTree = new BST(50), secondTree = new BST(50);
		System.out.println("Beginning Unit Test...\n");
		firstTree.insert(5);
		secondTree.insert(5);		
		firstTree.insert(55);
		secondTree.insert(55);		
		firstTree.insert(42);
		secondTree.insert(42);		
		firstTree.insert(71);
		secondTree.insert(71);		
		firstTree.insert(72);
		secondTree.insert(72);
		System.out.println("Values entered in identical tree");
		System.out.println("Running checkIdentical() method. Are the trees identical: " +
		    CheckIdenticalTrees.checkIdentical(firstTree.root(), secondTree.root()));
		System.out.println();
		
		System.out.println("Adding differing values to trees to make not identical, and different node balances");
		firstTree.insert(333);
		secondTree.insert(444);
		firstTree.insert(111);
		
		System.out.println("Running checkIdentical() method. Are the trees identical: " +
			    CheckIdenticalTrees.checkIdentical(firstTree.root(), secondTree.root()));
		
	}
}
