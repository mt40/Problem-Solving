package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_WPC4F {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();

        int [][]dp = new int[n + 1][3];
        for(int i = 1; i <= n; ++i) {
            int a = in.i(), d = in.i(), b = in.i();
            dp[i][0] = a + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = d + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = b + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        int ans = Util.min(dp[n][0], dp[n][1], dp[n][2]);
        out.println(ans);
    }
}