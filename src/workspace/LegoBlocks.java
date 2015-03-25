package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class LegoBlocks {
    int mod = 1000000007;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();

        // Calculate case height = 1
        long []base = new long[m + 1];
        base[1] = 1;
        if(m >= 2) base[2] = 2;
        if(m >= 3) base[3] = 4;
        if(m >= 4) base[4] = 4 + 2 + 1 + 1;
        for(int i = 5; i <= m; ++i)
            base[i] = (base[i - 1] + base[i - 2]
                    + base[i - 3] + base[i - 4]) % mod;

        // calculate all possible choices
        long []all = new long[m + 1];
        for(int i = 1; i <= m; ++i)
            all[i] = pow(base[i], n);

        // len i: .... | .......
        //          j      i - j
        //        dp[j]   all[i-j]
        //      (valid    (maybe
        //       choices)  non-valid)
        long []dp = new long[m + 1];
        dp[1] = 1;
        for(int i = 2; i <= m; ++i) {
            dp[i] = all[i];
            long invalid = 0;
            for(int j = 1; j < i; ++j) {
                invalid = (invalid + dp[j] * all[i - j]) % mod;
            }
            dp[i] = (dp[i] - invalid + mod) % mod; // guarantee no negative number
        }

        out.println(dp[m]);
    }

    public long pow(long a, long e) {
        long ans = 1;
        while(e >= 1) {
            ans = (ans * a) % mod;
            e--;
        }
        return ans;
    }
}
