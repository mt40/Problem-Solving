package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class LongestNondecreasingSubsequence2 {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        int []dp = new int[n];
        int []path = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 0; i < n; ++i) {
            for(int j = i - 1; j >= 0; --j) {
                if(a[j] < a[i]) {
                    if(dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        path[i] = j;
                    }
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < n; ++i) {
            if(dp[i] > dp[ans])
                ans = i;
        }

        // reconstruct the path
        int trace = ans;
        System.out.print("Path: ");
        for(int i = 0; i < dp[ans]; ++i) {
            System.out.print(a[trace] + " ");
            trace = path[trace];
        }
        System.out.println();

        out.println(dp[ans]);
    }
}
