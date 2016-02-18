package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_LCMSUM {
    int inf = Integer.MAX_VALUE;

    /**
     * Apparently, solution of this problem involves deeply in
     * number theory which is not really worth the time to look
     * into at the time I was solving this.
     * Maybe when you look back, you can solve it.
     */
    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        long ans = 0;
        for(int i = 1; i <= n; ++i)
            ans += lcm(i, n);

        out.println(ans);
    }

    int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    int gcd(int a, int b) {
        if(a == 0) return b;
        return gcd(b % a, a);
    }
}