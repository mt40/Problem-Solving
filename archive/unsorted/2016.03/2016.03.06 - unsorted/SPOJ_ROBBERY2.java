package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_ROBBERY2 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        long n = in.l(), k = in.l();

        long t = bSearch(n, k);
        long left = n - f(k, t);
        for(int i = 1; i <= k; ++i) {
            long coins = i * t + csc(t - 1) * k;
            long last = k*t + i;
            coins += Math.min(last, left);
            left = Math.max(left - last, 0);

            out.print(Long.toUnsignedString(coins) + " ");
        }
        out.println();
    }

    long bSearch(long n, long k) {
        long low = 0, hi = n/k, rs = low;
        while(low <= hi) {
            long m = low + (hi - low) / 2;
            long coins = f(k, m);
            if(Long.compareUnsigned(coins, n) <= 0) {
                rs = m;
                low = m + 1;
            }
            else hi = m - 1;
        }
        return rs;
    }

    long f(long k, long x) {
        return x * csc(k) + k*k*csc(x-1);
    }

    long csc(long n) {
        if(n <= 0) return 0;
        return Long.divideUnsigned(n*(n+1),2);
    }
}