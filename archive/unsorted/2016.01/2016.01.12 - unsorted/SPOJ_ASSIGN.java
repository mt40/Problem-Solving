package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_ASSIGN {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int [][]a = new int[n][n];
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < n; ++j)
                a[i][j] = in.i();

        int m = 1 << n;
        long [][]dp = new long[n][m];
        for(int i = 0; i < n; ++i)
            if(a[0][i] == 1)
                dp[0][1 << i] = 1;
        for(int i = 1; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                if(dp[i-1][j] > 0) {
                    for(int k = 0; k < n; ++k) {
                        if(a[i][k] == 1 && (j & (1 << k)) == 0) {
                            dp[i][j | (1 << k)] += dp[i-1][j];
                        }
                    }
                }
            }
        }
        //for(long []i : dp) System.out.println(Arrays.toString(i));

        long ans = dp[n - 1][m-1];
        out.println(ans);
    }
}