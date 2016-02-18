package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_LCS {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        char []a = in.c(), b = in.c();
        int n = a.length, m = b.length, k = n + m;

        char []ab = Util.join(a, b);
        int []sa = buildSuffixArr(ab);
        Pair []sorted = new Pair[k];
        for(int i = 0; i < k; ++i)
            sorted[i] = new Pair(sa[i], i);
        Arrays.sort(sorted, (o1, o2)-> Integer.compare(o1.a, o2.a));

        int ans = 0;
        for(int i = 0; i < k - 1; ++i) {
            if(sorted[i].b < n && sorted[i + 1].b >= n) {
                ans = Math.max(lcp(sorted[i].b, sorted[i + 1].b, k), ans);
            }
        }

        out.println(ans);
    }

    // longest common prefix of 2 suffixes starting at x, y
    int lcp(int x, int y, int n) {
        int log = (int)Math.ceil(Math.log(n)/Math.log(2));

        if(x == y) return n - x;

        int rs = 0;
        for(int j = log - 1; j >= 0 && x < n && y < n; --j) {
            int len = 1 << j;
            if(rank[j][x] == rank[j][y]) {
                x += len;
                y += len;
                rs += len;
            }
        }
        return rs;
    }

    int [][]rank;
    int[] buildSuffixArr(char []src) {
        int n = src.length;
        int log = (int)Math.ceil(Math.log(n)/Math.log(2));

        Entry []sf = new Entry[n];
        rank = new int[log][n];
        for(int i = 0; i < n; ++i) sf[i] = new Entry();

        for(int i = 0; i < n; ++i)
            rank[0][i] = src[i] - 'a';
        for(int j = 1; j < log; ++j) {
            int half = 1 << (j - 1);
            // merge
            for(int i = 0; i < n; ++i) {
                sf[i].l = rank[j-1][i];
                sf[i].r = (i + half < n) ? rank[j-1][i + half] : -1;
                sf[i].pos = i;
            }

            Arrays.sort(sf, cprt);
            // assign new rank
            for(int i = 0; i < n; ++i) {
                if(i == 0) rank[j][sf[i].pos] = 0;
                else {
                    int prev = rank[j][sf[i-1].pos];
                    rank[j][sf[i].pos] = sf[i].equals(sf[i-1]) ? prev : prev + 1;
                }
            }
        }
        return rank[log - 1];
    }

    Comparator<Entry> cprt = (o1,o2)-> {
        int t = Integer.compare(o1.l, o2.l);
        return (t == 0) ? Integer.compare(o1.r, o2.r) : t;
    };

    class Entry {
        int pos, l, r; // left half and right half
        boolean equals(Entry e) {
            return l == e.l && r == e.r;
        }
    }

    class Pair {
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}