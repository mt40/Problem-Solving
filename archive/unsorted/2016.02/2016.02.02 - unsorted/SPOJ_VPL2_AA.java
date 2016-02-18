package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_VPL2_AA {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int p0 = in.i(), p1 = in.i(), t = in.i(), p = in.i();
        double r = Math.pow(1.0*p1/p0, 1.0/t);
        double ans = Math.log(1.0*p/p0) / Math.log(r);

        out.printf("Scenario #%d: %.2f\n", testNumber, ans);
    }
}