package workspace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class SmallestBSTFromSortedList {
    /**
     * We can convert the list into array and construct the
     * smallest BST easily in O(n) but that costs O(n) space.
     * Here I implement the O(n) time and O(1) space solution.
     * Idea: use the inorder traversal
     * In short, if we have 1 4 9 .... then:
     *   4
     *  / \
     * 1   9
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        List<Integer> list = new ArrayList<Integer>(n);
        for(int i = 0; i < n; ++i)
            list.add(in.nextInt());

        BST tree = smallest(list);
        out.println(tree);
    }

    BST smallest(List<Integer> list) {
        BST tree = new BST();
        tree.root = smallest(list, new MyInt(), 0, list.size() - 1);
        return tree;
    }

    /**
     * Must use MyInt to do the pass by reference
     */
    BST.Node smallest(List<Integer> list, MyInt i, int l, int r) {
        if(l > r) return null;
        int mid = l + (r - l) / 2;
        BST.Node cur = new BST.Node();
        cur.left = smallest(list, i, l, mid - 1);
        cur.value = list.get(i.value);
        i.value++; // IMPORTANT! Move the index to the next element
        cur.right = smallest(list, i, mid + 1, r);
        return cur;
    }

    class MyInt {
        int value;
    }

    static class BST {
        static class Node {
            private int value;
            Node left, right;

            public Node(){}

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
