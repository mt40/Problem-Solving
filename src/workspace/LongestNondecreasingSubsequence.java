package workspace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class LongestNondecreasingSubsequence {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        /**
         * Idea: dp[j] = index of the last element of the subsequence of length j
         * Suppose the current longest subsequence has length 'max'
         * At a[i], we want to find the largest j <= max and has
         * a[dp[j]] <= a[i] that means a[i] will be the last element of the
         * subsequence of length j + 1 a.k.a a[j + 1] = i
         * Then we update max = larger(max, j + 1)
         */
        int []dp = new int[n + 1];
        int []path = new int[n];
        int max = 0;
        for(int i = 0; i < n; ++i) {
            int new_max = lastSmaller(dp, a, i, max);
            dp[new_max] = i;
            path[i] = dp[new_max - 1];
            max = Math.max(max, new_max);
        }

        // reconstruct the path
        int trace = dp[max];
        System.out.print("Path: ");
        for(int i = 0; i < max; ++i) {
            System.out.print(a[trace] + " ");
            trace = path[trace];
        }
        System.out.println();

        out.println(max);
    }

    int lastSmaller(int []dp, int []a, int i, int max) {
        int low = 1, hi = max;
        while(low <= hi) {
            int mid = low + (hi - low) / 2;
            if(a[dp[mid]] <= a[i])
                low = mid + 1;
            else hi = mid - 1;
        }
        return low;
    }
}
