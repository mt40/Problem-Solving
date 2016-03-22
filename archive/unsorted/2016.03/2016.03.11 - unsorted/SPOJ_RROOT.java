package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.math.BigDecimal;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_RROOT {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        double negArea = 2 * 2.0/3 * Math.pow(n/2.0, 3.0/2);
        double area = 1L * n * n;
        double ans = 1 - negArea/area;
        out.printf("%.6f\n", new BigDecimal(ans).setScale(12, BigDecimal.ROUND_HALF_UP));
    }
}