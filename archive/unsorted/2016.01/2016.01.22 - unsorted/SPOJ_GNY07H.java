package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_GNY07H {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        dp = new int[n + 1];
        p = new int[n + 1];
        t = new int[n + 1];
        Arrays.fill(dp, -1);
        Arrays.fill(p, 1, n+1, -1);
        Arrays.fill(t, 1, n+1, -1);
        dp[0] = dp[1] = 1;
        if(n >= 2) dp[2] = 5;
        if(n >= 3) dp[3] = 11;
        p[1] = 1;
        t[1] = 1;
        if(n >= 2) t[2] = 1;

        int ans = cal_dp(n);
        out.printf("%d %d\n", testNumber, ans);
    }

    int cal_dp(int n) {
        if(dp[n] >= 0) return dp[n];
        return cal_dp(n - 1) + cal_dp(n - 2) + (cal_p(n - 1) << 1) + cal_t(n - 1);
    }

    int cal_p(int n) {
        if(p[n] >= 0) return p[n];
        return cal_dp(n - 1) + cal_p(n - 1);
    }

    int cal_t(int n) {
        if(t[n] >= 0) return t[n];
        return cal_dp(n - 1) + cal_t(n - 2);
    }

    int []p, t, dp;
}