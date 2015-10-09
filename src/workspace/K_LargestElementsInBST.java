package workspace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class K_LargestElementsInBST {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), k = in.nextInt();
        BST tree = new BST();
        for(int i = 0; i < n; ++i)
            tree.add(in.nextInt());

        List<Integer> ans = kLargest(tree, k);
        for(int x : ans)
            out.print(x + " ");
        out.println();
    }

    List<Integer> kLargest(BST tree, int k) {
        List<Integer> ans = new ArrayList<Integer>();
        kLargest(ans, tree, tree.root, k);
        return ans;
    }

    void kLargest(List<Integer> ans, BST tree, Node cur, int k) {
        if(cur == null) return;
        kLargest(ans, tree, cur.right, k);
        if(ans.size() < k)
            ans.add(cur.value);
        else
            return; // enough, no need to find more
        kLargest(ans, tree, cur.left, k);
    }

    static class Node {
        private int value;
        Node left, right;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "" + value;
        }
    }

    static class BST {
        Node root;
        int size;

        public void add(int val) {
            size++;
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
