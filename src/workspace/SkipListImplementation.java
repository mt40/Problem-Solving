package workspace;

import java.util.Random;
import java.util.Scanner;
import java.io.PrintWriter;

public class SkipListImplementation {
    /**
     * Reference: http://igoro.com/archive/skip-lists-are-fascinating/
     */
    void readArr(int len, int []a, Scanner in) {
        for (int i = 0; i < len; ++i)
            a[i] = in.nextInt();
    }
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();
        int[] a = new int[n], b = new int[m], c = new int[k];
        readArr(n, a, in);
        readArr(m, b, in);
        readArr(k, c, in);

        SkipList list = new SkipList();
        for (int x : a) {
            list.add(x);
        }
        out.println(list.toString());

        for(int x : b) {
            out.printf("contain %d: %b\n", x, list.contains(x));
        }

        for(int x : c) {
            out.printf("remove %d\n", x);
            list.remove(x);
        }
        out.println(list.toString());
    }

    class SkipList {
        class Node {
            int value;
            Node[] next; // next[i] = pointer to the node at level i

            public Node(int value, int level) {
                this.value = value;
                next = new Node[level];
            }
        }

        Node _head = new Node(0, 33); // max number of levels is 33 (level is 0 -> 32)
        int _levels = 1;
        Random _rand = new Random();

        public void add(int value) {
            int level = 0;
            for (int r = _rand.nextInt(); (r & 1) == 1; r >>= 1) {
                level++;
                if (level == _levels) {
                    _levels++;
                    break;
                }
            }

            Node newNode = new Node(value, level + 1);
            Node cur = _head;
            for (int lv = _levels - 1; lv >= 0; --lv) {
                // move pointer to the correct place
                for (; cur.next[lv] != null; cur = cur.next[lv]) {
                    if (cur.next[lv].value > value) break;
                }
                if (lv <= level) {
                    newNode.next[lv] = cur.next[lv];
                    cur.next[lv] = newNode;
                }
            }
        }

        public boolean contains(int value) {
            Node cur = _head;
            for(int lv = _levels; lv >= 0; --lv) {
                for(; cur.next[lv] != null; cur = cur.next[lv]) {
                    if(cur.next[lv].value == value) {
                        return true;
                    }
                    if(cur.next[lv].value > value) break; // not found at this level
                }
            }
            return false;
        }

        public boolean remove(int value) {
            boolean found = false;
            Node cur = _head;
            for(int lv = _levels - 1; lv >= 0; --lv) {
                for(; cur.next[lv] != null; cur = cur.next[lv]) {
                    if(cur.next[lv].value == value) {
                        found = true;
                        cur.next[lv] = cur.next[lv].next[lv]; // delete at this level
                        break; // we also have to delete at the lower level
                    }
                    if(cur.next[lv].value > value) break; // not found at this level
                }
            }

            return found;
        }

        @Override
        public String toString() {
            String rs = "";
            Node cur = _head;
            for (int lv = _levels - 1; lv >= 0; --lv) {
                rs += String.format("%d: ", lv);
                for (; cur.next[lv] != null; cur = cur.next[lv]) {
                    rs += cur.next[lv].value + " ";
                }
                cur = _head;
                if (lv > 0)
                    rs += "\n";
            }

            return rs;
        }
    }
}
