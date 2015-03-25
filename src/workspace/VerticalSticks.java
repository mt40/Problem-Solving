package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

/**
 * Solution: http://cs.stackexchange.com/a/1114
 */
public class VerticalSticks {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];

        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        // dp[i] = number of a[x] >= a[i]
        int []dp = new int[n];
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j)
                if(a[j] >= a[i])
                    dp[i]++;
        }

        double ans = 0;
        for(int i = 0; i < n; ++i)
            ans += (n + 1) * 1.0 / (dp[i] + 1);

        out.format("%.2f\n", ans);
    }
}
