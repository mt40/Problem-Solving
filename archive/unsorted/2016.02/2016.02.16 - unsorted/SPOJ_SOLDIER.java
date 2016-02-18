package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_SOLDIER {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), m = in.i();
        HashMap<Integer, ArrayList<Pair>> map = new HashMap<>(7);
        for(int i = 0; i < n; ++i) {
            int t = in.i(), p = in.i(), q = in.i();

            if(!map.containsKey(t))
                map.put(t, new ArrayList<>());
            map.get(t).add(new Pair(p, q));
        }

        boolean ok = true;
        int[][] dp = new int[m + 1][7];
        if(map.size() < 6)
            ok = false;
        else {
            List<Pair> one = map.get(1);
            for (Pair p : one) {
                if (p.p <= m)
                    dp[m - p.p][1] = p.q;
            }

            for (int j = 2; j <= 6; ++j) {
                List<Pair> items = map.get(j);

                for (Pair it : items) {
                    for (int i = m; i >= 0; --i) {
                        if (dp[i][j - 1] > 0) {
                            int left = i - it.p;
                            if (left >= 0) {
                                int qlt = Math.min(dp[i][j - 1], it.q);
                                dp[left][j] = Math.max(qlt, dp[left][j]);
                            }
                        }
                    }
                }
            }
        }

        if(!ok)
            out.println(0); // not enough 6 types of item
        else {
            int ans = -inf;
            for (int i = 0; i <= m; ++i)
                if (dp[i][6] > 0)
                    ans = Math.max(dp[i][6], ans);
            if(ans == -inf)
                out.println(0); // cannot afford 6 items
            else
                out.println(ans);
        }
    }

    class Pair {
        int p, q;

        public Pair(int p, int q) {
            this.p = p;
            this.q = q;
        }
    }
}