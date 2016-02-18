package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_AFS {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int t = in.i();
        while(t-- > 0) {
            int n = in.i();
            long ans = a[n];
            out.println(ans);
        }
    }

    final int lim = 1000*1000;
    long []f = new long[lim + 1];
    long []a = new long[lim + 1];
    {
        Arrays.fill(f, 1);
        sieve();
        for(int i = 2; i <= lim; ++i)
            a[i] = a[i - 1] + f[i];
    }
    void sieve() {
        for(int i = 2; (i << 1) <= lim; ++i) {
            for(int j = 2*i; j <= lim; j += i) {
                f[j] += i;
            }
        }
    }
}