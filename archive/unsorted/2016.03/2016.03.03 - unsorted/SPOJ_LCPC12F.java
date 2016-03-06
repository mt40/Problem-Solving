package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_LCPC12F {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int x = in.i(), n = in.i();
        int []a = in.arr(n);

        int []f = new int[1001];
        long ans = 0;
        for(int ai : a) {
            if(x - ai >= 0 && x - ai <= 1000)
                ans += f[x - ai];
            f[ai]++;
        }

        out.printf("%d. %d\n", testNumber, ans);
    }
}