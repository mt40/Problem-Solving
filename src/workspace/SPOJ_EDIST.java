package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class SPOJ_EDIST {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String s1 = ' ' + in.next(); // make it 1-base index
        String s2 = ' ' + in.next();
        int n = s1.length(), m = s2.length();

        char []a = s1.toCharArray();
        char []b = s2.toCharArray();

        int [][]dp = new int[n][m];
        for(int i = 0; i < n; ++i)
            dp[i][0] = i;
        for(int i = 0; i < m; ++i)
            dp[0][i] = i;

        for(int i = 1; i < n; ++i) {
            for(int j = 1; j < m; ++j) {
                if(a[i] == b[j])
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }

        out.println(dp[n - 1][m - 1]);
    }
}
