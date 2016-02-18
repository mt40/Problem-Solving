package workspace;

import helperClasses.FastScanner;
import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import helperClasses.ShortScanner;
import helperClasses.Util;

public class SPOJ_ABSP1 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []a = in.arr(n);

        long []sum = new long[n];
        for(int i = 0; i < n; ++i) sum[i] = (i > 0) ? a[i] + sum[i - 1] : a[i];

        long ans = 0;
        for(int i = 1; i < n; ++i) {
            ans += 1L * i * a[i] - sum[i - 1];
        }

        out.println(ans);
    }
}
