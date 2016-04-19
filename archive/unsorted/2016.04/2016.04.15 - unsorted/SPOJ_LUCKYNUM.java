package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.math.BigInteger;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_LUCKYNUM {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();

        bn = BigInteger.valueOf(n);

        String ans = calc(n);
        out.println(ans);
    }

    BigInteger bn, zero = BigInteger.ZERO;

    String calc(int n) {
        for(int len = length(n); len <= 100; ++len) {
            StringBuilder sb = createSixes(len);
            for(int j = -1; j < len; ++j) {
                if(j >= 0)
                    sb.setCharAt(j, '8');
                String num = sb.toString();
                if(check(num)) {
                    return num;
                }
            }
        }
        return "-1";
    }

    boolean check(String num) {
        BigInteger bi = new BigInteger(num);
        if(bi.compareTo(bn) < 0)
            return false;
        return bi.mod(bn).equals(zero);
    }

    StringBuilder createSixes(int len) {
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; ++i)
            sb.append('6');
        return sb;
    }

    int length(int x) {
        if(x == 0) return 0; // only works for x > 0
        return 1 + length(x / 10);
    }
}