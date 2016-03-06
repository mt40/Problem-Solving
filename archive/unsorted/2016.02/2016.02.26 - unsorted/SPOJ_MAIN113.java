package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_MAIN113 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();

        long [][][]dp = new long[Math.max(3, n + 1)][3][3];
        for(int i = 0; i < 3; ++i)
            for(int j = 0; j < 3; ++j)
                dp[1][i][j] = dp[2][i][j] = 1;
        for(int i = 3; i <= n; ++i) {
            dp[i][0][0] = dp[i-1][0][0] + dp[i-1][0][1] + dp[i-1][0][2]; // _xx
            dp[i][0][1] = dp[i-1][1][0] + dp[i-1][1][1]; // xyx, yyx
            dp[i][0][2] = dp[i-1][2][0] + dp[i-1][2][2]; // xzx, zzx

            dp[i][1][1] = dp[i-1][1][0] + dp[i-1][1][1] + dp[i-1][1][2]; // _yy
            dp[i][1][0] = dp[i-1][0][0] + dp[i-1][0][1]; // xxy, yxy
            dp[i][1][2] = dp[i-1][2][1] + dp[i-1][2][2]; // yzy, zzy

            dp[i][2][2] = dp[i-1][2][0] + dp[i-1][2][1] + dp[i-1][2][2]; // _zz
            dp[i][2][0] = dp[i-1][0][0] + dp[i-1][0][2]; // xxz, zxz
            dp[i][2][1] = dp[i-1][1][1] + dp[i-1][1][2]; // yyz, zyz
        }

        long ans = 0;
        for(int i = 0; i < 3; ++i)
            for(int j = 0; j < 3; ++j)
                ans += dp[n][i][j];
        if(n == 1) ans = 3;

        out.println(ans);
    }
}