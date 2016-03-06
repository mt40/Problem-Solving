package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_629D {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        Cake []a = new Cake[n];
        long []vol = new long[n];
        for(int i = 0; i < n; ++i) {
            a[i] = new Cake(in.i(), in.i());
            vol[i] = a[i].v;
        }

        Arrays.sort(vol);

        SegTree tree = new SegTree(n);
        for(Cake ai : a) {
            int idx = bSearch(vol, ai.v);
            long smaller_max = tree.getMax(0, idx-1);
            tree.set(idx, smaller_max + ai.v);
        }

        long ans = tree.ar[0];
        out.println(new BigDecimal(ans * Math.acos(-1)).setScale(12, BigDecimal.ROUND_HALF_UP));
    }

    int bSearch(long []a, long key) {
        int low = 0, hi = a.length - 1, rs = -1;
        while(low <= hi) {
            int m = low + (hi - low) / 2;
            if(a[m] == key) {
                rs = m;
                hi = m - 1;
            }
            else if(a[m] < key)
                low = m + 1;
            else
                hi = m - 1;
        }
        return rs;
    }

    class SegTree {
        long []ar;
        int src_len;

        SegTree(int n) {
            int h = (int)Math.ceil(Math.log(n) / Math.log(2));
            int size = (1 << (h + 1)) - 1;
            ar = new long[size];
            this.src_len = n;
        }

        void set(int idx, long v) {
            set(0, src_len - 1, 0, idx, v);
        }

        long set(int l, int r, int i, int idx, long v) {
            if(idx < l || r < idx) return ar[i]; // out of range

            if(l == r)
                return ar[i] = v;
            else {
                int m = (l + r) / 2;
                return ar[i] = Math.max(
                        set(l, m, left(i), idx, v),
                        set(m + 1, r, right(i), idx, v)
                );
            }
        }

        long getMax(int ql, int qr) {
            if(qr < ql) return 0;
            return getMax(0, src_len - 1, ql, qr, 0);
        }

        long getMax(int l, int r, int ql, int qr, int i) {
            if(qr < l || r < ql) return 0;
            if(ql <= l && r <= qr)
                return ar[i];
            int m = (l + r) / 2;
            return Math.max(
                    getMax(l, m, ql, qr, left(i)),
                    getMax(m + 1, r, ql, qr, right(i))
            );
        }

        int left(int i) {
            return (i << 1) + 1;
        }

        int right(int i) {
            return (i << 1) + 2;
        }
    }

    class Cake {
        int r, h;
        long v;

        public Cake(int r, int h) {
            this.r = r;
            this.h = h;
            v = 1L*r*r*h;
        }
    }
}