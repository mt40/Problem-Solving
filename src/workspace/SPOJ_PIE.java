package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_PIE {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), f = in.i();
        int []r = in.arr(n);

        double pi = Math.acos(-1);

        double []s = new double[n];
        for(int i = 0; i < n; ++i)
            s[i] = pi * r[i] * r[i];

        double low = pi, hi = inf;
        while(low < hi && Math.abs(hi - low) > 1e-6) {
            double m = (low + hi) / 2;
            int cnt = 0;
            for(int i = 0; i < n; ++i)
                cnt += (int)(s[i] / m);
            if(cnt >= f) low = m;
            else hi = m;
        }

        out.printf("%.4f\n", low);
    }
}