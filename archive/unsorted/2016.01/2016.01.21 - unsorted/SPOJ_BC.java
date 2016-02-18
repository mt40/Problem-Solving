package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_BC {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), m = in.i(), k = in.i();

        long hand = ((n - 1L) * m + (m - 1)) * k + (k - 1);
        int knife = cal(n) + cal(m) + cal(k);
        out.printf("Case #%d: %d %d\n", testNumber, hand, knife);
        out.println(cal(9));
    }

    int cal(double x) {
        int l = 0;
        while (x > 1) {
            x /= 2;
            l++;
        }
        return l;
    }
}