package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_IOIPALIN {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        char []a = new char[n+1], b = new char[n + 1];
        char []t = in.c();
        for (int i = 1; i <= n; ++i) {
            a[i] = t[i - 1];
            b[n - i + 1] = t[i - 1];
        }

        int [][]lcs = new int[n+1][2]; // longest common subsequence
        int col = 1, prev = 0, ans = 0;
        for(int i = 1; i <= n; ++i) {
            for(int j = 1; j <= n; ++j) {
                if(a[i] == b[j])
                    lcs[j][col] = 1 + lcs[j-1][prev];
                else
                    lcs[j][col] = Math.max(lcs[j][prev], lcs[j-1][col]);
                ans = Math.max(lcs[j][col], ans);
            }
            prev = col;
            col = 1 - col;
        }

        out.println(n - ans);
    }
}