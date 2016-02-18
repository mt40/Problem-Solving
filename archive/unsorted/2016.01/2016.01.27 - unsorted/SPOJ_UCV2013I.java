package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_UCV2013I {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int r;
        while((r = in.i()) > 0) {
            int n = in.i();
            double R = r / Math.sin(Math.PI / n / 2);
            out.printf("%.2f\n", R);
        }
    }
}