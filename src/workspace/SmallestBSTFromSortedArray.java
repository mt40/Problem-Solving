package workspace;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Stack;

public class SmallestBSTFromSortedArray {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        BST tree = shortest(a);
        out.println(tree);
    }

    BST shortest(int []a) {
        BST tree = new BST();
        shortest(tree, a, 0, a.length - 1);
        return tree;
    }

    void shortest(BST tree, int []a, int l, int r) {
        if(l > r) return;
        int mid = l + (r - l) / 2;
        tree.add(a[mid]);
        shortest(tree, a, l, mid - 1);
        shortest(tree, a, mid + 1, r);
    }

    static class BST {
        static class Node {
            private int value;
            Node left, right;

            public Node(int value) {
                this.value = value;
            }

            @Override
            public String toString() {
                return "" + value;
            }
        }

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
