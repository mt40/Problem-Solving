package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_AMZSEQ {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int [][]dp = new int[3][n + 1];
        dp[0][1] = dp[1][1] = dp[2][1] = 1;
        for(int i = 2; i <= n; ++i) {
            dp[0][i] = dp[0][i - 1] + dp[1][i - 1];
            dp[1][i] = dp[0][i - 1] + dp[1][i - 1] + dp[2][i - 1];
            dp[2][i] = dp[1][i - 1] + dp[2][i - 1];
        }

        out.println(dp[0][n] + dp[1][n] + dp[2][n]);
    }
}