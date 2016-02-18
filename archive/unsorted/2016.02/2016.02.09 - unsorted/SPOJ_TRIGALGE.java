package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_TRIGALGE {
    int inf = Integer.MAX_VALUE;
    double eps = 1e-8;
    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int a = in.i(), b = in.i(), c = in.i();

        long one = 1000*1000*1000;
        double low = -one, hi = one, x;
        // bisection method. Also, Newton's approximation is ok.
        while(true) {
            x = low + (hi - low) / 2;
            if(Math.abs(eval(a, b, c, x)) <= eps)
                break;
            boolean sign_low = eval(a, b, c, low) > 0;
            boolean sign_x = eval(a, b, c, x) > 0;
            if(sign_low == sign_x)
                low = x;
            else
                hi = x;
        }

        out.printf("%.6f\n", x);
    }

    double eval(int a, int b, int c, double x) {
        return a*x + b*Math.sin(x) - c;
    }
}