package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_MC {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        while(true) {
            char[] a = in.c(true);
            if(a[1] == '#') return;
            char[] b = in.c(true);
            int n = a.length - 1, m = b.length - 1;

            int[][] dp = new int[n + 1][m + 1];
            for(int i = 1; i <= m; ++i) dp[0][i] = i*30;
            for(int i = 1; i <= n; ++i) dp[i][0] = i*15;
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= m; ++j) {
                    if (a[i] != b[j])
                        dp[i][j] = Math.min(dp[i-1][j] + 15, dp[i][j-1]+30);
                    else
                        dp[i][j] = dp[i-1][j-1];
                }
            }

            out.println(dp[n][m]);
        }
    }
}