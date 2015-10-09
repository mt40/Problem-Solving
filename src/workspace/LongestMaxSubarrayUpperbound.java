package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class LongestMaxSubarrayUpperbound {
    /**
     * Find the longest subarray but its sum must be <= K
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), k = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        int []prefix = new int[n];
        for(int i = 0; i < n; ++i)
            prefix[i] = (i > 0) ? prefix[i - 1] + a[i] : a[i];

        int []frontier = new int[n];
        frontier[n - 1] = prefix[n - 1];
        for(int i = n - 2; i >= 0; --i)
            frontier[i] = Math.min(prefix[i], frontier[i + 1]);

        int l = 0, r = 0, max_len = 0;
        for(int i = 0; i < n; ++i) {
            int tmp_ans = lastSmaller(frontier, i, prefix[i] + k);
            if(tmp_ans - i + 1 > max_len) {
                max_len = tmp_ans - i + 1;
                l = i + 1; r = tmp_ans;
            }
        }

        out.println(l + " " + r);
    }

    /**
     * Largest element but smaller than 'val'
     */
    int lastSmaller(int []a, int i, int val) {
        int n = a.length, low = i, hi = n - 1;
        int rs = i;
        while(low <= hi) {
            int mid = low + (hi - low) / 2;
            if(a[mid] <= val) {
                rs = mid;
                low = mid + 1;
            }
            else hi = mid - 1;
        }
        return rs;
    }
}
