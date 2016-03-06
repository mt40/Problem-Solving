package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_632B {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        long []str = in.arrl(n);
        char []a = in.c();

        long [][]pre = new long[2][n];
        for(int i = 0; i < n; ++i) {
            if(i > 0) {
                pre[0][i] = pre[0][i-1];
                pre[1][i] = pre[1][i-1];
            }
            pre[id(a[i])][i] = (i > 0) ? pre[id(a[i])][i - 1] + str[i] : str[i];
        }

        long total = sum(pre[1], 0, n - 1), ans = total;
        for(int i = 0; i < n; ++i) {
            long bob = sum(pre[0], 0, i); // alice to bob
            long alice = sum(pre[1], 0, i); // bob to alice
            ans = Math.max(total - alice + bob, ans);
        }
        for(int i = n - 1; i >= 0; --i) {
            long bob = sum(pre[0], i, n - 1); // alice to bob
            long alice = sum(pre[1], i, n - 1); // bob to alice
            ans = Math.max(total - alice + bob, ans);
        }

        out.println(ans);
    }

    long sum(long []cul, int l, int r) {
        return (l > 0) ? cul[r] - cul[l - 1] : cul[r];
    }

    int id(char c) {
        return c - 'A';
    }
}