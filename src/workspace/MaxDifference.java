package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

/**
 * Find the maximum value of M = (a_i - a_j) with i < j
 */
public class MaxDifference {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
        }

        int min = 0, max = 1, diff = 0;
        for(int i = 1; i < n; ++i) {
            if(a[i - 1] < a[min])
                min = i - 1;
            if(a[i] > a[max])
                max = i;
            diff = (a[max] - a[min] > diff) ? a[max] - a[min] : diff;
        }

        out.println(diff);
    }
}
