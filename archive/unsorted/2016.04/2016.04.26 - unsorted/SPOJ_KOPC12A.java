package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_KOPC12A {
    int inf = Integer.MAX_VALUE;
    int []cul;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int[] height = in.arr(n);
        int[] cost = in.arr(n);

        long ans = cost(height, cost, calc(height, cost, n));
        out.println(ans);
    }

    // Ternary Search
    long calc(int []height, int []cost, int n) {
        int maxHeight = Util.max(height);

        long low = 0, hi = maxHeight;
        while(low <= hi) {
            long m1 = low + (hi - low) / 3;
            long m2 = hi - (hi - low) / 3;
            long y1 = cost(height, cost, m1);
            long y2 = cost(height, cost, m2);
            if(m1 == m2)
                return (low + hi) >>> 1;
            else if(y1 < y2)
                hi = m2 - 1;
            else
                low = m1 + 1;
        }
        return hi;
    }

    long cost(int []height, int []cost, long h) {
        long rs = 0;
        for(int i = 0; i < height.length; ++i) {
            rs += cost[i] * Math.abs(h - height[i]);
        }
        return rs;
    }
}