package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.math.BigInteger;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_FAST2 {
    int inf = Integer.MAX_VALUE;
    static final BigInteger mod = new BigInteger("1298074214633706835075030044377087");
    static final BigInteger one = BigInteger.ONE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();

        BigInteger two = BigInteger.valueOf(2);
        BigInteger ans = two.pow(n + 1).subtract(one);
        ans = ans.mod(mod);

        out.println(ans);
    }
}