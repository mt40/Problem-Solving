package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_NUMOFPAL {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        char []a = in.c();
        int n = a.length;

        boolean [][]dp = new boolean[n][n];
        for(int i = 0; i < n; ++i)
            dp[i][i] = true;
        for(int i = 0; i < n - 1; ++i)
            dp[i][i + 1] = a[i] == a[i + 1];
        for(int len = 3; len <= n; ++len) {
            for(int i = 0; i < n && i + len - 1 < n; ++i) {
                int j = i + len - 1;
                if(a[i] == a[j] && dp[i + 1][j - 1])
                    dp[i][j] = true;
            }
        }

        int palindromes = 0;
        for(int i = 0; i < n; ++i)
            for(int j = i; j < n; ++j)
                if(dp[i][j])
                    palindromes++;

        out.println(palindromes);
    }
}