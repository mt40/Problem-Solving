package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class SuccessorInBinaryTree {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        BST tree = new BST();
        for(int i = 0; i < n; ++i)
            tree.add(in.nextInt());

        out.println(tree);
        int t1 = 8;
        out.printf("In-order successor of %d: %d\n", t1, tree.inorderSuccessor(t1));
        out.printf("Post-order successor of %d: %d\n", t1, tree.postorderSuccessor(t1));
        out.printf("Pre-order successor of %d: %d\n", t1, tree.preorderSuccessor(t1));
    }

    class BST {
        class Node {
            int value;
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

        Node add(int val) {
            if (root == null) {
                root = new Node(val);
                return root;
            }
            return add(root, val);
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

        /**
         * a.k.a the first element that is larger than val
         */
        int inorderSuccessor(int val) {
            return inorderSuccessor(root, val);
        }

        int inorderSuccessor(Node cur, int val) {
            if(cur == null) return -1;
            if(cur.value == val && cur.right != null)
                return cur.right.value;
            Node rightMost = rightMostChild(cur.left);
            if(rightMost != null && rightMost.value == val)
                return cur.value;
            if(cur.value < val)
                return inorderSuccessor(cur.right, val);
            return inorderSuccessor(cur.left, val);
        }

        int postorderSuccessor(int val) {
            return postorderSuccessor(root, val);
        }

        int postorderSuccessor(Node cur, int val) {
            if(cur == null || cur.value == val)
                return -1;
            if(cur.left != null && cur.left.value == val) {
                if(cur.right != null)
                    return leftMostChild(cur.right).value;
                return cur.value;
            }
            if(cur.right != null && cur.right.value == val)
                return cur.value;
            if(cur.value < val)
                return postorderSuccessor(cur.right, val);
            return postorderSuccessor(cur.left, val);
        }

        int preorderSuccessor(int val) {
            return preorderSuccessor(root, val);
        }

        int preorderSuccessor(Node cur, int val) {
            if(cur == null) return -1;
            if(cur.value == val) {
                if(cur.left != null) return cur.left.value;
                if(cur.right != null) return cur.right.value;
            }
            Node leftMost = leftMostChild2(cur.left);
            if(leftMost != null && leftMost.value == val && cur.right != null)
                return cur.right.value;
            if(cur.value < val)
                return preorderSuccessor(cur.right, val);
            return preorderSuccessor(cur.left, val);
        }

        Node rightMostChild(Node cur) {
            if(cur == null) return null;
            if(cur.right == null) return cur;
            return rightMostChild(cur.right);
        }

        /**
         * Not really return the left most child but the first element
         * in the post-order traversal
         */
        Node leftMostChild(Node cur) {
            if(cur == null) return null;
            if(cur.left == null) {
                if(cur.right == null)
                    return cur;
                return leftMostChild(cur.right);
            }
            return leftMostChild(cur.left);
        }

        /**
         * Not really return the left most child but the last element
         * in the pre-order traversal
         */
        Node leftMostChild2(Node cur) {
            if(cur == null) return null;
            if(cur.right == null && cur.left == null)
                return cur;
            if(cur.right != null)
                return leftMostChild2(cur.right);
            return leftMostChild2(cur.left);
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
