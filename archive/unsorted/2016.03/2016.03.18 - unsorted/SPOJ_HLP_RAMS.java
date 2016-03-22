package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_HLP_RAMS {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        long n = in.l();

        long one = Long.bitCount(n);
        long odd = 1 << one;
        long even = n + 1 - odd;
        out.printf("%d %d\n", even, odd);
    }
}