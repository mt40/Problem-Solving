package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_MAY99_4 {
    int inf = Integer.MAX_VALUE;
    int mod = 1000*1000*10+7;
    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), r = in.i();

        if(n < r) out.println(-1);
        else {
            dp = new long[n][r];
            out.println(comb(n-1, r-1) % mod);
        }
    }

    long [][]dp;
    long comb(int n, int k) {
        if(k == 0 || k == n) return 1;
        if(dp[n][k] > 0) return dp[n][k];
        dp[n][k] = comb(n - 1, k - 1) % mod + comb(n - 1, k) % mod;
        return dp[n][k];
    }
}