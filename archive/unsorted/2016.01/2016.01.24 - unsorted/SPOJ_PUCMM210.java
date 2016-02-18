package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_PUCMM210 {
    int inf = Integer.MAX_VALUE;

    static int lim = 1000 * 1000;
    static int m = 1000*1000*1000+3;
    static long []f, sum;
    static {
        f = new long[lim + 1];
        f[1] = 1;
        for(int i = 2; i < f.length; ++i)
            f[i] = f[i - 1] + cube(i, m);
        sum = new long[lim + 1];
        for(int i = 1; i < sum.length; ++i)
            sum[i] = (sum[i-1] + f[i]) % m;
    }

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);

        int t = in.i();
        while(t-- > 0) {
            int n = in.i();
            out.println(sum[n]);
        }
    }

    static long cube(int x, int m) {
        return (((1L*x*x) % m) * x) % m;
    }
}