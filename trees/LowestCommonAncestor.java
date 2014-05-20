package trees;

import trees.impl.BST;
import trees.impl.BSTPrintPretty2;
import trees.impl.node;

/*
	PROBLEM  Given the value of two nodes in a binary search tree, find the lowest
	(nearest) common ancestor. You may assume that both values already exist in
	the tree.
	For example, using the tree shown in Figure 5-7, assume 4 and 14 are the two
	given nodes. The lowest common ancestor would be 8 because it’s an ancestor to
	both 4 and 14, and there is no node lower on the tree that is an ancestor to both 4
	and 14.
 */
public class LowestCommonAncestor {
	
	// recursion -- best method for tree work
	public void findLowestCommon(node currentNode, int firstValue, int secondValue) {
		
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