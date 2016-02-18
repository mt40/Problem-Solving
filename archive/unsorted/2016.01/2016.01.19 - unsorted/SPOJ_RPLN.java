package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_RPLN {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), q = in.i();
        int []a = in.arr(n);

        int log = (int) (Math.log(n) / Math.log(2)) + 1;
        sp = new int[n][log];
        for (int i = 0; i < n; ++i)
            sp[i][0] = a[i];
        for (int j = 1; j < log; ++j) {
            for (int i = 0; i + (1 << j - 1) < n; ++i) {
                sp[i][j] = Math.min(sp[i][j - 1], sp[i + (1 << j - 1)][j - 1]);
            }
        }

        out.printf("Scenario #%d:\n", testNumber);
        while (q-- > 0) {
            int l = in.i() - 1, r = in.i() - 1;
            int ans = query(l, r);
            out.println(ans);
        }
    }

    int[][] sp;

    int query(int l, int r) {
        if (l > r) return inf;
        int log = (int) (Math.log(r - l + 1) / Math.log(2));
        return Math.min(sp[l][log], query(l + (1 << log), r));
    }
}