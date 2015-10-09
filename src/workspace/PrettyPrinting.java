package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class PrettyPrinting {
    /**
     * Problem 15.13 in Elements Of Programming Interview
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), L = in.nextInt();
        String []words = new String[n + 1];
        for(int i = 1; i <= n; ++i)
            words[i] = in.next();

        long dp[] = new long[n + 1];
        int []trace = new int[n + 1];
        for(int i = 1; i <= n; ++i) {
            String w = words[i];
            int free_space = L - w.length(), len = w.length();
            dp[i] = dp[i - 1] + messiness(free_space);
            trace[i] = i - 1;
            for(int j = 2; j <= L && i - j >= 0; ++j) {
                free_space -= words[i - j + 1].length() + 1;
                if(free_space < 0) break;
                if(dp[i] > dp[i - j] + messiness(free_space)) {
                    dp[i] = dp[i - j] + messiness(free_space);
                    trace[i] = i - j;
                }
            }
        }

        out.println(dp[n]);
    }

    long messiness(int freeSpace) {
        return 1l << freeSpace;
    }
}
