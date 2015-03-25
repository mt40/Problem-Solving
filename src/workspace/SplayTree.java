package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class SplayTree {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];

        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        STree tree = new STree();
        for(int i = 0; i < n; ++i)
            tree.insert(a[i]);

        tree.print();
    }

    class STree {
        Node head;

        public void insert(int v) {
            if(head == null)
                head = new Node(v);
            else {
                // Binary Search Tree insertion
                Node cur = head, p = head;
                while(cur != null) {
                    p = cur;
                    if(v <= cur.val)
                        cur = cur.left;
                    else
                        cur = cur.right;
                }
                cur = new Node(v);
                if(v <= p.val) p.left = cur;
                else p.right = cur;
                cur.par = p;
                // Splay at the new node
                splay(cur);
            }
        }

        void splay(Node x) {
            while(x.par != null) { // splay until x is head
                if(x.par == head)
                    zig(x);
                else if((x.par.par.left == x.par && x.par.right == x)
                        || (x.par.par.right == x.par && x.par.left == x))
                    zigzag(x);
                else if((x.par.par.left == x.par && x.par.left == x)
                        || (x.par.par.right == x.par && x.par.right == x))
                    zigzig(x);
            }
            this.head = x;
        }

        void zig(Node x) {
            Node p = head; // parent
            if(x == p.left) {
                p.left = x.right;
                x.right = p;
            }
            else {
                p.right = x.left;
                x.left = p;
            }

            x.par = p.par;
            p.par = x;
        }

        void zigzag(Node x) {
            Node p = x.par, g = p.par; // parent and grandparent
            if(p == g.left) {
                p.right = x.left;
                g.left = x.right;
                x.left = p;
                x.right = g;
            }
            else {
                p.left = x.right;
                g.right = x.left;
                x.left = g;
                x.right = p;
            }

            if(g.par != null) {
                if (g.par.left == g) g.par.left = x;
                else g.par.right = x;
            }
            x.par = g.par;
            p.par = x;
            g.par = x;
        }

        void zigzig(Node x) {
            Node p = x.par, g = p.par; // parent and grandparent
            if(g.left == p) {
                g.left = p.right;
                p.left = x.right;
                p.right = g;
                x.right = p;
            }
            else {
                g.right = p.left;
                p.right = x.left;
                p.left = g;
                x.left = p;
            }

            if(g.par != null) {
                if (g.par.left == g) g.par.left = x;
                else g.par.right = x;
            }
            x.par = g.par;
            p.par = x;
            g.par = p;
        }

        public void print() {
            print(this.head);
        }

        public void print(Node x) {
            if(x == null) return;
            print(x.left);
            System.out.print(x.val + " ");
            print(x.right);
        }
    }

    class Node {
        int val;
        Node left, right, par;
        public Node(int val) {
            this.val = val;
        }
    }
}
