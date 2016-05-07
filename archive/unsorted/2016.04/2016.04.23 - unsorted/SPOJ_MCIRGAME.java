package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.math.BigInteger;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_MCIRGAME {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int lim = 300;
        BigInteger[]dp = new BigInteger[lim + 1];
        dp[0] = BigInteger.ONE;
        for(int i = 1; i <= lim; ++i)
            dp[i] = BigInteger.ZERO;

        for(int i = 2; i <= lim; i += 2) {
            for(int j = 0; j <= i - 2; ++j) {
                BigInteger add = dp[j].multiply(dp[i - 2 - j]);
                dp[i] = dp[i].add(add);
            }
        }

        int n;
        while((n = in.i()) > 0) {
            out.println(dp[2 * n]);
        }
    }
}