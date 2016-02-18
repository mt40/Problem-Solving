package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.math.BigInteger;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_GEOPROB {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        String bs = in.s(), cs = in.s(), ds = in.s();
        BigInteger b = new BigInteger(bs);
        BigInteger c = new BigInteger(cs);
        BigInteger d = new BigInteger(ds);

        BigInteger ans = c.subtract(b).add(c.subtract(d));
        out.println("" + ans);
    }
}