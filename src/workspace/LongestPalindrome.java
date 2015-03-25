package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class LongestPalindrome {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.nextLine();
        int n = s.length();

        int [][]dp = new int[n][n];

        for(int i = 0; i < n; ++i)
            dp[i][i] = 1;

        for(int len = 2; len <= n; ++len) {
            for(int i = 0; i + len - 1 < n; ++i) {
                int j = i + len - 1;
                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 2);
                }
            }
        }
        print(dp, out);

        // tim max dp[0][i] * dp[i + 1][n - 1]

        out.println(dp[0][n - 1]);

        // substring, cach O(n^2)
        boolean[][] palin = new boolean[n][n]; // bang false het :)
        for (int i = 0; i < n; ++i) palin[i][i] = true;
        for (int i = 0; i + 1 < n; ++i)
            if (s.charAt(i) == s.charAt(i + 1)) palin[i][i + 1] = true;
        for (int len = 3; len <= n; ++len) {
            for (int i = 0; i + len - 1 < n; ++i) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j))
                    palin[i][j] = palin[i + 1][j - 1];
                // else palin[i][j] = false, ko can code
            }
        }

        int maxLen = 0;
        for (int i = 0; i < n; ++i)
            for (int j = i; j < n; ++j)
                if (palin[i][j]) {
                    // ...
                }
    }

    public void print(int [][]dp, PrintWriter out) {
        for(int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < dp.length; ++j)
                out.print(dp[i][j] + " ");
            out.println();
        }
    }
}
