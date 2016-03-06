package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_HAYBALE {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), k = in.i();
        int []a = new int[n];
        int []cache = new int[n+1];
        for(int i = 0; i < k; ++i) {
            int l = in.i()-1, r = in.i()-1;
            cache[l]++;
            cache[r+1]--;
        }

        int t = 0;
        for(int i = 0; i < n; ++i) {
            t += cache[i];
            a[i] = t;
        }
        sort(a);
        out.println(a[n/2]);
    }

    void sort(int []a) {
        int mx = Util.max(a);
        int []f = new int[mx + 1];
        for(int ai : a)
            f[ai]++;

        for(int i = 0, j = 0; i <= mx; ++i) {
            while(f[i] > 0) {
                a[j++] = i;
                f[i]--;
            }
        }
    }
}