package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_SAMER08D {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int k;
        while((k = in.i()) > 0) {
            char[] a = in.c(true);
            char[] b = in.c(true);
            int n = a.length, m = b.length;

            int ans = 0;
            int [][]dp = new int[n][m];
            int [][]streak = new int[n][m]; // longest common string until i, j
            for (int i = 1; i < n; ++i) {
                for (int j = 1; j < m; ++j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    if (a[i] == b[j])
                        streak[i][j] = 1 + streak[i - 1][j - 1];

                    // only update when the condition is met
                    if (streak[i][j] >= k) {
                        // because length > k is also valid,
                        // we have to consider that too
                        for (int h = k; h <= streak[i][j]; ++h) {
                            if (i - h < 0 || j - h < 0) break;
                            dp[i][j] = Math.max(h + dp[i - h][j - h], dp[i][j]);
                        }
                    }
                    ans = Math.max(dp[i][j], ans);
                }
            }

            out.println(ans);
        }
    }
}