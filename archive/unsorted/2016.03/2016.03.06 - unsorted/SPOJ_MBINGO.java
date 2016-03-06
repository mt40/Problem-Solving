package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_MBINGO {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n;
        while((n = in.i()) > 0) {
            int m = in.i();
            int []a = in.arr(m);

            boolean []check = new boolean[n + 1];
            for(int i = 0; i < m; ++i) {
                for(int j = 0; j < m; ++j) {
                    if(i == j) continue;
                    check[Math.abs(a[i] - a[j])] = true;
                }
            }

            boolean ok = true;
            for(int i = 1; i <= n; ++i)
                ok &= check[i];

            out.println(ok ? 'Y' : 'N');
        }
    }
}