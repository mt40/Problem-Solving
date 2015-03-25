package workspace;

import helperClasses.InputReader;

import java.io.PrintWriter;
import java.util.Arrays;

public class SPOJ_ROCK {
    int[] cnt, a;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        char[] tmp = in.next().toCharArray();
        a = new int[n];
        for (int i = 0; i < n; ++i)
            a[i] = tmp[i] - '0';

        cnt = new int[n];
        cnt[0] = a[0];
        for (int i = 1; i < n; ++i)
            cnt[i] = a[i] == 1 ? cnt[i - 1] + 1 : cnt[i - 1];

        /*
        dp[i][j] = kết quả tốt nhất trong đoạn i..j
        Cách tính:
            one = số số 1 trong đoạn i..j
            zero = số số 0
            Nếu one nhiều hơn zero thì dp[i][j] = cả đoạn
            else nếu a[i] = 1 thì chỉ + thêm 1
            nếu a[i] = 0 thì ko thêm dc gì
            Cuối cùng kiểm tra coi có số k sao cho i...k...j
            mà dp[i][k] + dp[k + 1][j] lớn hơn dp[i][j] vừa tính ở trên ko
         */
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; ++i)
            dp[i][i] = a[i];
        for (int len = 2; len <= n; ++len) {
            for (int i = 0; i + len - 1 < n; ++i) {
                int j = i + len - 1;
                int one = countOne(i, j);
                int zero = len - one;
                if (one > zero)
                    dp[i][j] = len;
                else
                    dp[i][j] = a[j] == 1 ? dp[i][j - 1] + 1 : dp[i][j - 1];
                // also calculate score inside
                for (int k = i; k < j; ++k)
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k + 1][j]);
            }
        }

        out.println(dp[0][n - 1]);
    }

    int countOne(int l, int r) {
        return cnt[r] - cnt[l] + a[l];
    }
}
