package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_RPLB {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), k = in.i();
        int []a = in.arr(n, true);

        int [][]dp = new int[n+1][k+1];
        for(int i = 1; i <= n; ++i) {
            for(int j = 0; j <= k; ++j) {
                if (i == 1) {
                    if(a[i] <= j)
                        dp[i][j] = a[i];
                }
                else {
                    if (j - a[i] < 0)
                        dp[i][j] = dp[i - 1][j];
                    else
                        dp[i][j] = Math.max(a[i] + dp[i - 2][j - a[i]], dp[i - 1][j]);
                }
            }
        }

        out.printf("Scenario #%d: %d\n", testNumber, dp[n][k]);
    }
}