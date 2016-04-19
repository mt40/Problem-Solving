package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

/**
 * Build a Binary Search Tree from a sorted array
 */
public class SortedArrayToBST {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []a = in.arr(n);

        BST tree = new BST();
        tree.root = build(a, 0, a.length - 1);

        out.println(1);
    }

    Node build(int []a, int low, int hi) {
        if(low > hi)
            return null;
        int mid = (low + hi) >>> 1;
        Node cur = new Node(a[mid]);
        cur.left = build(a, low, mid - 1);
        cur.right = build(a, mid + 1, hi);
        return cur;
    }

    class BST {
        Node root;

        void add(int key) {
            root = add(root, key);
        }

        Node add(Node cur, int key) {
            if(cur == null)
                return new Node(key);
            if(cur.key < key)
                cur.right = add(cur.right, key);
            else
                cur.left = add(cur.left, key);
            return cur;
        }
    }

    class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return key + "";
        }
    }
}