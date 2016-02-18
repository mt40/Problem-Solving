package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_FANCY {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        char[] c = in.c();
        int n = c.length, len = 1, ans = 1;
        for (int i = 1; i < n; ++i) {
            if (c[i] == c[i - 1])
                len++;
            else {
                ans *= cal(len);
                len = 1;
            }
        }
        if (len > 0)
            ans *= cal(len);

        out.println(ans);
    }

    int cal(int n) {
        return 1 << (n - 1);
    }
}