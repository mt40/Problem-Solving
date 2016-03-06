package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.math.BigDecimal;

import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_630B {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), t = in.i();
        double i = 1.000000011;
        double ans = n*Math.pow(i,t);
        out.println(new BigDecimal(ans).setScale(12, BigDecimal.ROUND_HALF_UP));
    }
}