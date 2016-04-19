package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_622A {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        long n = in.l();

        long bound = sqrt(n * 2);
        long left = bound * (bound + 1) / 2;
        while(left >= n) {
            bound--;
            left = bound * (bound + 1) / 2;
        }
        long idx = n - left;
        out.println(idx);
    }

    long sqrt(long x) {
        long rs = (long)Math.sqrt(x);
        while(rs * rs < x)
            rs++;
        while(rs * rs > x)
            rs--;
        return rs;
    }
}