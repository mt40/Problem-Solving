package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_TAP2013G {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []a = in.arr(n);
        int []b = in.arr(n);

        Arrays.sort(a);
        Arrays.sort(b);
        int ans = 0;
        int i = n - 1, j = n - 1;
        while(i >= 0 && j >= 0) {
            if(a[i] < b[j]) {
                ans++;
                j--;
            }
            i--;
        }

        out.println(ans);
    }
}