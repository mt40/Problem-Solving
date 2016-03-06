package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_LKS {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int k = in.i(), n = in.i();
        int []v = new int[n], w = new int[n];
        for(int i = 0; i < n; ++i) {
            v[i] = in.i();
            w[i] = in.i();
        }

        int []dp = new int[k + 1];
        int ans = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = k; j - w[i] >= 0; --j) {
                if(j - w[i] == 0 || dp[j - w[i]] > 0)
                    dp[j] = maxUnsigned(dp[j - w[i]] + v[i], dp[j]);
                ans = maxUnsigned(dp[j], ans);
            }
        }

        out.println(Integer.toUnsignedString(ans));
    }

    int maxUnsigned(int a, int b) {
        int c = Integer.compareUnsigned(a, b);
        return (c >= 0) ? a : b;
    }
}