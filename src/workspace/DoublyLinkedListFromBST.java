package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class DoublyLinkedListFromBST {
    /**
     * Convert the BST to doubly linked list
     * -- Method 1: obviously we can add each element in the BST into
     * the list
     * -- Method 2: reuse the node of the BST, this approach takes O(1) space
     * In this class, method 2 is implemented
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        BST tree = new BST();
        for(int i = 0; i < n; ++i)
            tree.add(in.nextInt());

        Node head = toDoublyLinkedList(tree);

        Node cur = head;
        while(cur != null) {
            out.print(cur + " ");
            cur = cur.right;
        }
        out.println();
    }

    Node toDoublyLinkedList(BST tree) {
        Node head = toDoublyLinkedList(tree, tree.root);
        // fix the head and the tail
        // in fact, we cut the circular link
        head.left.right = null;
        head.left = null;
        return head;
    }

    /**
     * Idea: at node cur, we want to connect cur.left with the
     * max of the left-subtree and cur.right to the min of the
     * right-subtree. The possible solution is to make the left(or right)
     * -subtree circular and return the head (so head=min and
     * head.left = max)
     */
    Node toDoublyLinkedList(BST tree, Node cur) {
        if(cur == null) return null;
        Node l_head = toDoublyLinkedList(tree, cur.left);
        Node r_head = toDoublyLinkedList(tree, cur.right);

        Node l_tail = null;
        if(l_head != null) {
            l_tail = l_head.left; // l_tail is now max of the left-subtree
            cur.left = l_tail;
            l_tail.right = cur;
        }
        else
            l_head = l_tail = cur; // circular list with 1 element

        Node r_tail = null;
        if(r_head != null) {
            r_tail = r_head.left; // r_tail is now min of the right-subtree
            cur.right = r_head;
            r_head.left = cur;
        }
        else
            r_head = r_tail = cur;

        // ensure the circular property
        l_head.left = r_tail;
        r_tail.right = r_head;

        return l_head;
    }

    static class Node {
        private int value;
        Node left, right;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "" + value;
        }
    }

    static class BST {
        Node root;

        public void add(int val) {
            if(root == null)
                root = new Node(val);
            else
                add(root, val);
        }

        Node add(Node cur, int val) {
            if(cur == null)
                return new Node(val);
            if(cur.value < val)
                cur.right = add(cur.right, val);
            else
                cur.left = add(cur.left, val);
            return cur;
        }

        @Override
        public String toString() {
            return "Pre-order: " + toString(root);
        }

        String toString(Node cur) {
            if(cur == null) return "";
            String mid = cur.toString();
            String left = toString(cur.left);
            String right = toString(cur.right);
            if(!left.isEmpty()) mid = mid + " " + left;
            if(!right.isEmpty()) mid = mid + " " + right;
            return mid;
        }
    }
}
