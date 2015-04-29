package workspace;

import helperClasses.InputReader;

import java.io.PrintWriter;
import java.util.Arrays;

public class CF_294B {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] t = new int[n + 1];
        int[] w = new int[n + 1];

        for (int i = 1; i <= n; ++i) {
            t[i] = in.nextInt();
            w[i] = in.nextInt();
        }

        /*
        *   dp[i] = bề dày nhỏ nhất của dãy sách (đáp án) khi còn i chỗ để
        *   xếp sách nằm ngang phía trên
         */
        int[] dp = new int[201];
        int sum = 0;
        for(int i = 1; i <= n; ++i)
            sum += t[i];
        // base case: put all the books vertically
        dp[sum] = sum;

        // try to remove books
        for(int i = 1; i <= n; ++i) {
            for(int j = 0; j <= 200; ++j) {
                // if there are enough width to put the book horizontally
                if(w[i] <= j - t[i] && dp[j] > 0) {
                    if (dp[j - w[i] - t[i]] == 0)
                        dp[j - w[i] - t[i]] = dp[j] - t[i];
                    else
                        dp[j - w[i] - t[i]] = Math.min(dp[j] - t[i], dp[j - w[i] - t[i]]);
                }
            }
        }

        // find the minimum width, which is calculated
        int min = 0;
        for (int j = 0; j <= 100; ++j) {
            if (min == 0)
                min = dp[j];
            else if (dp[j] < min && dp[j] > 0)
                min = dp[j];
        }

        out.println(min);
    }
}
