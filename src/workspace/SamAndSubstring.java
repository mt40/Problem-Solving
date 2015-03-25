package workspace;

import java.math.BigInteger;
import java.util.Scanner;
import java.io.PrintWriter;

public class SamAndSubstring {
    int mod = 1000000007;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next();
        int n = s.length();
        int []a = new int[n];

        for(int i = 0; i < n; ++i)
            a[i] = s.charAt(i) - '0';

        // dp[i] = tong tat ca cac so ma hang don vi la a[i]
        // dp[i + 1] = (i + 2) * a[i + 1] + 10 * dp[i]
        long []dp = new long[n];
        long sum = a[0];
        dp[0] = a[0];
        for(int i = 1; i < n; ++i) {
            dp[i] = ((i + 1) * a[i] + 10 * dp[i - 1]) % mod;
            sum = (sum + dp[i]) % mod;
        }

        out.println(sum);
    }
}
