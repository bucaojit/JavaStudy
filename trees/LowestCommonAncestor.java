package trees;

import trees.impl.BST;
import trees.impl.BSTPrintPretty2;
import trees.impl.Node;

/*
	PROBLEM  Given the value of two Nodes in a binary search tree, find the lowest
	(nearest) common ancestor. You may assume that both values already exist in
	the tree.
	For example, using the tree shown in Figure 5-7, assume 4 and 14 are the two
	given Nodes. The lowest common ancestor would be 8 because it’s an ancestor to
	both 4 and 14, and there is no Node lower on the tree that is an ancestor to both 4
	and 14.
 */
public class LowestCommonAncestor {
	
	// recursion -- best method for tree work
	// Algorithm: The first value that is encountered that is in between the 
	//            two values will be the lowest common ancestor.
	//            so we can check if:
	//            firstValue < value && secondValue > value 
	//            ||
	//            secondValue < value && firstValue > value
	//            then it will be the lowest Common, if traversing from the root
	//            BFS or DFS shouldn't matter 
	                               
	public void findLowestCommon(Node currentNode, int firstValue, int secondValue) {
		// What is the best traversal method?
		// We can add optimization to go where we think the value would be
		// Follow the Binary tree properties.  
		// -Looking for the value in-between firstValue and secondValue.  
		//    -Does it make more sense to check only the branches that are within the range
		//     of the values, saves unnecessary accesses, unless one value is largest
		//     and another value is the smallest
		
	}
	
	public static void main(String[] args) {
		BST tree = new BST(20);
		tree.insert(100);
		tree.insert(3);
		tree.insert(50);
		tree.insert(4);
		tree.insert(120);
		try {
			tree.printTree(); 	
			BSTPrintPretty2.printTreePretty(tree.root());
		} catch (Exception e) {			
		}
		
	}
	
}