package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class SubtreeSizeInBST {
    /**
     * Count how many element in range [L, R]
     * This approach using extra information in each node,
     * that is the size of the subtree rooted at that node
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        BST tree = new BST();
        for(int i = 0; i < n; ++i)
            tree.add(in.nextInt());

        while(m-- > 0) {
            int l = in.nextInt(), r = in.nextInt();
            out.println(countRange(tree, l, r));
        }
    }

    int countRange(BST tree, int l, int r) {
        int low = countRange(tree, tree.root, l - 1);
        int hi = countRange(tree, tree.root, r);
        return hi - low;
    }

    /**
     * Count number of node in range [0, R]
     */
    int countRange(BST tree, Node cur, int r) {
        if(cur == null) return 0;
        int left = (cur.left != null) ? cur.left.count : 0;
        if(cur.value == r)
            return 1 + left;
        if(cur.value < r)
            return 1 + left + countRange(tree, cur.right, r);
        return countRange(tree, cur.left, r);
    }

    static class Node {
        private int value, count = 1; // count = size of subtree including this node
        Node left, right;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }

        boolean isLeaf() {
            return left == null && right == null;
        }

        boolean has1Child() {
            return (left != null && right == null) || (left == null && right != null);
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
            cur.count++;
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

        boolean remove(int val) {
            return remove(root, val);
        }

        boolean remove(Node cur, int val) {
            if(cur == null) return false;
            /* Case 1: target is a leaf or has only 1 child */
            if(cur.value == val && (cur.isLeaf() || cur.has1Child())) {
                if(cur == root) {
                    root = (cur.left != null) ? cur.left : cur.right;
                    return true;
                }
                Node p = parent(cur);
                if(p.left == cur) p.left = (cur.left != null) ? cur.left : cur.right;
                if(p.right == cur) p.right = (cur.left != null) ? cur.left : cur.right;
                return true;
            }
            /* Case 2: target has 2 children, copy the max of left
            -subtree and recursively delete the max node from the left
            -subtree
             */
            else if(cur.value == val) {
                Node maxLeft = cur.left;
                while(maxLeft.right != null)
                    maxLeft = maxLeft.right;
                copy(maxLeft, cur);
                remove(cur.left, maxLeft.value);
                return true;
            }
            else if(cur.value < val) return remove(cur.right, val);
            return remove(cur.left, val);
        }

        Node parent(Node x) {
            if(x == root) return null;
            Node cur = root;
            while(cur != null) {
                if (cur.left == x || cur.right == x)
                    return cur;
                if (cur.value < x.value)
                    cur = cur.right;
                else
                    cur = cur.left;
            }
            return null;
        }

        void copy(Node a, Node b) {
            b.value = a.value;
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
