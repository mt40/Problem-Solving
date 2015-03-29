package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class SPOJ_GNYR09F {
    int n, k;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int id = in.nextInt();
        n = in.nextInt();
        k = in.nextInt();

        /**
         * dp(i, j , 0) = số string độ dài i, có AdjBC là j và kết thúc bằng 0
         */
        int [][][]dp = new int[n + 1][k + 1][2];
        dp[1][0][0] = dp[1][0][1] = 1;
        for(int i = 2; i <= n; ++i) {
            for(int j = 0; j < i && j <= k; ++j) {
                dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1];
                dp[i][j][1] = dp[i - 1][j][0];
                if(j > 0)
                    dp[i][j][1] += dp[i - 1][j - 1][1];
            }
        }

        out.printf("%d %d\n", id, dp[n][k][0] + dp[n][k][1]);
    }

}
