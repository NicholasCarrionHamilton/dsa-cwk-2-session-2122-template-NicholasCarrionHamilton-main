//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package view;

import datastructures.BinarySearchTree;
import datastructures.Node;
import helpers.OutputHelper;
import model.DisplayOrder;
import model.StudentMarks;

public class aView {
    public aView() {
    }

    public void displayBSTItemAsc(Node<StudentMarks> root) {
        if (root.leftNode != null) {
            this.displayBSTItemAsc(root.leftNode);
        }

        System.out.format("| %-20s | %-75s |\n", ((StudentMarks)root.getNodeData()).getStudentID(), ((StudentMarks)root.getNodeData()).getGivenName());
        if (root.rightNode != null) {
            this.displayBSTItemAsc(root.rightNode);
        }

    }

    public void displayBSTItemDesc(Node<StudentMarks> root) {
        if (root.rightNode != null) {
            this.displayBSTItemDesc(root.rightNode);
        }

        System.out.format("| %-20s | %-75s |\n", ((StudentMarks)root.getNodeData()).getStudentID(), ((StudentMarks)root.getNodeData()).getGivenName());
        if (root.leftNode != null) {
            this.displayBSTItemDesc(root.leftNode);
        }

    }

    public void displayBSTItemPreorder(Node<StudentMarks> root) {
        System.out.format("| %-20s | %-75s |\n", ((StudentMarks)root.getNodeData()).getStudentID(), ((StudentMarks)root.getNodeData()).getGivenName());
        if (root.rightNode != null) {
            this.displayBSTItemDesc(root.rightNode);
        }

        if (root.leftNode != null) {
            this.displayBSTItemDesc(root.leftNode);
        }

    }

    public void displayBSTItemPostorder(Node<StudentMarks> root) {
        if (root.rightNode != null) {
            this.displayBSTItemDesc(root.rightNode);
        }

        if (root.leftNode != null) {
            this.displayBSTItemDesc(root.leftNode);
        }

        System.out.format("| %-20s | %-75s |\n", ((StudentMarks)root.getNodeData()).getStudentID(), ((StudentMarks)root.getNodeData()).getGivenName());
    }

    public void displayBST(BinarySearchTree<StudentMarks> theBST, DisplayOrder order) {
        System.out.println(OutputHelper.repeat("-", 102));
        System.out.format("| %-20s | %-75s |\n", "Term", "Definition");
        System.out.println(OutputHelper.repeat("-", 102));
        switch(order) {
            case ASCENDING:
                this.displayBSTItemAsc(theBST.getRoot());
                break;
            case DESCENDING:
                this.displayBSTItemDesc(theBST.getRoot());
                break;
            case PREORDER:
                this.displayBSTItemPreorder(theBST.getRoot());
                break;
            case POSTORDER:
                this.displayBSTItemPostorder(theBST.getRoot());
                break;
            default:
                System.out.println("Oops! Something has went wrong!");
        }

        System.out.println(OutputHelper.repeat("-", 102));
    }

    public void displayABSTItem(StudentMarks anItem) {
        System.out.println(OutputHelper.repeat("-", 102));
        System.out.format("| %-20s | %-20s | %-5s |\n", "Term", "Definition");
        System.out.println(OutputHelper.repeat("-", 102));
        System.out.format("| %-20s | %-20s | %2d |\n", anItem.getStudentID(), anItem.getGivenName());
        System.out.println(OutputHelper.repeat("-", 102));
    }
}
