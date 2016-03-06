package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_630D {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        long n = in.i();
        long ans = 1;
        ans += n * (n + 1) / 2 * 6;
        out.println(ans);
    }
}