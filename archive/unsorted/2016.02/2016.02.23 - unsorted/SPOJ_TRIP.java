package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.*;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_TRIP {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        a = in.c(true); b = in.c(true);
        int n = a.length-1, m = b.length-1;

        dp = new int[n + 1][m + 1];
        map = new List[Math.min(n,m) + 1];
        for(int i = 0; i < map.length; ++i)
            map[i] = new LinkedList<>();
        for(int i = 1; i <= n; ++i) {
            for(int j = 1; j <= m; ++j) {
                if(a[i] == b[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    map[dp[i][j]].add(new Pair(i, j));
                }
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        List<StringBuilder> ans = recover(n, m, dp[n][m]);
        Set<String> set = new TreeSet<>();
        for(StringBuilder si : ans)
            set.add(si.toString());
        StringBuilder sb = new StringBuilder();
        for(String si : set)
            sb.append(si).append('\n');
        out.print(sb.toString());
    }

    int [][]dp;
    List<Pair> []map;
    char []a, b;
    List<StringBuilder> recover(int ai, int bi, int len) {
        List<StringBuilder> list = new LinkedList<>();
        if(len == 0) {
            list.add(new StringBuilder(""));
            return list;
        }
        for (Pair p : map[len]) {
            int i = p.a, j = p.b;
            if (i < len || j < len || i > ai || j > bi)
                continue;
            List<StringBuilder> smaller = recover(i -1 , j - 1, len - 1);
            for (StringBuilder si : smaller)
                list.add(si.append(a[i]));
        }
        return list;
    }

    class Pair {
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}