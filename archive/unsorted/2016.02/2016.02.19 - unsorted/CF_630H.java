package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_630H {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        long ans = sqr(comb(n,5))*120;
        out.println(ans);
    }

    long sqr(long x) {
        return x*x;
    }

    long comb(int n, int k) {
        if(k == 0 || k == n) return 1;
        return (n * comb(n-1,k-1)) / k;
    }
}