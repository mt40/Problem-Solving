package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class RodCutting {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int q = in.nextInt(); // number of queries
        int n = in.nextInt();
        int []p = new int[n + 1];

        for(int i = 1; i <= n; ++i)
            p[i] = in.nextInt();

        int []dp = new int[n + 1];
        dp[1] = p[1];
        for(int i = 2; i <= n; ++i) {
            int max = p[i];
            for(int j = 1; j <= i / 2; ++j) {
                max = Math.max(max, dp[j] + dp[i - j]);
            }
            dp[i] = max;
        }

        for(int i = 1; i <= n; ++i) {
            out.printf("%d: %d\n", i, dp[i]);
        }
    }
}
