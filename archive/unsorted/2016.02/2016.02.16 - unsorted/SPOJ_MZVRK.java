package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_MZVRK {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        long a = in.l(), b = in.l();

        long r = cal(b);
        long l = cal(a - 1);
        long ans = r - l;
        out.println(ans);
    }

    long cal(long n) {
        long rs = 0;
        for(long i = 1; i <= n; i <<= 1) {
            long step = i << 1;
            long t = n / step;
            long s = n - t*step;
            if(s < i) t--;
            rs += i * (t+1);
        }
        return rs;
    }
}