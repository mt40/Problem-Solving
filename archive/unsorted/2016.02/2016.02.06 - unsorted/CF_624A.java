package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.math.BigDecimal;

import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_624A {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int d = in.i(), l = in.i(), v1 = in.i(), v2 = in.i();
        double ans = (1.0*l - d)/(v2+v1);

        out.printf("%.20f\n", new BigDecimal(ans).setScale(20, BigDecimal.ROUND_HALF_UP));
    }
}