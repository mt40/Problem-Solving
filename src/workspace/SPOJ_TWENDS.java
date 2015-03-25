package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class SPOJ_TWENDS {
    int []a;
    int n;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int cnt = 1;
        while(true) {
            n = in.nextInt();
            if(n == 0) return;
            a = new int[n];
            int total = 0, sum1 = 0;
            for(int i = 0; i < n; ++i) {
                a[i] = in.nextInt();
                total += a[i];
            }

            /*
            dp[i][j] = kết quả cho đoạn i..j
            left = nếu player 1 pick bên trái, thì đoạn còn lại là lẻ, player 2 sẽ pick đầu nào lớn hơn
            right = player 1 pick bên phải
             */
            int [][]dp = new int[n][n];
            for(int i = 0; i < n - 1; ++i)
                dp[i][i + 1] = Math.max(a[i], a[i + 1]) - Math.min(a[i], a[i + 1]);
            for(int len = 4; len <= n; len += 2) {
                for(int i = 0; i + len - 1 < n; ++i) {
                    int j = i + len - 1;
                    int left = a[i + 1] >= a[j] ? dp[i + 2][j] + a[i] - a[i + 1] : dp[i + 1][j - 1] + a[i] - a[j];
                    int right = a[i] >= a[j - 1] ? dp[i + 1][ j - 1] + a[j] - a[i] : dp[i][j - 2] + a[j] - a[j - 1];
                    dp[i][j] = Math.max(left, right);
                }
            }

            out.format("In game %d, the greedy strategy might lose by as many as %d points.\n", cnt++, dp[0][n - 1]);
        }
    }
}
