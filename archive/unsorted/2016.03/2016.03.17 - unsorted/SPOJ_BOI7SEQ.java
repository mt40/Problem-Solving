package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_BOI7SEQ {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []a = in.arr(n);

        long ans = 0;
        for(int i = 0; i < n; ++i) {
            if(i - 1 >= 0 && a[i-1] <= a[i]) ans += a[i];
            if(i + 1 < n && a[i] > a[i + 1]) ans += a[i];
        }

        out.println(ans);
    }
}