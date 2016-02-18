package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_JOKER1 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int t = in.i();
        while(t-- > 0) {
            int n = in.i();
            int[] a = in.arr(n);

            Arrays.sort(a);
            long ans = 1, mod = 1000 * 1000 * 1000 + 7;
            for (int i = 0; i < n; ++i) {
                int x = a[i] - i;
                x = Math.max(0, x);
                ans = (ans * x) % mod;
            }

            out.println(ans);
        }
        out.println("KILL BATMAN");
    }
}