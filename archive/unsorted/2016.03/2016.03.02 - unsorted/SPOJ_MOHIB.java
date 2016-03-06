package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_MOHIB {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int x = in.i(), avg = in.i();
        int n = avg - x;
        long sum = (avg + 1) * n;
        long max = sum - (n - 1)*n/2;
        out.println(max);
    }
}