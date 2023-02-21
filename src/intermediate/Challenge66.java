package intermediate;

import java.util.NoSuchElementException;

/**
 * [6/18/2012] Challenge #66 [intermediate]
 *
 * Maxiphobic heaps are a variant of leftist heaps. Like leftist heaps, maxiphobic heaps are represented as binary trees
 * arranged according to the heap property that every element is less than or equal to its two children. Find-min looks
 * at the root of the tree, delete-min discards the root and merges its two children, and insert merges the existing
 * tree with a singleton tree containing the new element.
 *
 * The key to leftist trees and maxiphobic trees is the merge operation. In leftist trees, the rank of each left child
 * is always less than the rank of its sibling, where the rank of a node is defined as the length of its right spine,
 * and the merge operation enforces this invariant.
 *
 * In maxiphobic trees, the merge operation is implemented by comparing the roots of the two trees. The smaller root
 * survives as the root of the merged tree. That leaves three sub-trees: the tree that lost in the comparison of the
 * two roots, and the child sub-trees of the winner. They are merged by first merging the two smaller trees, where the
 * size of a tree is determined as the number of elements it contains, then attaching that merged tree along with the
 * remaining tree as the children of the new root.
 *
 * The name maxiphobic, meaning “biggest avoiding,” refers to the merge of the two smaller sub-trees.
 *
 * Your task is to write functions that implement maxiphobic trees.
 */
public class Challenge66 {

    private static class Node {
        int val;
        int size;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            this.size = 1;
        }

        private void printTree(Node node, int level) {
            if (node == null) {
                return;
            }
            for (int i = 0; i < level; i++) {
                System.out.print("  ");
            }
            System.out.println(node.val);
            printTree(node.right, level + 1);
            printTree(node.left, level + 1);
        }

        public void printAll() {
            printTree(this, 0);
            System.out.println();
        }
    }

    private Node root;

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        return node == null ? 0 : node.size;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int findMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("The Maxiphobic Tree is empty.");
        }
        return root.val;
    }

    public void insert(int val) {
        root = merge(new Node(val), root);
    }

    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("The Maxiphobic Tree is empty.");
        }
        root = merge(root.left, root.right);
    }

    private Node merge(Node node1, Node node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        if (node1.val > node2.val) {
            Node temp = node1;
            node1 = node2;
            node2 = temp;
        }
        node1.right = merge(node1.right, node2);
        if (size(node1.right) > size(node1.left)) {
            Node temp = node1.left;
            node1.left = node1.right;
            node1.right = temp;
        }
        node1.size = size(node1.left) + size(node1.right) + 1;
        return node1;
    }

    public static void main(String[] args) {
        Challenge66 challenge66 = new Challenge66();

        Node node1 = new Node(1);
        node1.left = new Node(3);
        node1.right = new Node(5);

        Node node2 = new Node(2);
        node2.left = new Node(4);
        node2.right = new Node(6);

        Node node3 = challenge66.merge(node1, node2);
        node3.printAll();
    }

}
