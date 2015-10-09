package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class BST_FromPreorderTraversal {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []preorder = new int[n];
        for(int i = 0; i < n; ++i)
            preorder[i] = in.nextInt();

        BST tree = reconstruct(preorder);
        out.println(tree);
    }

    BST reconstruct(int []preorder) {
        BST tree = new BST();
        tree.root = reconstruct(preorder, 0, preorder.length - 1);
        return tree;
    }

    Node reconstruct(int []preorder, int l, int r) {
        if(l > r) return null;
        Node root = new Node(preorder[l]);
        int i = l + 1;
        while(i < preorder.length && preorder[i] < preorder[l])
            i++;
        root.left = reconstruct(preorder, l + 1, i - 1);
        root.right = reconstruct(preorder, i, r);
        return root;
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
        int size;

        public void add(int val) {
            size++;
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
