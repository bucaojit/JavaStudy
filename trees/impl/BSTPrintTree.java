package trees.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Initial code taken from StackOverflow: 
//http://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
//To print the binary tree diagram.
//Helpful for developing tree problems
//Modified to fit my tree implementation

public class BSTPrintTree {
    public static void print(Node root) {
        int maxLevel = BSTPrintTree.maxLevel(root);

        printmyNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printmyNodeInternal(List<Node> myNodes, int level, int maxLevel) {
        if (myNodes.isEmpty() || BSTPrintTree.isAllElementsNull(myNodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BSTPrintTree.printWhitespaces(firstSpaces);

        List<Node> newmyNodes = new ArrayList<Node>();
        for (Node myNode : myNodes) {
            if (myNode != null) {
                System.out.print(myNode.data);
                newmyNodes.add(myNode.getLeft());
                newmyNodes.add(myNode.getRight());
            } else {
                newmyNodes.add(null);
                newmyNodes.add(null);
                System.out.print(" ");
            }

            BSTPrintTree.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < myNodes.size(); j++) {
                BSTPrintTree.printWhitespaces(firstSpaces - i);
                if (myNodes.get(j) == null) {
                    BSTPrintTree.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (myNodes.get(j).getLeft() != null)
                    System.out.print("/");
                else
                    BSTPrintTree.printWhitespaces(1);

                BSTPrintTree.printWhitespaces(i + i - 1);

                if (myNodes.get(j).getRight() != null)
                    System.out.print("\\");
                else
                    BSTPrintTree.printWhitespaces(1);

                BSTPrintTree.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printmyNodeInternal(newmyNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static int maxLevel(Node myNode) {
        if (myNode == null)
            return 0;

        return Math.max(BSTPrintTree.maxLevel(myNode.getLeft()), BSTPrintTree.maxLevel(myNode.getRight())) + 1;
    }

    
    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }
    
}
