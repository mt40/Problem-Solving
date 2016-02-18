package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_KQUERY {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []a = in.arr(n);

        int Q = in.i();
        Query []query = new Query[Q];
        for(int i = 0; i < Q; ++i)
            query[i] = new Query(in.i(), in.i(), in.i());

        // compress
        TreeSet<Integer> set = new TreeSet<>();
        for(int ai : a) set.add(ai);
        for(Query qi : query) set.add(qi.k);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : set)
            map.put(i, map.size() + 1);

        for(int i = 0; i < n; ++i)
            a[i] = map.get(a[i]);

        BIT tree = new BIT(map.size(), a);

        // query
        for(Query q : query) {
            int k = map.get(q.k);
            long smaller = tree.get(q.r, k) - tree.get(q.l - 1, k);
            long bigger = q.r - q.l + 1 - smaller;
            out.println(bigger);
        }
    }

    class Query {
        int l, r, k;

        public Query(int l, int r, int k) {
            this.l = l;
            this.r = r;
            this.k = k;
        }
    }

    class BIT {
        long [][]ar;
        int n, m;

        public BIT(int max, int []src) {
            this.n = src.length;
            this.m = max;
            ar = new long[n + 1][m + 1];
            for(int i = 0; i < n; ++i) {
                set(i + 1, src[i], 1);
            }
        }

        void set(int i, int j, long val) {
            while(i <= n) {
                int y = j;
                while(y <= m) {
                    ar[i][y] += val;
                    y += y & (-y);
                }
                i += i & (-i);
            }
        }

        long get(int i, int j) {
            long rs = 0;
            while(i > 0) {
                int y = j;
                while(y > 0) {
                    rs += ar[i][y];
                    y -= y & (-y);
                }
                i -= i & (-i);
            }
            return rs;
        }
    }
}