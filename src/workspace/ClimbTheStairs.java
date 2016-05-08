package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

/**
 * We have to climb N-step stairs. In 1 turn, we are allowed
 * to climb 1,2,...,k steps at once. Find how many ways to
 * climb the stairs
 */
public class ClimbTheStairs {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), k = in.i();

        int []dp = new int[n + 1];
        for(int i = 0; i < n; ++i) {
            for(int j = 1; j <= k; ++j) {
                int dest = Math.min(i + j, n);
                dp[dest] += 1;
            }
        }

        out.println(dp[n]);
    }
}