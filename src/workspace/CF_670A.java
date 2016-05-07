package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_670A {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();

        int weeks = n / 7;
        int max = 2 * weeks, min = 2 * weeks;
        int remain = n - (weeks * 7);
        max += Math.min(2, remain);
        if(remain > 5)
            min++;

        out.printf("%d %d\n", min, max);
    }
}