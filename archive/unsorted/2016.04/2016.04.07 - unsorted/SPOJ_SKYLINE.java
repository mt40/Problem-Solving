package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_SKYLINE {
    int inf = Integer.MAX_VALUE;
    final int mod = 1000 * 1000;
    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);

        int lim = 1000;
        long []cat = new long[lim + 1]; // Catalan number
        cat[0] = cat[1] = 1;
        for(int i = 2; i <= lim; ++i) {
            for(int j = 0; j < i; ++j)
                cat[i] = (cat[i] + cat[j] * cat[i - 1 - j]) % mod;
        }

        int n;
        while((n = in.i()) > 0) {
            long ans = cat[n];

            out.println(ans);
        }
    }
}