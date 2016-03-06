package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class CC_MAXISUM {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), k = in.i();
        int []a = in.arr(n);
        int []b = in.arr(n);

        for(int i = 0; i < n; ++i) {
            if(b[i] < 0) {
                a[i] = -a[i];
                b[i] = -b[i];
            }
        }

        long sum = 0;
        for(int i = 0; i < n; ++i)
            sum += a[i] * b[i];

        long ans = sum;
        for(int i = 0; i < n; ++i) {
            long newSum = sum + 1L* b[i] * k;
            ans = Math.max(newSum, ans);
        }

        out.println(ans);
    }
}