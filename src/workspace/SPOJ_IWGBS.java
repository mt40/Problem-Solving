package workspace;

import java.math.BigInteger;
import java.util.Scanner;
import java.io.PrintWriter;

public class SPOJ_IWGBS {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        BigInteger [][]dp = new BigInteger[n + 1][2];
        dp[1][1] = dp[1][0] = BigInteger.ONE;
        for(int i = 2; i <= n; ++i) {
            dp[i][1] = dp[i - 1][0].add(dp[i - 1][1]);
            dp[i][0] = dp[i - 1][1];
        }

        out.println(dp[n][1].add(dp[n][0]));
    }
}
