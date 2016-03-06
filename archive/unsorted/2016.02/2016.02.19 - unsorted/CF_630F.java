package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_630F {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();

        long rs = 0;
        for(int i = 5; i <= 7; ++i) {
            rs += comb(n, i);
        }

        out.println(rs);
    }

    long comb(int n, int k) {
        long rs = 1;
        for(int i = 1; i <= k; ++i)
            rs *= (n-i+1.0)/i;
        return rs;
    }
}