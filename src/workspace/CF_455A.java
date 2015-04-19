package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class CF_455A {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        int []f = new int[100001];
        for(int i = 0; i < n; ++i)
            f[a[i]]++;

        long max = 0;
        long []dp = new long[100001];
        for(int i = 1; i <= 100000; ++i) {
            if(f[i] == 0)
                dp[i] = dp[i - 1];
            else {
                dp[i] = (long)f[i] * i;
                dp[i] += (i - 2 >= 0) ? dp[i - 2] : 0;
                dp[i] = Math.max(dp[i - 1], dp[i]);
            }
            if(dp[i] > max)
                max = dp[i];
        }

        out.println(max);
    }
}
