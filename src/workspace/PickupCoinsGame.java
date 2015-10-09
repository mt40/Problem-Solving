package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class PickupCoinsGame {
    /**
     * Given a line of coins and 2 players A, B.
     * Each turn, one player can pick 1 coin at either ends.
     * Find the max difference of win of A over B
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), sum = 0;
        int []a = new int[n];
        for(int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
            sum += a[i];
        }

        int [][]dp = new int[n][n];
        for(int i = 0; i < n; ++i)
            Arrays.fill(dp[i], -1);
        int player1_max = cal(a, dp, 0, n - 1);
        out.println(player1_max - (sum - player1_max));
    }

    /**
     * Idea: BOTH PLAYERS PLAY OPTIMALLY!!!
     * If A pick the left coin then in the next turn
     * B will pick such that A will have the worst result possible
     * hence, in the next turn of A which is [l + 2, r] or
     * [l + 1, r - 1], we have to choose the smaller one (a.k.a worse result)
     */
    int cal(int []a, int [][]dp, int l, int r) {
        if(l > r) return 0;
        if(dp[l][r] == -1) {
            dp[l][r] = Math.max(
                    a[l] + Math.min(
                            cal(a, dp, l + 2, r),
                            cal(a, dp, l + 1, r - 1)),
                    a[r] + Math.min(
                            cal(a, dp, l + 1, r - 1),
                            cal(a, dp, l, r - 2))
                    );
        }
        return dp[l][r];
    }
}
