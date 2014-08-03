package trees;

import trees.impl.BST;
import trees.impl.Node;

/*
 * Given a binary tree in which each node element contains a number. 
 * Find the maximum possible sum from one leaf node to another.
 * The maximum sum path may or may not go through root. 
 * For example, in the following binary tree, 
 * the maximum sum is 27(3 + 6 + 9 + 0 – 1 + 10). 
 * 
 * Expected time complexity is O(n).
 * 
 */
public class MaxPathSumBetweenLeaves {
	// In the example a binary tree is used as opposed to a binary search tree
	// If BST, certain properties can be used for optimization such as knowing 
	//    that the larger values go on the right side of the tree. Start on the right
	//    side first. 
	// For this solution, will not consider those and keep it simple. 
	
	// Algorithm:
	// Have to save current state as we visit each node
	// For each node we will get the max of the left tree and the right tree
	// Add that to the current node, if it is larger than the 'largest'
	// sum, then we replace that sum and check the next node.
	// 
	// For improvements we can apply dynamic programming techniques by
	// saving values as well in the nodes.  Start at the leaf nodes and calculate 
	// their values first before the root nodes.
	
	// First step is to solve it in a simple way
	
	public int maxValue;
	
	
	public MaxPathSumBetweenLeaves() {
		maxValue = 0;
	}
	public void maxPath(BST tree) {
		maxSum(tree.root());
	}
	public int maxSum(Node root) {
		return 0;
		/*
		 * 	public int maxHeight(Node input) {
		if(input == null) 
			return 0;
		int leftHeight  = maxHeight(input.getLeft());
		int rightHeight = maxHeight(input.getRight());
		return (leftHeight > rightHeight? leftHeight + 1 : rightHeight + 1);
	}
		 */
	}
	
	

}
