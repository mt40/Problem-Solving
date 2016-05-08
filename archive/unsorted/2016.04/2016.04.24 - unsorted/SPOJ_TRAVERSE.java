package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_TRAVERSE {
    int inf = Integer.MAX_VALUE;
    int n;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        n = in.i();
        int [][]a = new int[n][n];
        for(int i = 0; i < n; ++i) {
            char []c = in.c();
            for(int j = 0; j < n; ++j)
                a[i][j] = c[j] - '0';
        }

        long [][]dp = new long[n][n];
        dp[0][0] = 1;
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                if(a[i][j] == 0)
                    continue;
                int nr = i + a[i][j];
                int nc = j + a[i][j];
                if(isReachable(nr, j))
                    dp[nr][j] += dp[i][j];
                if(isReachable(i, nc))
                    dp[i][nc] += dp[i][j];
            }
        }

        out.print(dp[n - 1][n - 1]);
    }

    boolean isReachable(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}