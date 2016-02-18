package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_CTRICK {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        SegTree tree = new SegTree(n);
        int []ans = new int[n];
        int prev = -1;
        for(int i = 1; i <= n; ++i) {
            int k = tree.sum(0, prev);
            int target = (i + 1 + k) % tree.st[0];
            if(target == 0) target = tree.st[0];
            int p = tree.kth(target);
            ans[p] = i;
            tree.remove(p);
            prev = p;
        }

        for(int ai : ans) out.print(ai + " ");
        out.println();
    }

    class SegTree {
        int []st;
        int n;

        public SegTree(int n) {
            this.n = n;
            int h = (int)Math.ceil(Math.log(n)/Math.log(2));
            int size = (1 << (h + 1)) - 1;
            st = new int[size];

            build(0, n-1, 0);
        }

        int build(int l, int r, int i) {
            if(l == r) return ++st[i];

            int m = (l + r) / 2;
            st[i] = build(l, m, left(i)) + build(m + 1, r, right(i));
            return st[i];
        }

        void remove(int id) { remove(0, n - 1, id, 0); }

        void remove(int l, int r, int id, int i) {
            if(id < l || r < id) return; // out of range
            // in range
            st[i]--;
            if(l < r) {
                int m = (l + r) / 2;
                remove(l, m, id, left(i));
                remove(m + 1, r, id, right(i));
            }
        }

        int sum(int ql, int qr) {
            return sum(0, n - 1, ql, qr, 0);
        }

        int sum(int l, int r, int ql, int qr, int i) {
            if(qr < l || r < ql) return 0;

            if(ql <= l && r <= qr) return st[i];

            int m = (l + r) / 2;
            return sum(l, m, ql, qr, left(i)) + sum(m + 1, r, ql, qr, right(i));
        }

        int kth(int k) { return kth(0, n - 1, k, 0); }

        // find the k-th free spot
        int kth(int l, int r, int k, int i) {
            if(l == r) return l;

            int lt = st[left(i)];
            int m = (l + r) / 2;
            if(k <= lt) return kth(l, m, k, left(i));
            else return kth(m + 1, r, k - lt, right(i));
        }

        int left(int i) {return (i<<1) + 1;}
        int right(int i) {return (i<<1) + 2;}
    }
}