package workspace;

import helperClasses.InputReader;

import java.io.PrintWriter;
import java.util.Arrays;

public class CF_467C {
    long[] cul;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        int []a = new int[n + 1];
        for(int i = 1; i <= n; ++i)
            a[i] = in.nextInt();

        cul = new long[n + 1];
        for(int i = 1; i <= n; ++i)
            cul[i] = cul[i - 1] + a[i];

        /*
        * dp[i,j] = đáp án khi pick được i cặp và đã xét đến vị trí j
        * dp[i,j] = max(pick 1 cặp mới là (j - m + 1, j), ko pick thêm gì )
         * vì Java dùng long là 8 byte -> ko đủ mem nên để tiết kiệm, chỉ dùng
         * 2 hàng của mảng dp là đủ (tức hàng 1, 2 -> khai báo dp[3][n + 1])
         */
        long ans = 0;
        long [][]dp = new long[3][n + 1];
        for(int j = m; j <= n; ++j) {
            dp[1][j] = Math.max(dp[1][j - 1], sum(j - m + 1, j));
            ans = Math.max(ans, dp[1][j]);
        }

        int prev = 1, cur = 2;
        for(int i = 2; i <= k; ++i) {
            for(int j = m; j <= n; ++j) {
                if(dp[prev][j - m] > 0) {
                    dp[cur][j] += dp[prev][j - m] + sum(j - m + 1, j);
                    dp[cur][j] = Math.max(dp[cur][j - 1], dp[cur][j]);
                    ans = Math.max(ans, dp[cur][j]);
                }
            }
            cur = prev;
            prev = 3 - cur;
            Arrays.fill(dp[cur], 0);
        }

//        for(int i = 1; i <= 2; ++i)
//            System.out.println(Arrays.toString(dp[i]));

        out.println(ans);
    }

    long sum(int l, int r) {
        return cul[r] - cul[l - 1];
    }
}
