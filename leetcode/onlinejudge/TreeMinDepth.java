package leetcode.onlinejudge;

import trees.impl.BST;
import trees.impl.BSTPrintTree;
import trees.impl.Node;

/**
 * Created by Oliver on 10/20/14.
 */

/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path
from the root node down to the nearest leaf node.
 */
public class TreeMinDepth {

    public int minDepth(Node root) {
        if(root == null)
            return 0;

        int a = minDepth(root.getLeft());
        int b = minDepth(root.getRight());

        if(a==0 && b == 0)
            return 1;

        if(a==0 || b==0) {
            return a+b+1;
        }
        return 1 + Math.min(a,b);
    }
    public static void main(String[] args) {
        BST newTree = new BST(100);
        newTree.insert(55);
        newTree.insert(557);
        newTree.insert(5);
        newTree.insert(24);
        newTree.insert(600);
        newTree.insert(99);
        newTree.insert(558);
        //newTree.insert(56);

        BSTPrintTree.print(newTree.root());

        TreeMinDepth tmd = new TreeMinDepth();
        System.out.println("Minimum Depth: " + tmd.minDepth(newTree.root()));

    }
}
