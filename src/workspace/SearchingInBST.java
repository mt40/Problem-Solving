package workspace;

import helperClasses.InputReader;
import sun.reflect.generics.tree.Tree;

import java.io.PrintWriter;

public class SearchingInBST {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        BST tree = new BST();
        for(int i = 0; i < n; ++i)
            tree.add(a[i]);

        tree.print();

        int x = 10;
        out.printf("\nSmallest prime (greater than %d): %d\n", x, tree.find(x));
    }

    class BST {
        TreeNode root;

        void add(int val) {
            if(root == null)
                root = new TreeNode(val);
            else
                root.add(root, val);
        }

        int find(int x) {
            TreeNode ans = find(root, x);
            return ans != null ? ans.val : -1;
        }

        // find the minimum prime that is > x
        TreeNode find(TreeNode cur, int x) {
            if(cur == null)
                return null;

            // check this node
            TreeNode mid = null;
            if(cur.val < x && isPrime(cur.val))
                mid = cur;

            // check left subtree
            TreeNode left = find(cur.left, x);
            TreeNode right = null;
            // if this node and left subtree is bad, then check the right subtree
            if(left == null && mid == null)
                right = find(cur.right, x);

            // return the smallest
            return left != null ? left : (mid != null ? mid : right);
        }

        void print() {
            print(root);
        }

        void print(TreeNode cur) {
            if(cur == null)
                return;
            print(cur.left);
            System.out.print(cur.val + " ");
            print(cur.right);
        }
    }

    class TreeNode {
        public int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }

        public void add(TreeNode cur, int val) {
            if(val < cur.val) {
                if(cur.left == null) {
                    cur.left = new TreeNode(val);
                    return;
                }
                add(cur.left, val);
            }
            else {
                if(cur.right == null) {
                    cur.right = new TreeNode(val);
                    return;
                }
                add(cur.right, val);
            }
        }
    }

    boolean isPrime(int x) {
        for(int i = 2; i <= Math.sqrt(x) + 1; ++i)
            if(x % i == 0)
                return false;
        return true;
    }

    int search(TreeNode node, int x) {
        if(node.val == x)
            return node.val;
        if(node.val < x)
            return search(node.right, x);
        return search(node.left, x);
    }

}
