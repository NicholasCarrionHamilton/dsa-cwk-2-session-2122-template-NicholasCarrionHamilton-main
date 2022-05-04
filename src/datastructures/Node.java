
package datastructures;

public class Node<E> {
    public E nodeData;
    public Node<E> leftNode;
    public Node<E> rightNode;

    public Node() {
        this.nodeData = null;
        this.leftNode = null;
        this.rightNode = null;
    }

    public Node(E data) {
        this.nodeData = data;
        this.leftNode = null;
        this.rightNode = null;
    }

    public E getNodeData() {
        return this.nodeData;
    }

    public void setNodeData(E nodeData) {
        this.nodeData = nodeData;
    }

    public Node<E> getLeftNode() {
        return this.leftNode;
    }

    public void setLeftNode(Node<E> leftNode) {
        this.leftNode = leftNode;
    }

    public Node<E> getRightNode() {
        return this.rightNode;
    }

    public void setRightNode(Node<E> rightNode) {
        this.rightNode = rightNode;
    }

    public String toString() {
        return this.nodeData.toString();
    }
}