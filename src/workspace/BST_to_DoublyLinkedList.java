package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;

public class BST_to_DoublyLinkedList {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []a = in.arr(n);

        BST tree = new BST();
        for(int ai : a)
            tree.add(ai);

        TwoWayList list = tree.toList();
        out.println(list);
    }

    class BST {
        Node root;

        void add(int key) {
            root = add(root, key);
        }

        Node add(Node cur, int key) {
            if(cur == null)
                return new Node(key);
            if(cur.key < key)
                cur.right = add(cur.right, key);
            else
                cur.left = add(cur.left, key);
            return cur;
        }

        TwoWayList toList() {
            TwoWayList list = new TwoWayList();
            toList(root, list);

            return list;
        }

        void toList(Node cur, TwoWayList list) {
            if(cur == null)
                return;
            toList(cur.left, list);
            list.add(cur.key);
            toList(cur.right, list);
        }
    }

    // Doubly linked list
    class TwoWayList {
        Node head, tail;

        void add(int key) {
            if(head == null)
                head = tail = new Node(key);
            else {
                Node nd = new Node(key);
                nd.left = tail;
                tail.right = nd;
                tail = nd;
            }
        }

        @Override
        public String toString() {
            String s = "";
            for(Node cur = head; cur != null; cur = cur.right)
                s += cur.key + " ";
            return s;
        }
    }

    class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return "" + key;
        }
    }
}