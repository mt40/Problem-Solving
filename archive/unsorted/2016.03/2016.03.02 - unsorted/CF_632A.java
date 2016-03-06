package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_632A {
    long inf = Long.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), p = in.i();
        boolean []a = new boolean[n];
        for(int i = 0; i < n; ++i)
            a[i] = !in.s().equals("half");

        long apples = 0, ans = 0;
        for(int i = n - 1; i >= 0; --i) {
            if(a[i]) // half plus
                apples = apples*2 + 1;
            else
                apples *= 2;
            ans += apples * p / 2;
        }

        out.println(ans);
    }
}