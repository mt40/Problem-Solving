package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.math.BigInteger;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_YAPP {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int p = Math.max(n - 1, 0);
        int m = 1000*1000*1000+7;
//        out.println(BigInteger.valueOf(2).modPow(
//                BigInteger.valueOf(p), BigInteger.valueOf(m)));
        out.println(modPow(2, p, m));
    }

    long modPow(long base, int e, int m) {
        long rs = 1;
        while(e > 0) {
            if((e & 1) > 0) {
                rs = (rs * (base % m)) % m;
            }
            e >>= 1;
            base = (base * base) % m;
        }
        return rs;
    }
}