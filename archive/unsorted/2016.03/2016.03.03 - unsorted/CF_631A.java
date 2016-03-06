package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_631A {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []a = in.arr(n), b = in.arr(n);

        long ans = 0;
        for(int i = 0; i < n; ++i) {
            int orA = 0, orB = 0;
            for(int j = i; j < n; ++j) {
                orA |= a[j];
                orB |= b[j];
                ans = Math.max(1L*orA + orB, ans);
            }
        }

        out.println(ans);
    }
}