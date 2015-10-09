package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class BinaryTreeReconstruction2 {
    /**
     * Given an inorder and post-order traversal,
     * reconstruct the binary tree
     */
    char []inorder, postorder;
    int n;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        n = in.nextInt();
        inorder = new char[n];
        postorder = new char[n];
        for(int i = 0; i < n; ++i) inorder[i] = in.next().charAt(0);
        for(int i = 0; i < n; ++i) postorder[i] = in.next().charAt(0);

        BinaryTree tree = new BinaryTree();
        tree.root = reconstruct();

        out.println(tree);
    }

    Node reconstruct() {
        if(n == 0) return null;
        Node root = new Node(postorder[n - 1]);
        reconstruct(root, n - 1, 0, n - 1);
        return root;
    }

    Node reconstruct(Node cur, int p, int l, int r) {
        if(p == 0) return null;
        int i = find(inorder, postorder[p]);
        if(i < r) {
            cur.right = new Node(postorder[p - 1]);
            reconstruct(cur.right, p - 1, i + 1, r);
        }
        if(i > l) {
            int pos = p - (r - i) - 1;
            cur.left = new Node(postorder[pos]);
            reconstruct(cur.left, pos, l, i - 1);
        }
        return cur;
    }

    int find(char []arr, char c) {
        for(int i = 0; i < arr.length; ++i) {
            if(arr[i] == c)
                return i;
        }
        return -1;
    }

    class Node {
        char value;
        Node left, right;
        public Node(char val) {
            value = val;
        }

        @Override
        public String toString() {
            return "" + value;
        }
    }

    class BinaryTree {
        Node root;

        @Override
        public String toString() {
            return toString(root);
        }

        // Pre-order
        String toString(Node cur) {
            if(cur == null) return "";
            String mid = cur.toString();
            String left = toString(cur.left);
            String right = toString(cur.right);
            if(!left.isEmpty()) mid += " " + left;
            if(!right.isEmpty()) mid += " " + right;
            return mid;
        }
    }
}
