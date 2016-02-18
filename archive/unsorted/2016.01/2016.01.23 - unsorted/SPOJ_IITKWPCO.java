package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_IITKWPCO {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []a = in.arr(n);

        int lim = findMax(a);
        int []f = new int[lim + 1];
        for(int ai : a) f[ai]++;

        int ans = 0;
        for(int i = 1; i <= lim; ++i) {
            while(f[i] > 0 && 2L * i <= lim && f[2 * i] > 0) {
                ans++;
                f[i]--;
                f[2 * i]--;
            }
        }

        out.println(ans);
    }

    int findMax(int []a) {
        int rs = a[0];
        for(int ai : a) rs = Math.max(ai, rs);
        return rs;
    }
}