package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_CSQUARE {
    int inf = Integer.MAX_VALUE;
    int mod;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int a = in.i();
        char []b = in.c();
        mod = in.i();

        int n = b.length;
        long rs = 1;
        for(int i = 0, e = n - 1; i < n; ++i, --e) {
            int bi = b[i] - '0';
            if(bi == 0) continue;
            long val = pow3(a, e);
            if(bi == 2)
                val = mul(val, val);
            rs = mul(rs, val);
        }

        out.println(rs);
    }

    long pow3(long base, int e) {
        while(e > 0) {
            base = mul(base, base, base);
            e--;
        }
        return base;
    }

    long mul(long a, long b) {
        return (a * b) % mod;
    }

    long mul(long a, long b, long c) {
        return (((a * b) % mod) * c) % mod;
    }
}