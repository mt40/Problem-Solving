package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.math.BigInteger;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_PUCMM025 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        while(true) {
            String s;
            try { s = in.s(); }
            catch(Exception e) {return;}
            char []a = s.toCharArray();

            boolean []ok = new boolean[10], vst = new boolean[10];
            ok[1] = vst[1] = vst[0] = true;
            BigInteger bi = new BigInteger(s);
            int ans = 0;
            for(int i = 0; i < a.length; ++i) {
                int d = a[i] - '0';

                if(!vst[d]) {
                    ok[d] = bi.mod(BigInteger.valueOf(d)) == BigInteger.ZERO;
                    vst[d] = true;
                }
                if(ok[d]) ans++;
            }

            out.println(ans);
        }
    }
}