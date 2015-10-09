package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class LinkedListImplementation {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        int []a = new int[n], b = new int[m];
        for(int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
        }
        for(int i = 0; i < m; ++i)
            b[i] = in.nextInt();

        MyLinkedList list1 = new MyLinkedList(), list2 = new MyLinkedList();
        for(int x : a)
            list1.add(x);
        for(int x : b)
            list2.add(x);
        mergeSortedList(list1, list2);
        out.println(list1);
        list1.reverse();
        out.println(list1);
    }

    void mergeSortedList(MyLinkedList a, MyLinkedList b) {
        Node i = a.root, j = b.root, prev_i = a.root;
        while(i != null && j != null) {
            if (j.compareTo(i) < 0) {
                Node tmp = j.next;
                j.next = i;
                if (i == a.root) {
                    a.root = j;
                } else {
                    prev_i.next = j;
                }
                prev_i = j;
                j = tmp;
            } else {
                prev_i = i;
                i = i.next;
            }
        }
        if(j != null)
            prev_i.next = j;
    }

    class Node implements Comparable<Node> {
        int value;
        Node next;
        public Node(int val) {
            this.value = val;
        }

        @Override
        public String toString() {
            return "" + value;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(value, o.value);
        }
    }

    class MyLinkedList {
        Node root;

        public void add(int val) {
            if(root == null)
                root = new Node(val);
            else {
                Node cur = root;
                while(cur.next != null) cur = cur.next;
                cur.next = new Node(val);
            }
        }

        public void reverse() {
            if(root == null) return;
            Node cur = root, prev = null;
            while(cur != null) {
                Node tmp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = tmp;
            }
            this.root = prev;
        }

        @Override
        public String toString() {
            String rs = "";
            Node cur = root;
            for(;cur != null; cur = cur.next) {
                rs += cur + " ";
            }
            return rs;
        }
    }
}
