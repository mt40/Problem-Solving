package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_PROSCORE {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), p = in.i();

        int ans = 7; // 111
        int mask = 0, all = (1 << p) - 1;
        for(int i = 0; i < n; ++i) {
            String s = in.sl().replace(" ", "");
            int x = Integer.valueOf(s, 2);
            if(x == 0)
                ans &= 5; // 101
            if(x == all)
                ans &= 6; // 110
            mask |= x;
        }
        if(mask < all) ans &= 3; // 011

        out.printf("Case %d: %d\n", testNumber, ans);
    }
}