package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class RecoverBinaryTree {
    int []pre, ino;
    Node treeRoot = null;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        pre = new int[n];
        ino = new int[n];
        for(int i = 0; i < n; ++i)
            pre[i] = in.nextInt();
        for(int i = 0; i < n; ++i)
            ino[i] = in.nextInt();

        recover(0, n - 1, 0, n - 1, null, true);
        System.out.print("\nTest, inorder traversal: ");
        inorder(treeRoot);
    }

    void recover(int l1, int r1, int l2, int r2, Node parent, boolean left) {
        int root = pre[l1];

        Node rootN = new Node(root);
        if(parent == null)
            treeRoot = rootN;
        else {
            if (left) parent.left = rootN;
            else parent.right = rootN;
        }

        if(l1 == r1) {
            System.out.print(root + " ");
            return;
        }

        // find the root in in-order
        int r_pos = -1;
        for(int i = l2; i <= r2; ++i)
            if(ino[i] == root) {
                r_pos = i;
                break;
            }

        int left_limit = l1 + (r_pos - l2); // from l1...left_limit is the left subtree in pre-order
        // visit left sub-tree
        if(r_pos - 1 >= l2)
            recover(l1 + 1, left_limit, l2, r_pos - 1, rootN, true);
        // visit right sub-tree
        if(r_pos +1 <= r2)
            recover(left_limit + 1, r1, r_pos + 1, r2, rootN, false);

        // Finally, print the root
        System.out.print(root + " ");
    }

    void inorder(Node cur) {
        if(cur == null)
            return;
        System.out.print(cur.val + " ");
        inorder(cur.left);
        inorder(cur.right);
    }

    class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }
    }
}
