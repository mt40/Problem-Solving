package workspace;

import java.math.BigInteger;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_592C {
    BigInteger zero = BigInteger.ZERO;
    BigInteger one = BigInteger.ONE;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        BigInteger t = in.nextBigInteger();
        BigInteger a = in.nextBigInteger();
        BigInteger b = in.nextBigInteger();
        BigInteger min = (a.compareTo(b) <= 0) ? a : b;

        BigInteger lcm_ab = lcm(a, b);
        BigInteger smaller = min.subtract(one);
        BigInteger muls = t.divide(lcm_ab);
        BigInteger extra = muls.subtract(one).multiply(smaller);
        BigInteger last = t.subtract(muls.multiply(lcm_ab));
        if(last.compareTo(smaller) < 0)
            extra = extra.add(last);
        else
            extra = extra.add(smaller);
        BigInteger ans = smaller.add(muls).add(extra);

        BigInteger d = gcd(ans, t);
        out.printf("%d/%d", ans.divide(d), t.divide(d));
    }

    BigInteger gcd(BigInteger a, BigInteger b) {
        while (!b.equals(BigInteger.ZERO)) {
            BigInteger t = b;
            b = a.mod(b);
            a = t;
        }
        return a;
    }

    BigInteger lcm(BigInteger a, BigInteger b) {
        return a.multiply(b).divide(gcd(a, b));
    }
}
