package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_LQDCANDY {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        long n = in.l();
        long p = nextPower2(n);
        int t = 0;
        if(p != n)
            t = times(p, n);
        out.printf("%d %d\n", p, t);
    }

    int times(long n, long d) {
        if((d & 1) > 0) return log2(n);
        long sum = 0;
        int cnt = 0;
        while((n >>= 1) > 0 && sum != d) {
            sum += n;
            cnt++;
        }
        return cnt;
    }

    int log2(long n) {
        int rs = 0;
        while((n >>= 1) > 0) rs++;
        return rs;
    }

    long nextPower2(long n) {
        if((n & (n - 1)) == 0) return n;
        long rs = 2;
        while((n >>= 1) > 0)
            rs <<= 1;
        return rs;
    }
}