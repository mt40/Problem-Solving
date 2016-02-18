package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_PARKET1 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int r = in.i(), b = in.i();
        int s = r + b;
        int k = -(2 + r/2);
        int delta = k*k-4*s;
        int x = (-k + (int)Math.sqrt(delta)) / 2;
        int y = s / x;
        out.printf("%d %d\n", Math.max(x, y), Math.min(x, y));
    }
}