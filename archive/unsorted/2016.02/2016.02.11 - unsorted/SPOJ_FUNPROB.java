package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_FUNPROB {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        while(true) {
            int n = in.i(), m = in.i();
            if(n == 0 && m == 0) return;

            double ans;
            if(n > m)
                ans = 0;
            else
                ans = (1.0*m - n + 1) / (1 + m);
            out.printf("%.6f\n", ans);
        }
    }
}