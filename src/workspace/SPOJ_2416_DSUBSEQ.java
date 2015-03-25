package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class SPOJ_2416_DSUBSEQ {
    long mod = 1000000007;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next();
        int n = s.length();
        char []a = new char[n + 1];
        for(int i = 0; i < n; ++i) a[i + 1] = s.charAt(i);

        int []last = new int[27]; // last position of a[i]

        long []dp = new long[n + 1];
        dp[0] = 1;
        for(int i = 1; i <= n; ++i) {
            dp[i] = 2 * dp[i - 1];
            if(last[a[i] - 'A'] > 0)
                dp[i] -= dp[last[a[i] - 'A'] - 1];
            dp[i] = mod(dp[i]);
            last[a[i] - 'A'] = i;
        }

        out.println(dp[n]);
    }

    // Guarantee always return positive modulo
    long mod(long x) {
        return (x % mod + mod) % mod;
    }
}
