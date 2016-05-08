package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_QCJ2 {
    int inf = Integer.MAX_VALUE;
    final int mod = 761238923;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int lim = 100;
        int [][]dp = new int[lim + 1][lim + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= lim; ++i) {
            for(int j = 0; j <= i; ++j) {
                for(int k = 0; k <= i - 1; ++k) {
                    if(k + j > lim) continue; // too many balls
                    dp[i][k + j] += dp[i - 1][k];
                    if(dp[i][k + j] >= mod)
                        dp[i][k + j] -= mod;
                }
            }
        }

        int n;
        while((n = in.i()) > 0) {
            long ans = dp[n][n];
            out.println(ans);
        }
    }
}