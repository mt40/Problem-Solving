package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_MULTQ3 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), q = in.i();
        SegTree tree = new SegTree(n);
        while(q-- > 0) {
            int t = in.i(), l = in.i(), r = in.i();
            if(t == 0) tree.update(0, n - 1, l, r, 0);
            else out.println(tree.query(0, n - 1, l, r, 0));
        }
    }

    class SegTree {
        Node []st;
        int []lazy;

        SegTree(int n) {
            int h = (int)Math.ceil(Math.log(n) / Math.log(2));
            int size = (1 << (h + 1)) - 1;
            st = new Node[size];
            lazy = new int[size];

            construct(0, n - 1, 0);
        }

        int query(int l, int r, int ql, int qr, int i) {
            if(lazy[i] > 0) doPendingUpdate(l, r, i);

            if(l > r || qr < l || r < ql) return 0;

            if(ql <= l && r <= qr) return st[i].zero;

            int mid = (l + r) >> 1;
            return query(l, mid, ql, qr, left(i)) + query(mid + 1, r, ql, qr, right(i));
        }

        void construct(int l, int r, int i) {
            if(l == r) {
                st[i] = new Node(1);
                return;
            }

            int mid = (l + r) >> 1;
            construct(l, mid, left(i));
            construct(mid + 1, r, right(i));
            st[i] = st[left(i)].add(st[right(i)]);
        }

        void update(int l, int r, int ql, int qr, int i) {
            if(lazy[i] > 0) doPendingUpdate(l, r, i);

            if(l > r || qr < l || r < ql) return; // out of range

            if(ql <= l && r <= qr) { // in range
                st[i].update(1);
                if(l < r) { // not leaf
                    lazy[left(i)]++;
                    lazy[right(i)]++;
                }
                return;
            }

            // partially in range
            int mid = (l + r) >> 1;
            update(l, mid, ql, qr, left(i));
            update(mid + 1, r, ql, qr, right(i));
            st[i] = st[left(i)].add(st[right(i)]);
        }

        void doPendingUpdate(int l, int r, int i) {
            st[i].update(lazy[i]);
            if(l < r) {
                lazy[left(i)] = lazy[i];
                lazy[right(i)] = lazy[i];
            }
            lazy[i] = 0;
        }

        int left(int x) {
            return (x << 1) + 1;
        }

        int right(int x) {
            return (x << 1) + 2;
        }
    }

    class Node {
        int zero, one, two;

        public Node(int zero) {
            this.zero = zero;
        }

        public Node(int zero, int one, int two) {
            this.zero = zero;
            this.one = one;
            this.two = two;
        }

        Node add(Node o) {
            return new Node(zero + o.zero, one + o.one, two + o.two);
        }

        void update(int x) {
            int r = x % 3;
            if(r == 1) {
                int tmp = two;
                two = one;
                one = zero;
                zero = tmp;
            }
            if(r == 2) {
                int tmp = two;
                two = zero;
                zero = one;
                one = tmp;
            }
        }
    }
}