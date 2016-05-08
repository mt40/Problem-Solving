package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_653A {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []a = in.arr(n);

        a = Util.unique(a);
        Arrays.sort(a);
        n = a.length;

        for(int i = 0; i < n - 2; ++i) {
            int x = a[i], y = a[i + 1], z = a[i + 2];
            if(x == y || x == z || y == z)
                continue;
            if(z - x > 2) continue;
            out.println("YES");
            return;
        }
        out.println("NO");
    }
}