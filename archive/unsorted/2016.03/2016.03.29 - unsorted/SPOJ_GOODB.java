package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_GOODB {
    int inf = Integer.MAX_VALUE;
    final int mod = 1000*1000*1000+7;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), w = in.i(), t = in.i(), r = in.i();

        long [][]dp = new long[301][301];
        for(int i = 1; i <= 300; ++i)
            dp[i][i] = dp[i][0] = 1;
        for(int i = 1; i <= 300; ++i) {
            for(int k = 1; k < i && k <= 100; ++k) {
                dp[i][k] = (dp[i - 1][k - 1] + dp[i - 1][k]) % mod;
            }
        }

        long ans = (dp[n][w] * dp[n-w][t]) % mod;
        out.println(ans);
    }
}