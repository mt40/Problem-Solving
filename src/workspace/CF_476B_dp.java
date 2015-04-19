package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class CF_476B_dp {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        char []a = in.next().toCharArray();
        char []b = in.next().toCharArray();
        int n = a.length;

        /**
         * dp[i][j] = số chuỗi có số điểm là j có độ dài là i + 1
         */
        int [][]dp = new int[n][23];
        // base case
        if(b[0] == '+' || b[0] == '?')
            dp[0][n + 1 + 1] = 1;
        if(b[0] == '-' || b[0] == '?')
            dp[0][n + 1 - 1] = 1;

        for(int i = 1; i < n; ++i) {
            for(int j = 1; j <= 21; ++j) {
                if(b[i] == '+' || b[i] == '?')
                    dp[i][j + 1] += dp[i - 1][j];
                if(b[i] == '-' || b[i] == '?')
                    dp[i][j - 1] += dp[i - 1][j];
            }
        }

        int sol = 0;
        for(int i = 0; i < n; ++i)
            sol += (a[i] == '+')? 1 : -1;

        int total = 0, right = 0;
        for(int j = 1; j <= 2 * n + 1; ++j) {
            total += dp[n - 1][j];
            if(j - n - 1 == sol)
                right += dp[n - 1][j];
        }

        out.printf("%.12f", right * 1.0 / total);
    }
}
