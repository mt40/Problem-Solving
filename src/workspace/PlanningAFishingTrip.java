package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class PlanningAFishingTrip {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        int [][]sea = new int[n][m];
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < m; ++j)
                sea[i][j] = in.nextInt();

        int [][]dp = new int[n][m];
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                int left = (j > 0) ? dp[i][j - 1] : 0;
                int top = (i > 0) ? dp[i - 1][j] : 0;
                dp[i][j] = Math.max(left, top) + sea[i][j];
            }
        }

        out.println(dp[n - 1][m - 1]);
    }
}
