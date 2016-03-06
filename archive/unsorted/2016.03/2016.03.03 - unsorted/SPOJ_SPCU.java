package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_SPCU {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []a = in.arr(n);

        boolean ans = true;
        for(int i = 0; i < n; ++i)
            if(a[i] > i) ans = false;

        out.println(ans ? "YES" : "NO");
    }
}