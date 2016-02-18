package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_518D {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        double p = in.nextDouble();
        int t = in.nextInt();

        /**
         * dp[i][j]= likelihood of there are j people in the escalator after i seconds
         */
        double [][]dp = new double[t + 1][n + 1];
        dp[1][1] = p; dp[1][0] = 1 - p;
        for(int i = 1; i < t; ++i) {
            for(int j = 0; j <= n; ++j) {
                if(j == n) // everyone is in the escalator
                    dp[i + 1][j] += dp[i][j];
                else {
                    dp[i + 1][j] += dp[i][j] * (1 - p);
                    dp[i + 1][j + 1] += dp[i][j] * p;
                }
            }
        }

        //for(int i = 0; i <= t; ++i) System.out.println(Arrays.toString(dp[i]));

        double ans = 0;
        for(int j = 0; j <= n; ++j) {
            ans += dp[t][j] * j;
        }

        out.println(round(ans));
    }

    /**
     * Round to 6 decimal places
     */
    double round(double d) {
        return Math.round(d * 1000000d) / 1000000d;
    }
}
