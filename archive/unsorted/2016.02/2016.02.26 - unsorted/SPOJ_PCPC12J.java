package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_PCPC12J {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int[] a = in.arr(n);

        int []f = new int[101];
        for(int ai : a)
            f[ai]++;


        int max = -1;
        for(int i = 1; i < f.length; ++i)
            if(f[i] > 0 && f[i] % i == 0)
                max = Math.max(f[i], max);

        int ans = inf;
        for(int i = 1; i < f.length; ++i) {
            if(f[i] == max && f[i] % i == 0)
                ans = Math.min(i, ans);
        }

        out.println((ans == inf) ? -1 : ans);
    }
}