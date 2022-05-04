//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package datastructures;

import java.util.ArrayList;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> implements IBSearchTree<E> {
    public BinarySearchTree() {
    }

    public void createBalancedTree(ArrayList<E> dataList, int leftCurrentRange, int rightCurrentRange) {
        this.root = this.balancedTree(dataList, leftCurrentRange, rightCurrentRange);
    }

    public Node<E> balancedTree(ArrayList<E> dataList, int leftCurrentRange, int rightCurrentRange) {
        if (leftCurrentRange > rightCurrentRange) {
            return null;
        } else {
            int mid = (leftCurrentRange + rightCurrentRange) / 2;
            Node<E> aNode = new Node(dataList.get(mid));
            aNode.leftNode = this.balancedTree(dataList, leftCurrentRange, mid - 1);
            aNode.rightNode = this.balancedTree(dataList, mid + 1, rightCurrentRange);
            return aNode;
        }
    }

    public void addNode(E theItem) {
        this.root = this.addNode(this.root, theItem);
    }

    private Node<E> addNode(Node<E> localRoot, E theItem) {
        if (localRoot == null) {
            System.out.println("Item has been inserted in the BST!\n");
            return new Node(theItem);
        } else if (theItem.compareTo(localRoot.getNodeData()) == 0) {
            System.out.println("Item already exists in the BST!");
            return localRoot;
        } else if (theItem.compareTo(localRoot.getNodeData()) < 0) {
            localRoot.leftNode = this.addNode(localRoot.leftNode, theItem);
            return localRoot;
        } else {
            localRoot.rightNode = this.addNode(localRoot.rightNode, theItem);
            return localRoot;
        }
    }

    public boolean nodeContains(E desiredItem) {
        return this.findItem(desiredItem) != null;
    }

    public E findItem(E desiredItem) {
        return this.findItem(this.root, desiredItem);
    }

    private E findItem(Node<E> localRoot, E desiredItem) {
        if (localRoot == null) {
            return null;
        } else {
            int compResult = desiredItem.compareTo(localRoot.getNodeData());
            if (compResult == 0) {
                return (E) localRoot.getNodeData();
            } else {
                return compResult < 0 ? this.findItem(localRoot.leftNode, desiredItem) : this.findItem(localRoot.rightNode, desiredItem);
            }
        }
    }

    public E deleteNode(E desiredItem) {
        this.root = this.deleteNode(this.root, desiredItem);
        return (E) this.root.getNodeData();
    }

    private Node<E> deleteNode(Node<E> localRoot, E desiredItem) {
        if (localRoot == null) {
            return localRoot;
        } else {
            int compResult = desiredItem.compareTo(localRoot.nodeData);
            if (compResult < 0) {
                localRoot.leftNode = this.deleteNode(localRoot.leftNode, desiredItem);
            } else if (compResult > 0) {
                localRoot.rightNode = this.deleteNode(localRoot.rightNode, desiredItem);
            } else {
                if (localRoot.leftNode == null) {
                    return localRoot.rightNode;
                }

                if (localRoot.rightNode == null) {
                    return localRoot.leftNode;
                }

                localRoot.nodeData = this.inOrderSuccessor(localRoot.rightNode);
                localRoot.rightNode = this.deleteNode(localRoot.rightNode, (E) localRoot.nodeData);
            }

            return localRoot;
        }
    }

    private E inOrderSuccessor(Node<E> localRoot) {
        if (localRoot.leftNode.leftNode == null) {
            E minimum = (E) localRoot.leftNode.nodeData;
            localRoot.leftNode = localRoot.leftNode.rightNode;
            return minimum;
        } else {
            return this.inOrderSuccessor(localRoot.leftNode);
        }
    }

    public boolean removeNode(E desiredItem) {
        return this.deleteNode(desiredItem) != null;
    }
}
