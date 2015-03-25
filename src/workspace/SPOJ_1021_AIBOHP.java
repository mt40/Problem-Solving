package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class SPOJ_1021_AIBOHP {
    String s;
    String r;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        s = in.next();
        int n = s.length();
        char []a = new char[n + 1];
        for(int i = 1; i <= n; ++i) a[i] = s.charAt(i - 1);

        r = "";
        for(int i = n; i > 0; --i)
            r = r + a[i];
        char []b = new char[n + 1];
        for(int i = 1; i <= n; ++i) b[i] = r.charAt(i - 1);

        // Idea: find the Longest Common Sub-sequence of 2 strings
        // the original string and the inverse one
        // -> the answer is n - LCS (the number of different characters)
        // -------------------------------------------------------------
        int max = 0; // length of LCSuffix
        int [][]dp = new int[n + 1][n + 1];
        for(int i = 1; i <= n; ++i) {
            for(int j = 1; j <= n; ++j) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                if(b[i] == a[j])
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                if(dp[i][j] > max)
                    max = dp[i][j];
            }
        }

        out.println(n - max);
    }
}
