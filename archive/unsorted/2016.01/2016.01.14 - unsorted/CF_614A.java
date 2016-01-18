package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.math.BigInteger;

import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_614A {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        long l = in.l(), r = in.l(), k = in.l();
        int p = 0;
        boolean ok = false;
        BigInteger bk = BigInteger.valueOf(k);
        BigInteger bl = BigInteger.valueOf(l), br = BigInteger.valueOf(r);
        while(true) {
            BigInteger rs = bk.pow(p);
            if(bl.compareTo(rs) <= 0
                    && rs.compareTo(br) <= 0) {
                out.print(rs + " ");
                ok = true;
            }
            else if (rs.compareTo(br) > 0) break;
            p++;
        }
        if(!ok) out.print(-1);
        out.println();
    }
}