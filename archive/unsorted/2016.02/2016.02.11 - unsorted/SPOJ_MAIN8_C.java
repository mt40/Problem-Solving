package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_MAIN8_C {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        long k = in.i();
        long []a = in.arrl(n);

        long max = Util.max(a);
        long low = 1, hi = max, ans = 0;
        while(low <= hi) {
            long m = low + (hi - low) / 2;
            if(cal(a, m) >= k) {
                low = m + 1;
                ans = m;
            }
            else hi = m - 1;
        }

        out.println(ans);
    }

    long cal(long []a, long m) {
        long cnt = 0;
        for(long ai : a)
            cnt += ai / m;
        return cnt;
    }
}