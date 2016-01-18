package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_APS {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int lim = 1000 * 1000 * 10;
        int []b = new int[lim+1];
        cal(lim, b);
        long []a = new long[lim+1];
        a[0] = a[1] = 0;
        for(int i = 2; i <= lim; ++i)
            a[i] = a[i - 1] + b[i];

        int t = in.i();
        while(t-- > 0) {
            int n = in.i();
            out.println(a[n]);
        }
    }

    void cal(int n, int[] b) {
        boolean[] sieve = new boolean[n + 1];
        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;
        for (int i = 2; 1L * i * i <= n; ++i) {
            if (sieve[i]) {
                b[i] = i;
                for (int j = i * i; j <= n; j += i) {
                    sieve[j] = false;
                    if (b[j] == 0) b[j] = i;
                }
            }
        }
        // IMPORTANT!
        for(int i = 2; i <= n; ++i)
            if(b[i] == 0)
                b[i] = i;
    }
}