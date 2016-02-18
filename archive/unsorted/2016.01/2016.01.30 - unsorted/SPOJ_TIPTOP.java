package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_TIPTOP {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        long n = in.l();
        boolean isPerfectSqr = check(n);

        out.printf("Case %d: ", testNumber);
        out.println(isPerfectSqr ? "Yes" : "No");
    }

    // Fast perfect square check
    boolean check(long n) {
        long h = n & 0xf;

        if(h == 0 || h == 1 || h == 4 || h == 9) {
            long sqrt = goodSqrt(n);
            return sqrt * sqrt == n;
        }
        return false;
    }

    long goodSqrt(long n) {
        long sqrt = (long)Math.sqrt(n);
        while(Long.compareUnsigned(sqrt * sqrt, n) < 0) sqrt++;
        while(Long.compareUnsigned(sqrt * sqrt, n) > 0) sqrt--;
        return sqrt;
    }
}