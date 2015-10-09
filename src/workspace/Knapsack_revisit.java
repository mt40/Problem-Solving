package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class Knapsack_revisit {

    /**
     * This is an optimized version since it uses
     * only O(n) space
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), limit = in.nextInt();
        int[] v = new int[n], w = new int[n];
        for (int i = 0; i < n; ++i)
            v[i] = in.nextInt();
        for (int i = 0; i < n; ++i)
            w[i] = in.nextInt();

        int max = 0;
        int[] dp = new int[limit + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = limit; j >= 0; --j) { // go from right to left is important!
                if (j - w[i] >= 0)
                    dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
                max = Math.max(dp[j], max);
            }
        }

        System.out.println(Arrays.toString(dp));

        out.println(max);
    }
}
