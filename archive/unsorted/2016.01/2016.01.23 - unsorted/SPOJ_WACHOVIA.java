package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_WACHOVIA {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), m = in.i();
        Bag []a = new Bag[m];
        for(int i = 0; i < m; ++i) a[i] = new Bag(in.i(), in.i());

        int []dp = new int[n + 1];
        int ans = 0;
        for (int j = 0; j < m; ++j) {
            for (int i = n; i >= 0; --i) {
                int prev = i - a[j].w;
                if (prev >= 0) {
                    dp[i] = Math.max(dp[i - a[j].w] + a[j].v, dp[i]);
                    ans = Math.max(dp[i], ans);
                }
            }
        }

        System.out.println(Arrays.toString(dp));

        out.printf("Hey stupid robber, you can get %d.\n", ans);
    }

    class Bag {
        int w, v;

        public Bag(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
}