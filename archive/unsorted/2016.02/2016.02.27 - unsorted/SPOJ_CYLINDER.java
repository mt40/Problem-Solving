package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_CYLINDER {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int a;
        while((a = in.i()) > 0) {
            int b = in.i();
            double pi = Math.PI;
            double r1 = a/pi/2;
            double h1 = b - 2*r1;
            double r2 = Math.min(a/2.0, b/(pi+0)/2);
            double h2 = a;

            double v1 = vol(r1, h1), v2 = vol(r2, h2);
            out.printf("%.3f\n", Math.max(v1, v2));
        }
    }

    double vol(double r, double h) {
        return Math.PI*r*r*h;
    }
}