package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class LCAinBST {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), k = in.nextInt();
        BST tree = new BST();
        for (int i = 0; i < n; ++i)
            tree.add(in.nextInt());

        // a is always <= b
        while (k-- > 0) {
            int a = in.nextInt(), b = in.nextInt();
            out.println(lca(tree, a, b));
        }
    }

    int lca(BST tree, int a, int b) {
        if(tree.root == null)
            return Integer.MIN_VALUE;
        return lca(tree, tree.root, a, b);
    }

    int lca(BST tree, Node cur, int a, int b) {
        if (a <= cur.value && cur.value <= b)
            return cur.value;
        if (cur.value <= a)
            return lca(tree, cur.right, a, b);
        return lca(tree, cur.left, a, b);
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
