package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class DoublyLinkedListImplementation {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        DoublyLinkedList list = new DoublyLinkedList();
        for(int i = 0; i < n; ++i)
            list.add(in.nextInt());

        out.println(list);
        list.insert(4, 14);
        list.insert(2, 1);
        list.insert(10, 99);
        out.println(list);
        list.remove(8);
        list.remove(4);
        out.println(list);
    }

    class DoublyLinkedList {
        Node head, tail;
        int count;

        void add(int key) {
            if(head == null) {
                head = new Node(key);
                tail = head;
            }
            else {
                Node newNode = new Node(key);
                newNode.prev = tail;
                tail.next = newNode;
                tail = tail.next;
            }
            count++;
        }

        void insert(int pos, int key) {
            if(pos == count) {
                add(key);
                return;
            }
            Node cur = head;
            for(int i = 0; i < pos && cur.next != null; ++i)
                cur = cur.next;
            Node newNode = new Node(key);
            newNode.next = cur;
            newNode.prev = cur.prev;
            cur.prev = newNode;
            if(newNode.prev != null)
                newNode.prev.next = newNode;
            if(pos == 0)
                head = newNode;

            count++;
        }

        void remove(int key) {
            Node cur = head;
            int pos = 0;
            while(cur != null) {
                if(cur.key == key) {
                    removeAt(pos);
                    return;
                }
                cur = cur.next;
                pos++;
            }
        }

        void removeAt(int pos) {
            if(count == 1) {
                head = tail = null;
                return;
            }
            if(pos == count - 1) {
                tail = tail.prev;
                tail.next = null;
                return;
            }
            if(pos == 0) {
                head = head.next;
                head.prev = null;
                return;
            }
            Node cur = head;
            for(int i = 0; i < pos; ++i)
                cur = cur.next;
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
        }

        @Override
        public String toString() {
            String s = "";
            Node cur = head;
            while(cur != null) {
                s += cur.key + " ";
                cur = cur.next;
            }
            return s;
        }
    }

    class Node {
        int key;
        Node prev, next;

        public Node(int key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return "" + key;
        }
    }
}
