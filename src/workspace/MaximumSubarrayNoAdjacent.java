package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class MaximumSubarrayNoAdjacent {
    /**
     * Find the max subsequence such that no 2 elements are adjacent
     * ex: 3 2 7 10 --> 3 + 10 = 13
     * 1 3 1 7 10 --> 3 + 10 = 13
     * In case there are negative elements, just ignore.
     * Solution: http://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        /**
         * The idea is to use 2 array include and exclude
         * include[i]= Max sum until now that includes a[i]
         * exclude[i]= Max sum until now but not include a[i]
         */
        int []include = new int[n];
        int []exclude = new int[n];
        include[0] = a[0];
        include[1] = 0;
        for(int i = 1; i < n; ++i) {
            include[i] = exclude[i - 1] + a[i];
            exclude[i] = Math.max(include[i - 1], exclude[i - 1]);
        }

        out.println(Math.max(include[n - 1], exclude[n - 1]));
    }
}
