package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.math.BigDecimal;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_PIVAL {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        double pi = 20*Math.atan(1.0/7) + 8 * Math.atan(3.0/79);
        out.println(BigDecimal.valueOf(pi).setScale(100, BigDecimal.ROUND_HALF_UP));
    }
}