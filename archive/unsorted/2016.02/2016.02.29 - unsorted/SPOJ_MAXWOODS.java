package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_MAXWOODS {
    int inf = Integer.MAX_VALUE;
    char [][]a;
    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), m = in.i();
        a = in.c(n, m);

        int [][][]dp = new int[n][m][2];
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < m; ++j)
                dp[i][j][0] = dp[i][j][1] = -1; // not available
        int ans = 0;
        dp[0][0][1] = value(0, 0); // at first, we head right
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) { // scan the current row
                if(a[i][j] == '#') continue;
                if(dp[i][j][0] >= 0) { // found a left turn
                    for(int k = j; k >= 0; --k) {
                        if(a[i][k] == '#') break; // stop here!
                        if(k < j)
                            dp[i][k][0] = Math.max(dp[i][k+1][0] + value(i,k), dp[i][k][0]);
                        if(i < n - 1 && a[i+1][k] != '#') // also go down
                            dp[i+1][k][1] = Math.max(dp[i][k][0] + value(i+1,k), dp[i+1][k][1]);
                    }
                }
                if(dp[i][j][1] >= 0) { // found a right turn
                    for(int k = j; k < m; ++k) {
                        if(a[i][k] == '#') break; // stop!
                        if(k > j)
                            dp[i][k][1] = Math.max(dp[i][k-1][1] + value(i,k), dp[i][k][1]);
                        if(i < n - 1 && a[i+1][k] != '#') // also go down
                            dp[i+1][k][0] = Math.max(dp[i][k][1] + value(i+1,k), dp[i+1][k][0]);
                    }
                }
            }
        }
//
//        for(int i = 0; i < n; ++i, System.out.println())
//            for(int j = 0; j < m; ++j)
//                System.out.printf("%d,%d ", dp[i][j][0], dp[i][j][1]);

        for(int i = 0; i < n; ++i)
            for(int j = 0; j < m; ++j)
                ans = Util.max(dp[i][j][0], dp[i][j][1], ans);

        out.println(ans);
    }

    int value(int i, int j) {
        return (a[i][j] == 'T')
                ? 1
                : (a[i][j] == '#') ? -1 : 0;
    }
}