package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_630G {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        long ans = comb(5+n-1, 5) * comb(3+n-1, 3);
        out.println(Long.toUnsignedString(ans));
    }

    long comb(int n, int k) {
        if(k == 0 || k == n) return 1;
        return (n * comb(n-1,k-1)) / k;
    }
}