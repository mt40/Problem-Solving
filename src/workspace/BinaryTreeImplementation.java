package workspace;

import java.util.Random;
import java.util.Scanner;
import java.io.PrintWriter;

public class BinaryTreeImplementation {
    /**
     * Implementation of Binary Search Tree
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
        }

        BST tree = new BST();
        for(int x : a) {
            tree.add(x);
        }

        out.println(tree);
        out.printf("Tree height: %d\n", tree.height());
        out.printf("Balance: %b\n", tree.isBalance());
        out.printf("Count: %d\n", tree.count());
        int k = new Random().nextInt(n) + 1;
        out.printf("%dth node: %s\n", k, tree.getKthNode(k));
        out.printf("Leaves: %s\n", tree.getLeaf());
        out.printf("LCA of 22 & 18: %s\n", tree.LCA(22, 18));
        out.printf("LCA of 7 & 17: %s\n", tree.LCA(7, 17));
    }

    class BST {
        class Node {
            int value;
            Node left, right;
            public Node(int val) {
                value = val;
            }

            @Override
            public String toString() {
                return "" + value;
            }
        }

        Node root;

        public Node add(int val) {
            if(root == null) {
                root = new Node(val);
                return root;
            }
            else {
                return add(root, val);
            }
        }

        Node add(Node cur, int val) {
            if(cur == null) {
                return new Node(val);
            }
            else if(val <= cur.value)
                cur.left = add(cur.left, val);
            else
                cur.right = add(cur.right, val);
            return cur;
        }

        /**
         * This is not the best approach but it will be
         * if the number of children of the subtree rooted at
         * cur is stored inside the node (so we don't have to
         * call count())
         */
        public Node getKthNode(int k) {
            return getKthNode(root, k);
        }

        Node getKthNode(Node cur, int k) {
            if(cur == null) return null;
            int left = count(cur.left);
            if(left == k - 1)
                return cur;
            if(left >= k)
                return getKthNode(cur.left, k);
            return getKthNode(cur.right, k - left - 1);
        }

        public boolean isBalance() {
            return isBalance(root);
        }

        boolean isBalance(Node cur) {
            if(cur == null) return true;
            int left = height(cur.left);
            int right = height(cur.right);
            boolean balance = (int)Math.abs(left - right) <= 1;
            return balance & isBalance(cur.left) & isBalance(cur.right);
        }

        public int height() {
            return height(root);
        }

        int height(Node cur) {
            if(cur == null) return 0;
            return Math.max(height(cur.left), height(cur.right)) + 1;
        }

        public int count() {
            return count(root);
        }

        int count(Node cur) {
            if(cur == null) return 0;
            return count(cur.left) + count(cur.right) + 1;
        }

        public Node LCA(int a, int b) {
            return LCA(root, a, b);
        }

        /**
         * Lowest common ancestor.
         * This implementation is for BinaryTree, it is not optimized for
         * BinarySearchTree
         */
        Node LCA(Node cur, int a, int b) {
            if(cur == null) return null;
            // obviously, this is the answer
            if(cur.value == a || cur.value == b)
                return cur;

            // find if 2 values are on left and right branch
            Node left = findLCA(cur.left, a, b);
            Node right = findLCA(cur.right, a, b);
            // if both are not null, then a (or b) is on the left subtree and the other
            // is on the right subtree
            if(left != null && right != null)
                return cur;

            Node rs = LCA(cur.left, a, b);
            if(rs == null)
                rs = LCA(cur.right, a, b);
            return rs;
        }

        Node findLCA(Node cur, int a, int b) {
            if(cur == null) return null;
            if(cur.value == a || cur.value == b)
                return cur;
            Node rs = findLCA(cur.left, a, b);
            if(rs == null)
                rs = findLCA(cur.right, a, b);
            return rs;
        }

        // Get all leaves
        String getLeaf() {
            return getLeaf(root);
        }

        String getLeaf(Node cur) {
            if(cur == null)
                return "";
            if(cur.left == null && cur.right == null)
                return cur.toString();

            String left = getLeaf(cur.left);
            String right = getLeaf(cur.right);
            if(!right.isEmpty()) left += " " + right;
            return left;
        }

        @Override
        public String toString() {
            return toString(root);
        }

        String toString(Node cur) {
            if(cur == null) return "";
            String left = toString(cur.left);
            String mid = cur.toString();
            String right = toString(cur.right);
            if(!left.isEmpty()) mid = left + " " + mid;
            if(!right.isEmpty()) mid += " " + right;
            return mid;
        }
    }
}
