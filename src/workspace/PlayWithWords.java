package workspace;

import jdk.internal.util.xml.impl.Pair;

import java.util.Scanner;
import java.io.PrintWriter;

public class PlayWithWords {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next();
        int n = s.length();

        int [][]dp = new int[n][n];

        // preprocess for length 1
        for(int i = 0; i < n; ++i)
            dp[i][i] = 1;

        // length >= 2
        for(int len = 2; len <= n; ++len) {
            for(int i = 0; i + len - 1 < n; ++i) {
                int j = i + len - 1;
                dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                if(s.charAt(i) == s.charAt(j))
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 2);
            }
        }

        // find i so that dp[0][i] * dp[i + 1][n - 1] is maximum
        int max = 0;
        for(int i = 0; i + 1 < n; ++i) {
            if(dp[0][i] * dp[i + 1][n - 1] > max)
                max = dp[0][i] * dp[i + 1][n - 1];
        }

        out.println(max);
    }

    void print(int[][]dp, PrintWriter out) {
        for(int i = 0; i < dp.length; ++i) {
            for(int j = 0; j < dp.length; ++j)
                out.print(dp[i][j] + " ");
            out.println();
        }
    }
}
