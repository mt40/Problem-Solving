package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_MAIN72 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []a = in.arr(n);

        int sum = 0;
        for(int ai : a) sum += ai;
        boolean []dp = new boolean[sum + 1];
        dp[0] = true;
        for(int i = 0; i < n; ++i) {
            for(int j = sum; j >= 0; --j) {
                if(dp[j])
                    dp[j + a[i]] = true;
            }
        }

        long ans = 0;
        for(int i = 0; i < dp.length; ++i)
            if(dp[i]) ans += i;

        out.println(ans);
    }
}