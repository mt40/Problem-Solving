package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class SPOJ_63_SQRBR {
    int n, k;
    int []memo;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        n = in.nextInt(); n *= 2;
        k = in.nextInt();

        memo = new int[n + 1];
        for(int i = 0; i < k; ++i) {
            int pos = in.nextInt();
            memo[pos] = 1;
        }

        long [][]dp = new long[n + 1][n + 1];
        dp[1][1] = 1;
        for(int i = 2; i <= n; ++i) {
            for(int j = 0; j < n; ++j) {
                if(memo[i] != 1) {
                    if(j == 0)
                        dp[i][0] = dp[i - 1][1];
                    else
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }
                else {
                    if(j == 0)
                        dp[i][0] = 0;
                    else
                        dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        out.println(dp[n][0]);
    }
}
