package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_652B {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []a = in.arr(n);

        Arrays.sort(a);

        int l = 0, r = n - 1;
        for(int i = 1; i <= n; ++i) {
            if(i % 2 > 0)
                out.print(a[l++] + " ");
            else
                out.print(a[r--] + " ");
        }
        out.println();
    }
}