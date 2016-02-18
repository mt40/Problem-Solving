package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_LISA {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        char []a = in.c();
        int n = a.length;

        long [][]dp = new long[n][n], dp2 = new long[n][n];
        for(long []ll : dp2) Arrays.fill(ll, -1);
        for(int i = 0; i < n; ++i) {
            if(Character.isDigit(a[i])) {
                dp[i][i] = dp2[i][i] = a[i] - '0';
            }
        }

        for(int len = 3; len <= n; len += 2) {
            for(int i = 0; i + len - 1 < n; ++i) {
                int j = i + len - 1;
                for(int k = i; k + 2 <= j; k += 2) {
                    char sign = a[k + 1];
                    dp[i][j] = max(cal(sign, dp[i][k], dp[k + 2][j]), dp[i][j]);
                    //System.out.printf("%d %d %d: %d\n", i, k, j, dp[i][j]);
                    if(dp2[i][j] == -1)
                        dp2[i][j] = cal(sign, dp2[i][k], dp2[k + 2][j]);
                    else
                        dp2[i][j] = min(cal(sign, dp2[i][k], dp2[k + 2][j]), dp2[i][j]);
                }
            }
        }

        out.printf("%s %s\n",
                Long.toUnsignedString(dp[0][n-1]),
                Long.toUnsignedString(dp2[0][n-1]));
    }

    long max(long a, long b) {
        return Long.compareUnsigned(a, b) >= 0 ? a : b;
    }

    long min(long a, long b) {
        return Long.compareUnsigned(a, b) < 0 ? a : b;
    }

    long cal(char sign, long x, long y) {
        if(sign == '+') return x + y;
        return x * y;
    }
}