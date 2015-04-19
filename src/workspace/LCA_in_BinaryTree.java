package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

/**
 * Find the Lowest Common Ancestor of 2 nodes in a BinaryTree
 */
public class LCA_in_BinaryTree {
    Node root;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i) a[i] = in.nextInt();

        for(int i = 0; i < n; ++i)
            insert(a[i]);

        int q = in.nextInt();
        for(int i = 0; i < q; ++i) {
            int x = in.nextInt(), y = in.nextInt();
            Node lca = LCA(root, x, y);
            out.println(lca.val);
        }

        out.println("height = " + height(root, 0));
    }

    void print(Node cur) {
        if(cur == null)
            return;
        System.out.print(cur.val + " ");
        print(cur.left);
        print(cur.right);
    }

    void insert(int val) {
        if(root == null)
            root = new Node(val);
        else
            root.insert(val);
    }

    Node LCA(Node cur, int x, int y) {
        if(cur == null) return null;

        // Found x or y
        // Or maybe this is the answer!
        if(cur.val == x || cur.val == y)
            return cur;

        // Recursively find x and y in left and right sub-tree
        Node left = LCA(cur.left, x, y);
        Node right = LCA(cur.right, x, y);

        // x and y found on left & right -> this is the answer
        if(left != null && right != null)
            return cur;

        // if no x & y in the left sub-tree, answer is in the right sub-tree
        return left == null ? right : left;
    }

    int height(Node cur, int height) {
        if(cur == null)
            return height;
        int h = height(cur.left, height + 1);
        h = Math.max(h, height(cur.right, height + 1));
        return h;
    }

    class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }

        public void insert(int v) {
            if(v < val) {
                if(left == null)
                    left = new Node(v);
                else
                    left.insert(v);
            }
            else {
                if(right == null)
                    right = new Node(v);
                else
                    right.insert(v);
            }
        }
    }
}
