package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class SPOJ_KNAPSACK {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int s = in.nextInt();
        int n = in.nextInt();
        int []size = new int[n];
        int []val = new int[n];
        for(int i = 0; i < n; ++i) {
            size[i] = in.nextInt();
            val[i] = in.nextInt();
        }

        int [][]dp = new int[n][s + 1];
        dp[0][size[0]] = val[0];
        int ans = val[0];
        for(int i = 1; i < n; ++i) {
            for(int j = 0; j <= s; ++j) {
                if(j - size[i] >= 0)
                    dp[i][j] = dp[i - 1][j - size[i]] + val[i];
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                if(dp[i][j] > ans)
                    ans = dp[i][j];
            }
        }

        out.println(ans);
    }
}
