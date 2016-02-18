package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_DCEPC501 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        n = in.i();
        int []a = in.arr(n, true);

        long []dp = new long[n + 2];
        for(int i = 1; i <= n; ++i) {
            if(i == 1 || dp[i] > 0) {
                int amt = a[i];
                dp[id(i + 2)] = Math.max(dp[i] + amt, dp[id(i + 2)]);
                if(i + 1 <= n) {
                    amt += a[i + 1];
                    dp[id(i + 4)] = Math.max(dp[i] + amt, dp[id(i + 4)]);
                }
                if(i + 2 <= n) {
                    amt += a[i + 2];
                    dp[id(i + 6)] = Math.max(dp[i] + amt, dp[id(i + 6)]);
                }
            }
        }

        out.println(dp[n + 1]);
    }

    int n;
    int id(int i) {
        return Math.min(i, n + 1);
    }
}