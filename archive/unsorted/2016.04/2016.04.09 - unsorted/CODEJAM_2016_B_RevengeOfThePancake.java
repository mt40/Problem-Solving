package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class CODEJAM_2016_B_RevengeOfThePancake {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        char[] a = in.c();
        int n = a.length;

        char prev = a[0];
        long ans = 0;
        boolean hasMinus = prev == '-';
        for (int i = 1; i < n; ++i) {
            char c = a[i];
            if (c == '-') {
                if (prev == '+')
                    ans += hasMinus ? 2 : 1;
                hasMinus = true;
            }
            prev = c;
        }

        if (hasMinus) ans++;

        out.printf("Case #%d: %d\n", testNumber, ans);
    }
}