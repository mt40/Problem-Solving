package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.math.BigInteger;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_ATOMS {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        long n = in.l(), k = in.l(), m = in.l();

        // n*(k^t) <= m -> k^t <= m/n -> t <= log_k(m/n)
        BigInteger bm = BigInteger.valueOf(m);
        BigInteger bk = BigInteger.valueOf(k);
        BigInteger x = BigInteger.valueOf(n);
        int ans = 0;
        while(x.compareTo(bm) <= 0) {
            x = x.multiply(bk);
            ans++;
        }

        out.println(Math.max(0,ans-1));
    }

    float log(double d, double k) {
        return (float)(Math.log(d) / Math.log(k));
    }
}