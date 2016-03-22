package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_CHOTU {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int x = in.i(), y = in.i();

        double ans = 2*Math.sqrt(x*x - y*y);
        out.printf("%.3f\n", ans);
    }
}