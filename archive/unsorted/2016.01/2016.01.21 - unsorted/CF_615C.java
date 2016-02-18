package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_615C {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        char []s = in.c(), t = in.c();
        int n = s.length, m = t.length;

        int [][]lcp = new int[m+1][n+1], lcprev = new int[m+1][n+1];
        for(int i = m - 1; i >= 0; --i) {
            for(int j = n - 1; j >= 0; --j) {
                if(t[i] == s[j])
                    lcp[i][j] = lcp[i + 1][j + 1] + 1;
            }
            for(int j = 0; j < n; ++j) {
                if(t[i] == s[j])
                    lcprev[i][j] = (j == 0) ? 1 : lcprev[i + 1][j - 1] + 1;
            }
        }

        ArrayList<Pair> ans = new ArrayList<>();
        for(int i = 0; i < m;) {
            Pair x = findMax(lcp[i]);
            Pair y = findMax(lcprev[i]);
            if(x.len + y.len == 0) {
                out.println(-1);
                return;
            }
            if(x.len > y.len) {
                i += x.len;
                ans.add(new Pair(x.id+1, x.id + x.len));
            }
            else {
                i += y.len;
                ans.add(new Pair(y.id+1, y.id+1 - y.len+1));
            }
        }
        out.println(ans.size());
        for(Pair p : ans) out.println(p.id + " " + p.len);
    }

    Pair findMax(int []a) {
        Pair rs = new Pair(0, a[0]);
        for(int i = 1; i < a.length; ++i) {
            if(a[i] > rs.len) {
                rs.id = i;
                rs.len = a[i];
            }
        }
        return rs;
    }

    class Pair {
        int id, len;

        public Pair(int id, int len) {
            this.id = id;
            this.len = len;
        }
    }
}