package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class HKR_SIMPLE_ONE {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int p = in.i(), q = in.i(), n = in.i();
        one = new Pair(p, q);

    }

    Pair one;

    Pair cal(int n, int p, int q) {
        if(n == 1) return new Pair(p, q);
        Pair x = cal(n / 2, p, q);
        Pair rs = add(x, x);
        if(n % 2 > 0)
            rs = add(rs, one);
        return rs;
    }

    Pair add(Pair a, Pair b) {
        return new Pair(a.p*b.q + a.q*b.p, a.q*b.q + a.p*b.p);
    }

    class Pair {
        long p, q;

        public Pair(long p, long q) {
            this.p = p;
            this.q = q;
        }
    }
}