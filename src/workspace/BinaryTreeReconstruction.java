package workspace;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Stack;

public class BinaryTreeReconstruction {
    /**
     * Given a preorder traversal with '#' indicates null,
     * reconstruct the binary tree
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        Queue<Character> q = new LinkedList<Character>();
        for(int i = 0; i < n; ++i) {
            q.add(in.next().charAt(0));
        }

        BinaryTree tree = new BinaryTree();
        tree.root = reconstruct(q);

        out.println(tree);
    }

    Node reconstruct(Queue<Character> source) {
        Character c = source.poll(); // return null if size = 0
        if(c == '#' || c == null) return null;
        Node mid = new Node(c);
        mid.left = reconstruct(source);
        mid.right = reconstruct(source);
        return mid;
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
