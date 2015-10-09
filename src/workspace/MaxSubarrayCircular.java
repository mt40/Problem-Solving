package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class MaxSubarrayCircular {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        // Max from 0 -> i
        int []prefix = new int[n];
        prefix[0] = a[0];
        int prefix_sum = a[0];
        for(int i = 1; i < n; ++i) {
            prefix_sum += a[i];
            prefix[i] = Math.max(prefix[i - 1], prefix_sum);
        }

        // Max from i + 1 -> n - 1
        int []suffix = new int[n];
        int suffix_sum = 0;
        for(int i = n - 2; i >= 0; --i) {
            suffix_sum += a[i + 1];
            suffix[i] = Math.max(suffix[i + 1], suffix_sum);
        }

        // Max of circular array
        int max = a[0];
        for(int i = 0; i < n; ++i) {
            max = Math.max(max, prefix[i] + suffix[i]);
        }

        // Max of normal array
        // Kadane algorithm
        // we have to do this for test case 3
        int max2 = a[0], tmp_max = a[0];
        for(int i = 1; i < n; ++i) {
            tmp_max = Math.max(tmp_max + a[i], a[i]);
            max2 = Math.max(max2, tmp_max);
        }

        out.println(Math.max(max, max2));
    }
}
