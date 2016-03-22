package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_HIST2 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n;
        while((n = in.i()) > 0) {
            int []a = in.arr(n);
            int lim = (1 << n) - 1;
            int maxH = Util.max(a);

            int [][]dp = new int[maxH + 1][lim + 1];
            long []cnt = new long[5000];
            for(int i = 0; i < n; ++i) {
                int mask = 1 << i;
                dp[a[i]][mask] = p(a[i]);
                cnt[dp[a[i]][mask]]++;
            }
            int f = 0;
            for(int len = 2; len <= n; ++len) {
                for (int i = 0; i < n; ++i) {
                    for(int m = 1; m <= lim; ++m) {
                        if(Integer.bitCount(m) != len - 1 || contains(m, i))
                            continue;
                        int mask = m | (1 << i);
                        for(int h = 0; h <= maxH; ++h) {
                            if(dp[h][m] > 0) {
                                int minH = Math.min(a[i], h);
                                int newP = dp[h][m] + p(a[i]) - 2*minH;
                                if(newP > dp[a[i]][mask]) {
                                    dp[a[i]][mask] = newP;
                                    cnt[newP] += cnt[dp[h][m]];
                                }
//                                if(mask == lim) {
//                                    f++;
//
//                                    String s = "" + (i + 1);
//                                    for(int id = 0; id < n; ++id)
//                                        if((m & (1 << id)) > 0)
//                                            s = s + " " + (id + 1);
//                                    System.out.println(s);
//                                }
                            }
                        }
                    }
                }
            }

            int max = 0;
            for(int h = 0; h <= maxH; ++h)
                max = Math.max(dp[h][lim], max);

            out.printf("%d %d\n", max, cnt[max]);
        }
    }

    boolean contains(int mask, int i) {
        return (mask & (1 << i)) > 0;
    }

    int p(int h) {
        return 2 + 2*h;
    }
}