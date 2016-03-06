package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPJ_MPILOT {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []cap = new int[n+1], ass = new int[n+1];
        for(int i = 1; i <= n; ++i) {
            cap[i] = in.i();
            ass[i] = in.i();
        }

        int [][]dp = new int[n + 1][n+1];
        for(int []i : dp) Arrays.fill(i, inf - 100001);
        dp[1][0] = ass[1];
        for(int i = 2; i <= n; ++i) {
            for(int j = 0; j <= i/2; ++j) {
                dp[i][j] = dp[i-1][j] + ass[i];
                if(j > 0)
                    dp[i][j] = Math.min(dp[i-1][j-1] + cap[i], dp[i][j]);
            }
        }

        //for(long []dpi : dp) System.out.println(Arrays.toString(dpi));

        out.println(dp[n][n/2]);
    }
}