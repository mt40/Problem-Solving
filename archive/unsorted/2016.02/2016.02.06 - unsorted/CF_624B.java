package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_624B {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []a = in.arr(n);

        Arrays.sort(a);

        int prev = inf;
        long ans = 0;
        for(int i = n - 1; i >= 0; --i) {
            if(a[i] < prev) {
                ans += a[i];
                prev = a[i];
            }
            else {
                ans += Math.max(0, prev - 1);
                prev--;
            }
        }

        out.println(ans);
    }
}