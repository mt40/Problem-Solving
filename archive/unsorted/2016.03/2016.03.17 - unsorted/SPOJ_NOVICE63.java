package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_NOVICE63 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        long n = in.l();

        long ans = 0;
        if(n == 2)
            ans = 1;
        else if(n > 2) {
            long tmp = 2;
            for (int k = 2; tmp < n; k += 2, tmp <<= 2) {
                ans += comb(k - 1, k / 2 - 1);
            }
        }

        out.println(ans);
    }

    long comb(long n, long k) {
        if(k == n || k == 0) return 1;
        return n * comb(n-1, k-1) / k;
    }
}