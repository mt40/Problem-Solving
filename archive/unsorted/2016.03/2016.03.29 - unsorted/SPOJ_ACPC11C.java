package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_ACPC11C {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []corridors = in.arr(n);

        long sum = 0;
        for(int len : corridors)
            sum += len;

        long ans = sum - corridors[n - 1];
        long right = 0, left = 0;
        for(int i = 0; i < n - 1; ++i) {
            right += corridors[i];
            ans = Math.min(right + sum - corridors[i + 1], ans);
        }
        ans = Math.min(sum - corridors[0], ans);
        for(int i = n - 1; i > 0; --i) {
            left += corridors[i];
            ans = Math.min(left + sum - corridors[i - 1], ans);
        }

        out.println(ans);
    }
}