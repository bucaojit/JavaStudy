package trees.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Initial code taken from StackOverflow: 
// http://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
// To print the binary tree diagram.
// Helpful for developing tree problems
// Modified to fit my tree implementation

class myNode<T extends Comparable<?>> {
    myNode<T> left, right;
    T data;

    public myNode(T data) {
        this.data = data;
    }
}

class BTreePrinterImp {

    public static <T extends Comparable<?>> void printmyNode(myNode<T> root) {
        int maxLevel = BTreePrinterImp.maxLevel(root);

        printmyNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printmyNodeInternal(List<myNode<T>> myNodes, int level, int maxLevel) {
        if (myNodes.isEmpty() || BTreePrinterImp.isAllElementsNull(myNodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinterImp.printWhitespaces(firstSpaces);

        List<myNode<T>> newmyNodes = new ArrayList<myNode<T>>();
        for (myNode<T> myNode : myNodes) {
            if (myNode != null) {
                System.out.print(myNode.data);
                newmyNodes.add(myNode.left);
                newmyNodes.add(myNode.right);
            } else {
                newmyNodes.add(null);
                newmyNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinterImp.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < myNodes.size(); j++) {
                BTreePrinterImp.printWhitespaces(firstSpaces - i);
                if (myNodes.get(j) == null) {
                    BTreePrinterImp.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (myNodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTreePrinterImp.printWhitespaces(1);

                BTreePrinterImp.printWhitespaces(i + i - 1);

                if (myNodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreePrinterImp.printWhitespaces(1);

                BTreePrinterImp.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printmyNodeInternal(newmyNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(myNode<T> myNode) {
        if (myNode == null)
            return 0;

        return Math.max(BTreePrinterImp.maxLevel(myNode.left), BTreePrinterImp.maxLevel(myNode.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}

public class BTreePrinter {

    private static myNode<Integer> test1() {
        myNode<Integer> root = new myNode<Integer>(2);
        myNode<Integer> n11 = new myNode<Integer>(7);
        myNode<Integer> n12 = new myNode<Integer>(5);
        myNode<Integer> n21 = new myNode<Integer>(2);
        myNode<Integer> n22 = new myNode<Integer>(6);
        myNode<Integer> n23 = new myNode<Integer>(3);
        myNode<Integer> n24 = new myNode<Integer>(6);
        myNode<Integer> n31 = new myNode<Integer>(5);
        myNode<Integer> n32 = new myNode<Integer>(8);
        myNode<Integer> n33 = new myNode<Integer>(4);
        myNode<Integer> n34 = new myNode<Integer>(5);
        myNode<Integer> n35 = new myNode<Integer>(8);
        myNode<Integer> n36 = new myNode<Integer>(4);
        myNode<Integer> n37 = new myNode<Integer>(5);
        myNode<Integer> n38 = new myNode<Integer>(8);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;
        n12.left = n23;
        n12.right = n24;

        n21.left = n31;
        n21.right = n32;
        n22.left = n33;
        n22.right = n34;
        n23.left = n35;
        n23.right = n36;
        n24.left = n37;
        n24.right = n38;

        return root;
    }

    private static myNode<Integer> test2() {
        myNode<Integer> root = new myNode<Integer>(2);
        myNode<Integer> n11 = new myNode<Integer>(7);
        myNode<Integer> n12 = new myNode<Integer>(5);
        myNode<Integer> n21 = new myNode<Integer>(2);
        myNode<Integer> n22 = new myNode<Integer>(6);
        myNode<Integer> n23 = new myNode<Integer>(9);
        myNode<Integer> n31 = new myNode<Integer>(5);
        myNode<Integer> n32 = new myNode<Integer>(8);
        myNode<Integer> n33 = new myNode<Integer>(4);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;

        n12.right = n23;
        n22.left = n31;
        n22.right = n32;

        n23.left = n33;

        return root;
    }

    public static void main(String[] args) {

        BTreePrinterImp.printmyNode(test1());
        BTreePrinterImp.printmyNode(test2());

    }
}