package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class DescendantAndAncestorBST {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), k = in.nextInt();
        BST tree = new BST();
        for(int i = 0; i < n; ++i)
            tree.add(in.nextInt());

        while(k-- > 0) {
            int x = in.nextInt(), a = in.nextInt(), b = in.nextInt();
            out.println(check(tree, x, a, b));
        }
    }

    /**
     * Check if a is ancestor and b is descendant of x or vice versa
     */
    boolean check(BST tree, int x, int a, int b) {
        boolean a_is_ancestor = check(tree, tree.findNode(a), x, b);
        boolean b_is_ancestor = check(tree, tree.findNode(b), x, a);
        return a_is_ancestor | b_is_ancestor;
    }

    boolean check(BST tree, Node cur, int target, int des) {
        if(cur == null) return false;
        if(cur.value == target) {
            Node descendant = tree.findNode(cur, des);
            return (descendant != null) ? true : false;
        }
        if(cur.value < target)
            return check(tree, cur.right, target, des);
        return check(tree, cur.left, target, des);
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
            if (root == null)
                root = new Node(val);
            else
                add(root, val);
        }

        Node add(Node cur, int val) {
            if (cur == null)
                return new Node(val);
            if (cur.value < val)
                cur.right = add(cur.right, val);
            else
                cur.left = add(cur.left, val);
            return cur;
        }

        Node findNode(int val) {
            return findNode(root, val);
        }

        Node findNode(Node cur, int val) {
            if(cur == null) return null;
            if(cur.value == val)
                return cur;
            if(cur.value < val)
                return findNode(cur.right, val);
            return findNode(cur.left, val);
        }

        @Override
        public String toString() {
            return "Pre-order: " + toString(root);
        }

        String toString(Node cur) {
            if (cur == null) return "";
            String mid = cur.toString();
            String left = toString(cur.left);
            String right = toString(cur.right);
            if (!left.isEmpty()) mid = mid + " " + left;
            if (!right.isEmpty()) mid = mid + " " + right;
            return mid;
        }
    }
}
