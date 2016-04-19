package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

/**
 * As the name says, instead of Exponent by squaring
 * which is treating the exp as 2^x. We now treat it
 * as 3^y.
 * To understand this, try to understand Exp by squaring
 * first.
 */
public class ExponentByCubing {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int base = in.i(), e = in.i();

        long rs = pow(base, e);
        out.println(rs);
    }

    long pow(long base, int e) {
        long rs = 1;
        while(e > 0) {
            if(e % 3 == 1)
                rs *= base;
            else if(e % 3 == 2)
                rs *= base * base;
            base *= base * base;
            e /= 3;
        }
        return rs;
    }
}