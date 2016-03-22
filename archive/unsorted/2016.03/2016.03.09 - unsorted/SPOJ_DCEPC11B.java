package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_DCEPC11B {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        long n = in.l(), p = in.l();

        if(n >= p)
            out.println(0);
        else {
            long ans = p - 1;
            for(long i = n + 1; i <= p - 1; ++i)
                ans = (ans * modPow(i, p - 2, p)) % p;
            out.println(ans);
        }
    }

    long modPow(long base, long e, long mod) {
        long rs = 1;
        while(e > 0) {
            if((e & 1) > 0)
                rs = (rs * base) % mod;
            base = (base * base) % mod;
            e >>= 1;
        }
        return rs;
    }
}