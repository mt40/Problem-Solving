package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class SPOJ_MMAXPER {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int []h = new int[n];
        int []w = new int[n];
        for(int i = 0; i < n; ++i) {
            h[i] = in.nextInt();
            w[i] = in.nextInt();
        }

        /*
        dp[i][0] = kết quả cho tới hình thứ i nếu hình này dc đặt đứng
        dp[i][1] = kết quả cho tới hình thứ i nếu hình này dc đặt nằm
         */
        int [][]dp = new int[n][2];
        dp[0][0] = h[0]; dp[0][1] = w[0];
        for(int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(
                    dp[i - 1][0] + h[i] + Math.abs(w[i] - w[i - 1]),
                    dp[i - 1][1] + h[i] + Math.abs(w[i] - h[i - 1]));
            dp[i][1] = Math.max(
                    dp[i - 1][0] + w[i] + Math.abs(h[i] - w[i - 1]),
                    dp[i - 1][1] + w[i] + Math.abs(h[i] - h[i - 1]));
        }
        int ans = Math.max(dp[n - 1][0], dp[n - 1][1]);
        out.println(ans);
    }
}
