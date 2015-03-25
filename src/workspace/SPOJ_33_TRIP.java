package workspace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class SPOJ_33_TRIP {
    int n, m, lcs;
    char []a; char []b;
    int [][]dp;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next();
        String t = in.next();
        n = s.length();
        m = t.length();
        a = new char[n + 1]; b = new char[m + 1];
        for(int i = 0; i < n; ++i) a[i + 1] = s.charAt(i);
        for(int i = 0; i < m; ++i) b[i + 1] = t.charAt(i);

        // dp[i][j] = longest sub-sequence of string s(0...i) and t(0...j)
        dp = new int[n + 1][m + 1];
        for(int i = 1; i <= n; ++i) {
            for(int j = 1; j <= m; ++j) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                if(a[i] == b[j])
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
            }
        }

        lcs = dp[n][m];
        solve(1, 1, "", new ArrayList<String>());
    }

    void solve(int i, int j, String c, List<String> visited) {
        if(c.length() == lcs && !visited.contains(c)) {
            System.out.println(c);
            visited.add(c);
            return;
        }

        if(i < n && j < m && dp[i + 1][j + 1] > dp[i][j])
            solve(i + 1, j + 1, c + a[i], visited);

        j++;
        if(j > m) {
            j = 1;
            i++;
            if(i > n) return;
        }
        solve(i, j, c, visited);
    }
}
