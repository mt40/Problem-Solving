package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_FACVSPOW {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int t = in.i();
        init();

        while(t-- > 0) {
            int a = in.i();
            int ans = cal(a);
            out.println(ans);
        }
    }

    double []fact;

    void init() {
        fact = new double[3000001];
        for(int i = 1; i <= 3000000; ++i)
            fact[i] = loga(2, i) + fact[i-1];
    }

    int cal(int a) {
        int low = 0, hi = 3000000, rs = hi;
        while(low <= hi) {
            int mid = low + (hi - low) / 2;
            if(fact[mid]/loga(2,a) > mid) {
                rs = mid;
                hi = mid - 1;
            }
            else low = mid + 1;
        }
        return rs;
    }

    double loga(int a, long n) {
        if(n == 0) return 0;
        return Math.log(n) / Math.log(a);
    }
}