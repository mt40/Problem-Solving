package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_UCV2013A {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n;
        while((n = in.i()) > 0) {
            int l = in.i();
            int m = 1000 * 1000 * 1000 + 7;
            long ans = n, prev = n;
            for (int i = 1; i < l; ++i) {
                ans = (ans + (prev * n) % m) % m;
                prev = (prev * n) % m;
            }

            out.println(ans);
        }
    }
}