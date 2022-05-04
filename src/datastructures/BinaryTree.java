//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package datastructures;

public class BinaryTree<E> {
    protected Node<E> root;

    public BinaryTree() {
        this.root = new Node();
    }

    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
        this.root = new Node(data);
        if (leftTree != null) {
            this.root.leftNode = leftTree.root;
        } else {
            this.root.leftNode = null;
        }

        if (rightTree != null) {
            this.root.rightNode = rightTree.root;
        } else {
            this.root.rightNode = null;
        }

    }

    public Node<E> getRoot() {
        return this.root;
    }

    public void setRoot(Node<E> root) {
        this.root = root;
    }

    private BinaryTree(Node<E> root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public BinaryTree<E> getLeftTree() {
        return this.root != null && this.root.leftNode != null ? new BinaryTree(this.root.leftNode) : null;
    }

    public BinaryTree<E> getRightTree() {
        return this.root != null && this.root.rightNode != null ? new BinaryTree(this.root.rightNode) : null;
    }

    public E getItemData() {
        return !this.isEmpty() ? this.root.getNodeData() : null;
    }

    public boolean isLeaf() {
        return this.root == null || this.root.leftNode == null && this.root.rightNode == null;
    }

    public String toString() {
        if (this.root == null) {
            throw new NullPointerException("The tree is empty!");
        } else {
            StringBuilder sb = new StringBuilder();
            this.preOrderTraversal(this.root, 1, sb);
            return sb.toString();
        }
    }

    private void preOrderTraversal(Node<E> node, int depth, StringBuilder sb) {
        for(int i = 1; i < depth; ++i) {
            sb.append("  ");
        }

        if (node == null) {
            sb.append("null\n");
        } else {
            sb.append(node.toString());
            sb.append("\n");
            this.preOrderTraversal(node.leftNode, depth + 1, sb);
            this.preOrderTraversal(node.rightNode, depth + 1, sb);
        }

    }

    public String preorderTraversal() {
        StringBuilder printTree = new StringBuilder();
        this.preorderTraversal(printTree, this.root);
        return printTree.toString();
    }

    private void preorderTraversal(StringBuilder stb, Node<E> root) {
        stb.append(root.getNodeData().toString());
        if (root.leftNode != null) {
            stb.append("\n");
            this.preorderTraversal(stb, root.leftNode);
        }

        if (root.rightNode != null) {
            stb.append("\n");
            this.preorderTraversal(stb, root.rightNode);
        }

    }

    public E preorderTraversal(Node<E> root) {
        if (root.leftNode != null) {
            this.preorderTraversal(root.leftNode);
        }

        if (root.rightNode != null) {
            this.preorderTraversal(root.rightNode);
        }

        return root.getNodeData();
    }

    public String inorderTraversal() {
        StringBuilder stb = new StringBuilder();
        this.inorderTraversal(stb, this.root);
        return stb.toString();
    }

    private void inorderTraversal(StringBuilder stb, Node<E> root) {
        if (root.leftNode != null) {
            this.inorderTraversal(stb, root.leftNode);
        }

        stb.append(root);
        stb.append("\n");
        if (root.rightNode != null) {
            this.inorderTraversal(stb, root.rightNode);
        }

    }

    public String postorderTraversal() {
        StringBuilder stb = new StringBuilder();
        this.postorderTraversal(stb, this.root);
        return stb.toString();
    }

    private void postorderTraversal(StringBuilder stb, Node<E> root) {
        if (root.leftNode != null) {
            this.postorderTraversal(stb, root.leftNode);
        }

        if (root.rightNode != null) {
            this.postorderTraversal(stb, root.rightNode);
        }

        stb.append(root);
        stb.append("\n");
    }
}
