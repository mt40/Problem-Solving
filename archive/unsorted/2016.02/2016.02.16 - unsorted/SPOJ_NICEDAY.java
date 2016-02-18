package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_NICEDAY {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        Entry []a = new Entry[n];
        for(int i = 0; i < n; ++i)
            a[i] = new Entry(in.i(), in.i(), in.i());

        Arrays.sort(a, (o1, o2)-> Integer.compare(o1.a, o2.a));

        BIT tree = new BIT(n);
        int ans = 0;
        for(Entry ai : a) {
            int c = tree.min(ai.b - 1);
            if(c > ai.c) ans++;
            tree.add(ai.b, ai.c);
        }

        out.println(ans);
    }

    class BIT {
        int []ar, src;
        int size;

        BIT(int n) {
            size = n;
            ar = new int[n+1];
            src = new int[n + 1];
        }

        void add(int i, int val) {
            src[i] = val;
            while(i <= size) {
                ar[i] += 1;
                i += i & (-i);
            }
        }

        int get(int i) {
            int rs = 0;
            while(i > 0) {
                rs += ar[i];
                i -= i & (-i);
            }
            return rs;
        }

        // find the min value in range [0,lim]
        int min(int lim) {
            int low = 1, hi = lim, rs = inf;
            while(low <= hi) {
                int m = low + (hi - low) / 2;
                if(get(m) > 0) {
                    rs = m;
                    hi = m - 1;
                }
                else low = m + 1;
            }
            return (rs < inf) ? src[rs] : rs;
        }
    }

    class Entry {
        int a, b, c;

        public Entry(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}