package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_UCV2013J {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n;
        while((n = in.i()) > 0) {
            int[] v = in.arr(n);

            int ans = 0;
            int i = n - 1;
            while (2 * i + 1 >= n) {
                ans += v[i];
                i--;
            }

            out.println(ans);
        }
    }
}