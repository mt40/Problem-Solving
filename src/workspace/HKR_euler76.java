package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class HKR_euler76 {
    long mod = 1000000007;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        /**
         * dp(i,j) = k?t qu? cho t?i i mà ?ã xem xét s? j
         */
        long [][]dp = new long[n + 1][n];

        // base case
        Arrays.fill(dp[0], 1);
        for(int i = 1; i <= n; ++i) {
            for(int j = 0; j < n; ++j) {
                long x = (j > 0) ? dp[i][j - 1] : 0; // dont use j
                long y = (i - j >= 0) ? dp[i-j][j] : 0; // use j
                dp[i][j] = (x % mod + y % mod) % mod;
            }
        }

        out.println(dp[n][n - 1]);
    }
}
