package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class MaximumSubarray {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];

        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        out.println(max_subarray(a));
    }

    // Kadane's Algorithm
    public int max_subarray(int []a) {
        int max = 0, tmp_max = a[0];
        for(int i = 1; i < a.length; ++i) {
            tmp_max = Math.max(a[i], tmp_max + a[i]);
            max = Math.max(max, tmp_max);
            //System.out.format("%d: %d %d\n", i, tmp_max, max);
        }

        return max;
    }
}
