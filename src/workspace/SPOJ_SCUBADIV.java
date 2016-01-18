package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;
import helperClasses.ShortScanner;
import helperClasses.Util;

public class SPOJ_SCUBADIV {
    int inf = 1000000;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int o2 = in.i(), n2 = in.i();
        int n = in.i();

        int [][][]dp = new int[o2+1][n2+1][n + 1];
        for(int i = 0; i < n; ++i) {
            int a = in.i(), b = in.i(), w = in.i();
            for(int j = 0; j <= o2; ++j) {
                for(int k = 0; k <= n2; ++k) {
                    int x = Math.min(o2, j + a), y = Math.min(n2, k + b);
                    if(i > 0) { // copy results from previous iteration
                        if(dp[j][k][i] == 0)
                            dp[j][k][i] = dp[j][k][i - 1];
                        else if(dp[j][k][i - 1] > 0)
                            dp[j][k][i] = Math.min(dp[j][k][i - 1], dp[j][k][i]);
                    }
                    if((j == 0 && k == 0) || dp[j][k][i] > 0) {
                        int cost = dp[j][k][i] + w;
                        dp[x][y][i + 1] = (dp[x][y][i+1] == 0) ? cost : Math.min(cost, dp[x][y][i+1]);
                        //System.out.println(dp[x][y]);
                    }
                }
            }
        }

        int ans = inf;
        for(int i = 1; i <= n; ++i)
            if(dp[o2][n2][i] > 0)
                ans = Math.min(dp[o2][n2][i], ans);
        out.println(ans);
    }
}
