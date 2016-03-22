package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.math.BigInteger;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_M00PAIR {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);

        build();
        while(true) {
            int n;
            try{n = in.i();} catch(Exception e) {return;}

            out.println(dp[n]);
        }
    }

    BigInteger []dp, cul;
    void build() {
        dp = new BigInteger[1000];
        cul = new BigInteger[1000];
        dp[1] = BigInteger.ZERO;
        dp[2] = BigInteger.ONE;
        cul[2] = BigInteger.ONE;
        for(int i = 3; i < 1000; ++i) {
            dp[i] = cul[i-1];
            if((i & 1) == 0)
                dp[i] = dp[i].add(BigInteger.ONE);

            cul[i] = cul[i-1].add(dp[i]);
        }
    }
}