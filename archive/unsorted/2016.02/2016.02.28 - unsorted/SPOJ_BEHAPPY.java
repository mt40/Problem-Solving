package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_BEHAPPY {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        while(true) {
            int m = in.i(), n = in.i();
            if(m == 0 && n == 0) return;
            Pair []a = new Pair[m + 1];
            for(int i = 1; i <= m; ++i)
                a[i] = new Pair(in.i(), in.i());

            int [][]dp = new int[m + 1][n + 1];
            dp[0][n] = 1; // not give to anyone
            for (int i = 1; i <= m; ++i) { // i_th person
                for (int j = 0; j <= n; ++j) { // j gifts left
                    if (dp[i - 1][j] == 0) continue;
                    for (int g = a[i].a; g <= a[i].b; ++g) { // gives g gifts to this person
                        if (j - g >= 0) { // if enough gift
                            dp[i][j - g] += dp[i - 1][j];
                        }
                    }
                }
            }

            int ans = dp[m][0];
            out.println(ans);
        }
    }

    class Pair {
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}