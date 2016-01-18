package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_UPDATEIT {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), u = in.i();
        int []cache = new int[n + 1];
        for(int i = 0; i < u; ++i) {
            int l = in.i(), r = in.i(), v = in.i();
            cache[l] += v;
            cache[r + 1] -= v;
        }

        int []a = new int[n];
        int tmp = 0;
        for(int i = 0; i < n; ++i) {
            tmp += cache[i];
            a[i] = tmp;
        }

        int q = in.i();
        while(q-- > 0) {
            int i = in.i();
            out.println(a[i]);
        }
    }
}