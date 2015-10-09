package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CombinationNoOverflow {
    /**
     * The idea is to use the additive formula
     * n C k = (n-1) C (k-1) + (n-1) C k
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), k = in.nextInt();
        out.println(combination(n, k));
    }

    int combination(int n, int k) {
        int [][]dp = new int[n + 1][k + 1];
        // base case n C 0 = 1
        for(int i = 0; i <= n; ++i)
            dp[i][0] = 1;
        // base case n C n = 1
        for(int i = 0; i <= k; ++i)
            dp[i][i] = 1;

        for(int i = 2; i <= n; ++i) {
            for(int j = 1; j < Math.min(i, k + 1); ++j) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        return dp[n][k];
    }
}
