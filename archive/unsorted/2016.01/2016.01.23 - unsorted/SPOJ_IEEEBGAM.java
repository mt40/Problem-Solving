package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.math.BigDecimal;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_IEEEBGAM {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        double d = 1.0/n;
        double ans = d * (n - 1) + d * (1.0/(n + 1));
        out.printf("%.8f\n", new BigDecimal(ans).setScale(16, BigDecimal.ROUND_HALF_UP));
    }
}