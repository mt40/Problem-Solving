package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_AMZRCK {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int t = in.i();
        int dp[] = new int[44];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i < dp.length; ++i)
            dp[i] = dp[i - 1] + dp[i - 2];

        while(t-- > 0) {
            out.println(dp[in.i()]);
        }
    }
}