package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class HKR_SansaAndXOR {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []a = in.arr(n);

        int []f = new int[n];
        for(int i = 0; i < n; ++i)
            f[i] = (n - i) * (i + 1);

        int ans = 0;
        for(int i = 0; i < n; ++i)
            ans ^= ((f[i] & 1) > 0) ? a[i] : 0;

        out.println(ans);
    }
}