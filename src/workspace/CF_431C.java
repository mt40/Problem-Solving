package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class CF_431C {
    int mod = 1000000007;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int d = in.nextInt();

        /**
         * ý tưởng:
         * dp[i][j][0] =  số path tính cho tới height i, tổng weight là j
         *              và chỉ qua các edge < d
         * dp[i][j][1] = số path tính cho tới height i, tổng weight là j
         *              và đã đi qua edge >= d
         */
        long[][][] dp = new long[101][101][2];
        for (int i = 1; i <= k; ++i) {
            if (i >= d)
                dp[1][i][1] = 1; // có chứa path >= d
            else
                dp[1][i][0] = 1;
        }
        for(int i = 2; i <= 100; ++i) {
            for(int j = 1; j <= 100; ++j) {
                for(int w = 1; w <= k; ++w) {
                    if(j - w <= 0)
                        continue;
                    if(w < d)
                        dp[i][j][0] += dp[i - 1][j - w][0] % mod;
                    dp[i][j][1] += dp[i - 1][j - w][1] % mod;
                    if(w >= d) {
                        dp[i][j][1] += dp[i - 1][j - w][0] % mod;
                        dp[i][j][1] %= mod;
                    }
                }
            }
        }

        long ans = 0;
        for(int i = 1; i <= 100; ++i)
            ans += dp[i][n][1] % mod;

        out.println(ans % mod);
    }
}
