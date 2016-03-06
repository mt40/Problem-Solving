package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_FACTMUL {
    int inf = Integer.MAX_VALUE;
    final long m = 109546051211L;
    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();

        long rs = 1;
        long cur = 1;
        if(n >= 600000) rs = 0;
        for(int i = 2; i <= n; ++i) {
            cur = mulmod(cur,i,m) % m;
            rs = mulmod(rs,cur,m) % m;
            if(rs == 0) break;
        }

        out.println(rs);
    }

    long mulmod(long a, long b, long m) {
        long x = 0, y = a % m;
        while (b > 0) {
            if ((b & 1) > 0)
                x = (x + y) % m;

            y = (y << 1) % m;
            b >>= 1;
        }
        return x % m;
    }
}