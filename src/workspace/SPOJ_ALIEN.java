package workspace;

import helperClasses.FastScanner;
import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.ShortScanner;
import helperClasses.Util;

public class SPOJ_ALIEN {
    long inf = Long.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), lim = in.i();
        int []a = in.arr(n);

        int len = 0, l = 0, r = 0;
        long sum = 0, ans = inf;
        for(; r < n; ++r) {
            sum += a[r];
            while(l <= r && sum > lim) {
                sum -= a[l];
                l++;
            }
            if(sum <= lim && r - l + 1 >= len) {
                if(r - l + 1 == len)
                    ans = Math.min(sum, ans);
                else
                    ans = sum;
                len = r - l + 1;
            }
        }
        if(ans == inf) ans = 0;
        out.printf("%d %d\n", ans, len);
    }
}
