package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_RPLH {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int d = in.i(), v = in.i();
        double pi = 2 * Math.acos(0), g = 9.806;
        double sin = d * g / (v*v);
        boolean ok = true;
        if(sin > 1) ok = false;
        double a = -1;
        if(ok) {
            a = Math.asin(sin)/2 * 180 / pi;
            if(a < 0 || a > 45) ok = false;
        }
        if(ok)
            out.printf("Scenario #%d: %.2f\n", testNumber, a);
        else
            out.printf("Scenario #%d: -1\n", testNumber);
    }
}