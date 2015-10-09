package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class SplayTreeImplementation {
    PrintWriter out;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        this.out = out;
        int n = in.nextInt(), m = in.nextInt();
        SplayTree tree = new SplayTree();
        for(int i = 0; i < n; ++i)
            tree.insert(in.nextInt());

        tree.print();

        while(m-- > 0) {
            int x = in.nextInt();
            out.printf("Search for %d: ", x);
            out.println((tree.search(x) == null) ? "Not exist!" : "Exist!");
            tree.print();
        }
        tree.remove(40);
        tree.print();
    }

    class SplayTree {
        Node root;

        public Node search(int key) {
            root = splay(root, key);
            return (root.key == key)? root : null;
        }

        public void insert(int key) {
            if(root == null) {
                root = new Node(key);
                return;
            }

            // bring the node closest to key to root
            // in fact, the new root is the first node that is
            // smaller than key
            root = splay(root, key);

            // if 'key' already exists, done
            if(root.key == key) return;

            Node newNode = new Node(key);
            if(key < root.key) {
                newNode.right = root;
                newNode.left = root.left;
                root.left = null;
            }
            else {
                newNode.left = root;
                newNode.right = root.right;
                root.right = null;
            }
            root = newNode; // IMPORTANT!
        }

        public void remove(int key) {
            if(search(key) == null) return;
            splay(root, key);

            delete(root, key);
        }

        /**
         * Delete in binary tree style
         */
        void delete(Node cur, int key) {
            if(cur == null) return;
            // Case 1: there is no child or 1 child
            if(cur.key == key && (cur.isLeaf() || cur.has1Child())) {
                if(cur == root) {
                    root = (cur.left == null) ? cur.right : cur.left;
                    return;
                }
                Node p = parent(cur);
                if(p.left == cur)
                    p.left = (cur.left == null) ? cur.right : cur.left;
                else
                    p.right = (cur.left == null) ? cur.right : cur.left;
                return;
            }
            // Case 2: there are 2 children
            else if(cur.key == key) {
                Node max = subtree_max(cur.left);
                copy(cur, max);
                delete(cur.left, max.key);
                return;
            }
            if(cur.key < key) delete(cur.right, key);
            else delete(cur.left, key);
        }

        void copy(Node x, Node y) {
            x.key = y.key;
        }

        Node parent(Node x) {
            Node cur = root;
            while(cur != null) {
                if(cur.left == x || cur.right == x)
                    return cur;
                cur = (cur.key < x.key)? cur.right : cur.left;
            }
            return null;
        }

        Node subtree_max(Node x) {
            if(x == null) return x;
            Node cur = x;
            while(cur.right  != null)
                cur = cur.right;
            return cur;
        }

        // Left rotate subtree rooted at x
        Node rotateLeft(Node x) {
            Node y = x.right;
            x.right = y.left;
            y.left = x;
            return y;
        }

        // Right rotate subtree rooted at x
        Node rotateRight(Node x) {
            Node y = x.left;
            x.left = y.right;
            y.right = x;
            return y;
        }

        /**
         * Bring key to root if key exists. If not, bring the last
         * accessed element to root
         */
        Node splay(Node root, int key) {
            // Base case: root is null or key is root
            if(root == null || root.key == key)
                return root;

            // Key in the left subtree
            if(root.key > key) {
                // Key is not here, we are done
                if(root.left == null) return root;

                // Zig-zig case (left-left): x <-left- parent <-left- root
                if(root.left.key > key) {
                    // Recursively bring the key to root->left->left
                    root.left.left = splay(root.left.left, key);
                    // Rotate parent of key to root
                    root = rotateRight(root);
                }
                // Zig-zag case (left-right): x <-right- parent <-left- root
                else if(root.left.key < key) {
                    root.left.right = splay(root.left.right, key);
                    if(root.left.right != null)
                        root.left = rotateLeft(root.left);
                }
                return (root.left == null)? root : rotateRight(root); /* the null check is for
                the first 'if': we search for key in the left subtree of root.left
                if key does not exist then root.left.left = null */
            }
            else { // key in right subtree. Do opposite as above
                if(root.right == null) return root;
                // Zag-zig case (right-left)
                if(root.right.key > key) {
                    root.right.left = splay(root.right.left, key);
                    if(root.right.left != null)
                        root.right = rotateRight(root.right);
                }
                // Zag-zag case (right-right)
                else if(root.right.key < key) {
                    root.right.right = splay(root.right.right, key);
                    root = rotateLeft(root);
                }
                return (root.right == null) ? root : rotateLeft(root);
            }
        }

        public void print() {
            print(root);
            out.println();
        }

        void print(Node cur) {
            if(cur == null) return;
            out.print(cur + " ");
            print(cur.left);
            print(cur.right);
        }
    }

    class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public boolean has1Child() {
            return (left != null && right == null) || (left == null && right != null);
        }

        @Override
        public String toString() {
            return "" + key;
        }
    }
}
