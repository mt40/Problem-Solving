package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_NOCHANGE {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        while(true) {
            int x;
            try { x = in.i(); }
            catch(Exception e) { return;}
            int k = in.i();
            int []coins = in.arr(k);

            int []sum = new int[k];
            for(int i = 0; i < k; ++i)
                sum[i] = (i == 0) ? coins[i] : sum[i - 1] + coins[i];

            boolean []vst = new boolean[x + 1];
            for(int i = 0; i * coins[0] <= x; ++i)
                vst[i * coins[0]] = true;
            for(int i = 1; i < k; ++i) {
                for (int j = 0; j <= x; ++j) {
                    if (vst[j] && j + sum[i] <= x)
                        vst[j + sum[i]] = true;
                }
            }

            out.println(vst[x] ? "YES" : "NO");
        }
    }

    int getMin(int []a) {
        int rs = a[0];
        for(int ai : a) rs = Math.min(ai, rs);
        return rs;
    }
}