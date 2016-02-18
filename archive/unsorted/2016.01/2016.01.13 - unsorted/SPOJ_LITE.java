package workspace;

import helperClasses.FastScanner;
import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.ShortScanner;
import helperClasses.Util;

public class SPOJ_LITE {
    int inf = Integer.MAX_VALUE;

    /**
     * Apparently, this is the right solution but because the time limit
     * is very tight (require even more optimizations) so this code will
     * get TLE
     */
    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), m = in.i();
        SegmentTree tree = new SegmentTree(n);
        while(m-- > 0) {
            int t = in.i(), l = in.i() - 1, r = in.i() - 1;
            if(t == 0)
                tree.updateRange(0, n - 1, l, r, 0);
            else
                out.println(tree.getSum(0, n - 1, l, r, 0));
        }
    }

    class SegmentTree {
        int []st, lazy;

        SegmentTree(int n) {
            int h = (int)(Math.ceil(Math.log(n) / Math.log(2)));
            int size = (int)Math.pow(2, h + 1) - 1;
            st = new int[size];
            lazy = new int[size];
        }

        int getSum(int l, int r, int ql, int qr, int i) {
            if(lazy[i] > 0) doPendingUpdate(l, r, i);

            if(l > r || qr < l || r < ql) return 0;
            if(ql <= l && r <= qr) return st[i];
            int mid = (l + r) / 2;
            return getSum(l, mid, ql, qr, left(i))
                    + getSum(mid + 1, r, ql, qr, right(i));
        }

        void updateRange(int l, int r, int ul, int ur, int i) {
            if(lazy[i] > 0) doPendingUpdate(l, r, i);

            if(l > r || ur < l || r < ul) return;

            if(ul <= l && r <= ur) {
                st[i] = (r - l + 1) - st[i];

                if(l != r) { // not leaf
                    lazy[left(i)]++;
                    lazy[right(i)]++;
                }
                return;
            }

            int mid = (l + r) / 2;
            updateRange(l, mid, ul, ur, left(i));
            updateRange(mid + 1, r, ul, ur, right(i));
            st[i] = st[left(i)] + st[right(i)];
        }

        void doPendingUpdate(int l, int r, int i) {
            lazy[i] %= 2;
            if(lazy[i] > 0) {
                st[i] = (r - l + 1) - st[i];

                if(l != r) { // not leaf
                    lazy[left(i)]++;
                    lazy[right(i)]++;
                }
                lazy[i] = 0;
            }
        }

        int left(int i) { return 2 * i + 1; }
        int right(int i) {return 2 * i + 2;}
    }
}
