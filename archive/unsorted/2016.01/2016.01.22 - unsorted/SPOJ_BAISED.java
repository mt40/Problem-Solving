package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_BAISED {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        long []a = new long[n];
        for(int i = 0; i < n; ++i) {
            in.s();
            a[i] = in.l();
        }

        Arrays.sort(a);
        long ans = 0;
        for(int i = 0; i < n; ++i)
            ans += Math.abs(a[i] - (i + 1));

        out.println(ans);
    }
}