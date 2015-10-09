package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class MinimumOfSortedCycleArray {
    /**
     * Find the minimum element of a circular sorted array
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        out.println(a[getMin(a)]);
    }

    int getMin(int []a) {
        int n = a.length, low = 0, hi = n - 1;
        int min = 0;
        while(low <= hi) {
            int mid = low + (hi - low) / 2;
            if((mid > 0 && a[mid] < a[mid - 1])
                    || (mid == 0 && a[mid] < a[n - 1]))
                return mid;
            if(a[mid] >= a[hi]) {
                /**
                 * Tr??ng h?p ví d?:
                 * 4 5 10 15 1 2 : mid ?ang là 10
                 * 5 5 5 15 1 5 : mid ?ang là 5 (i = 2)
                 */
                min = (a[mid] < a[min]) ? mid : min;
                low = mid + 1;
            }
            else
                hi = mid - 1;
        }
        return min;
    }
}
