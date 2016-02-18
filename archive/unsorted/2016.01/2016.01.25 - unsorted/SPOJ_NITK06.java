package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_NITK06 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []a = in.arr(n);

        int []b = new int[n];
        for(int i = 0; i < n - 1; ++i) {
            int d = Math.min(a[i] - b[i], a[i + 1] - b[i + 1]);
            b[i] += d;
            b[i + 1] += d;
        }

        boolean ok = true;
        for(int i = 0; i < n; ++i)
            if(a[i] != b[i]) ok = false;

        out.println(ok ? "YES" : "NO");
    }
}