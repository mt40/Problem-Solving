package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class AVL_Implementation {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        AVL tree = new AVL();
        for(int i = 0; i < n; ++i)
            tree.add(in.nextInt());

        printTree(tree, out);
        tree.remove(10);
        printTree(tree, out);
    }

    void printTree(AVL tree, PrintWriter out) {
        printTree(tree.root, out);
        out.println();
    }

    void printTree(Node root, PrintWriter out) {
        if(root == null) return;
        out.print(root + " ");
        printTree(root.left, out);
        printTree(root.right, out);
    }

    class AVL {
        Node root;

        Node rightRotate(Node x) {
            Node y = x.left;
            x.left = y.right;
            y.right = x;
            // update height
            x.height = Math.max(height(x.left), height(x.right)) + 1;
            y.height = Math.max(height(y.left), height(y.right)) + 1;

            return y;
        }

        Node leftRotate(Node x) {
            Node y = x.right;
            x.right = y.left;
            y.left = x;
            // update height
            x.height = Math.max(height(x.left), height(x.right)) + 1;
            y.height = Math.max(height(y.left), height(y.right)) + 1;

            return y;
        }

        int height(Node x) {
            return (x == null)? 0 : x.height;
        }

        int getBalance(Node x) {
            if(x == null) return 0;
            return height(x.left) - height(x.right);
        }

        void copy(Node a, Node b) {
            a.key = b.key;
        }

        Node subtree_max(Node root) {
            while (root != null)
                root = root.right;
            return root;
        }

        public void add(int key) {
            root = add(root, key);
        }

        public void remove(int key) {
            root = remove(root, key);
        }

        Node add(Node cur, int key) {
            /* 1. Insert in BST fashion */
            if(cur == null) return new Node(key);
            if(cur.key < key) cur.right = add(cur.right, key);
            else cur.left = add(cur.left, key);

            /* 2. Update height */
            cur.height = Math.max(height(cur.left), height(cur.right)) + 1;

            /* 3. Calculate the balance factor */
            int balance = getBalance(cur);

            /* 4. If 'cur' is not balance then there is 4 cases */
            // left-left case
            if(balance > 1 && key < cur.left.key)
                return rightRotate(cur);
            // left-right case
            if(balance > 1 && key > cur.left.key) {
                cur.left = leftRotate(cur.left);
                return rightRotate(cur);
            }
            // right-right case
            if(balance < -1 && key > cur.right.key)
                return leftRotate(cur);
            // right-left case
            if(balance < -1 && key < cur.right.key) {
                cur.right = rightRotate(cur.right);
                return leftRotate(cur);
            }

            /* 5. Return this (unchanged) node */
            return cur;
        }

        Node remove(Node cur, int key) {
            /* 1. Remove in BST fashion */
            if(cur == null) return cur;
            if(cur.key < key)
                cur.right = remove(cur.right, key);
            else if(cur.key > key)
                cur.left = remove(cur.left, key);
            // this is the node we want to remove
            else {
                // Case 1: 1 child or 0 child
                if(cur.left == null || cur.right == null)
                    cur = (cur.left != null)? cur.left : cur.right;
                // Case 2: 2 children
                else {
                    Node max = subtree_max(cur.left);
                    copy(cur, max);
                    cur.left = remove(cur.left, max.key);
                }
            }

            /* 2. AVL special part */
            if(cur == null) return cur; // we deleted the only node in the tree
            /* 2.1 Update height. Because this must be the ancestor of the
            removed node */
            cur.height = Math.max(height(cur.left), height(cur.right)) + 1;
            /* 2.2 Calculate balance factor */
            int balance = getBalance(cur);
            /* 2.3 If 'cur' is not balance then there are 4 cases */
            // left-left case: cur.left is heavier than cur & cur.left.left is heavier than cur.left
            if(balance > 1 && getBalance(cur.left) >= 0)
                return rightRotate(cur);
            // left-right case
            if(balance > 1 && getBalance(cur.left) < 0) {
                cur.left = leftRotate(cur.left);
                return rightRotate(cur);
            }
            // right-right case
            if(balance < -1 && getBalance(cur.right) < 0)
                return leftRotate(cur);
            // right-left case
            if(balance < -1 && getBalance(cur.right) >= 0) {
                cur.right = rightRotate(cur.right);
                return leftRotate(cur);
            }

            /* 3. Return this (unchanged) node */
            return cur;
        }
    }

    class Node {
        int key, height = 1;
        Node left, right;

        public Node(int key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return "" + key;
        }
    }
}
