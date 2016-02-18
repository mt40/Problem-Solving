package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_FPOLICE {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), time = in.i();
        Weight [][]g = new Weight[n][n];
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < n; ++j)
                g[i][j] = new Weight(in.i());
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < n; ++j)
                g[i][j].risk = in.i();

        long [][]dp = new long[n][time + 1];
        for(long []dpi : dp) Arrays.fill(dpi, inf);
        dp[0][0] = 0;
        for(int i = 0; i <= time; ++i) {
             for(int j = 0; j < n; ++j) {
                 if(i > 0)
                    dp[j][i] = dp[j][i - 1];
                 for(int k = 0; k < n; ++k) {
                     if(i - g[k][j].time >= 0)
                        dp[j][i] = Math.min(dp[k][i - g[k][j].time] + g[k][j].risk, dp[j][i]);
                 }
             }
        }

        long ans = inf, ans_t = inf;
        for(int i = 0; i <= time; ++i) {
            if(dp[n - 1][i] < ans) {
                ans = dp[n - 1][i];
                ans_t = i;
            }
        }

        if(ans == inf)
            out.println(-1);
        else
            out.printf("%d %d\n", ans, ans_t);

    }

    class Weight {
        int risk, time;

        public Weight(int time) {
            this(0, time);
        }

        public Weight(int risk, int time) {
            this.risk = risk;
            this.time = time;
        }
    }
}