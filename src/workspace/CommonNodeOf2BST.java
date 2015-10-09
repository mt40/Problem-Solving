package workspace;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Stack;

public class CommonNodeOf2BST {
    /**
     * Find the common nodes of 2 Binary Search Tree
     * -- Method 1: with each node x in A, find x in B --> O(nlogm)
     * -- Method 2: user in-order traversal to get all the nodes into 2 arrays
     * then find the intersection of those 2 arrays --> O(n) since 2 arrays
     * are sorted, space: O(n)
     * -- Method 3: a modified iterative inorder traversal --> O(n), space: O(logn + logm)
     * In this class, I implement method 3
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        BST treeA = new BST(), treeB = new BST();
        int n = in.nextInt(), m = in.nextInt();
        for(int i = 0; i < n; ++i) treeA.add(in.nextInt());
        for(int i = 0; i < m; ++i) treeB.add(in.nextInt());

        out.println(treeA);
        out.println(treeB);
        out.println(treeA.toStrIterative());
        out.printf("Common nodes: %s\n", commonNodes(treeA, treeB));
    }

    /**
     * Idea: apply the idea of iterative inorder traversal
     */
    String commonNodes(BST a, BST b) {
        String ans = "";
        Stack<BST.Node> s_a = new Stack<BST.Node>(), s_b = new Stack<BST.Node>();
        BST.Node i = a.root, j = b.root;
        while(true) {
            if(i != null) {
                s_a.push(i);
                i = i.left;
            }
            else if(j != null) {
                s_b.push(j);
                j = j.left;
            }
            // at this point, i & j are both null
            else if(!s_a.isEmpty() && !s_b.isEmpty()) {
                i = s_a.peek();
                j = s_b.peek();
                if(i.value == j.value) {
                    ans += i + " ";
                    s_a.pop();
                    s_b.pop();
                    i = i.right;
                    j = j.right;
                }
                else if(i.value < j.value) {
                    s_a.pop();
                    i = i.right;
                    j = null;   /* wait for i to get to the new value
                                (which is larger than the current one) */
                }
                else {
                    s_b.pop();
                    j = j.right;
                    i = null;
                }
            }
            else break;
        }
        return ans;
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

        public String toStrIterative() {
            String rs = "In-order (iterative): ";
            Stack<Node> stack = new Stack<Node>();
            Node cur = root;
            while(cur != null || stack.size() > 0) {
                if(cur == null) {
                    Node tmp = stack.pop();
                    rs += tmp + " ";
                    cur = tmp.right;
                }
                else {
                    stack.push(cur);
                    cur = cur.left;
                }
            }
            return rs;
        }

        @Override
        public String toString() {
            return "In-order: " + toString(root);
        }

        String toString(Node cur) {
            if(cur == null) return "";
            String left = toString(cur.left);
            String mid = cur.toString();
            String right = toString(cur.right);
            if(!left.isEmpty()) mid = left + " " + mid;
            if(!right.isEmpty()) mid = mid + " " + right;
            return mid;
        }
    }
}
