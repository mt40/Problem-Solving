package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_EDIT {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        String s;
        while(true) {
            try {
                s = in.s();
            }
            catch (Exception e) { return; }
            char []a = s.toCharArray();
            int n = a.length;
            int [][]dp = new int[n + 1][2];
            for(int i = 1; i <= n; ++i) {
                if(a[i-1] < 'a') {
                    dp[i][1] = dp[i - 1][0];
                    dp[i][0] = 1 + dp[i - 1][1];
                }
                else {
                    dp[i][1] = 1 + dp[i - 1][0];
                    dp[i][0] = dp[i - 1][1];
                }
            }

            out.println(Math.min(dp[n][0], dp[n][1]));
        }
    }
}