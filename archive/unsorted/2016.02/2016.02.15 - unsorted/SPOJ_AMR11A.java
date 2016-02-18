package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_AMR11A {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), m = in.i();
        int[][] a = in.arr(n, m);

        /**
         * dp(i,j): minimum hp can thiet
         */
        int [][]dp = new int[n][m];
        dp[n - 1][m - 1] = 1; // base case, we need at least 1hp to survive
        for(int i = n - 1; i >= 0; --i) {
            for(int j = m - 1; j >= 0; --j) {
                if(j < m - 1 && i < n - 1)
                    dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]);
                else if(j < m - 1)
                    dp[i][j] = dp[i][j + 1];
                else if(i < n - 1)
                    dp[i][j] = dp[i + 1][j];

                dp[i][j] -= a[i][j]; // if a_ij < 0 then we need more hp
                if(dp[i][j] <= 0) // we don't need any hp (i.e we need negative amt of hp)
                    dp[i][j] = 1; // but to survive a[0,0], we need at least 1
            }
        }

        out.println(dp[0][0]);
    }
}