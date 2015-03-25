package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class MBLAST {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        char []a = in.next().toCharArray();
        char []b = in.next().toCharArray();
        int k = in.nextInt();
        int n = a.length; int m = b.length;

        // dp(i,j) = minimum distance until a[i] and b[j]
        int [][]dp = new int[n + 1][m + 1];
        // base case
        for(int i = 0; i <= n; ++i)
            dp[i][0] = i * k;
        for(int j = 0; j <= m; ++j)
            dp[0][j] = j * k;

        for(int i = 1; i <= n; ++i) {
            for(int j = 1; j <= m; ++j) {
                dp[i][j] = Math.min(k + dp[i - 1][j], k + dp[i][j - 1]);
                dp[i][j] = Math.min(dp[i][j], Math.abs(a[i - 1] - b[j - 1]) + dp[i - 1][j - 1]);
            }
        }

        out.println(dp[n][m]);
    }
}
