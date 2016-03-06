package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_PHIDIAS {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int m = in.i(), n = in.i(), k = in.i();
        HashSet<Slab> set = new HashSet<>();
        for(int i = 0; i < k; ++i)
            set.add(new Slab(in.i(), in.i()));

        int [][]dp = new int[n+1][m+1];
        for(int i = 1; i <= n; ++i)
            for(int j = 1; j <= m; ++j)
                if(!set.contains(new Slab(j, i)))
                    dp[i][j] = i * j;

        for(int i = 1; i <= n; ++i) {
            for(int j = 1; j <= m; ++j) {
                for(Slab sl : set) {
                    int min = i*j;
                    if(sl.w <= j && sl.h <= i)
                        min = Math.min(
                                dp[sl.h][j-sl.w] + dp[i-sl.h][j],
                                dp[i-sl.h][sl.w] + dp[i][j-sl.w]);
                    dp[i][j] = Math.min(min, dp[i][j]);
                }
            }
        }

        //for(int []dpi : dp) System.out.println(Arrays.toString(dpi));

        out.println(dp[n][m]);
    }

    class Slab {
        int w, h;

        public Slab(int w, int h) {
            this.w = w;
            this.h = h;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Slab slab = (Slab) o;

            if (w != slab.w) return false;
            return h == slab.h;

        }

        @Override
        public int hashCode() {
            int result = w;
            result = 31 * result + h;
            return result;
        }
    }
}