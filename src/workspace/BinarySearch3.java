package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class BinarySearch3 {
    /**
     * The correct way to implement binary search
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();
        for(int i = 0; i < m; ++i) {
            int target = in.nextInt();
            out.println(binSearch(a, target));
        }
    }

    int binSearch(int []a, int target) {
        int n = a.length, low = 0, hi = n - 1;
        int ans = -1;
        while(low <= hi) {
            int mid = low + (hi - low) / 2; // avoid overflow
            if(a[mid] == target) { // we want to find the first occurence of target
                ans = mid;
                hi = mid - 1;
            }
            else if(a[mid] < target)
                low = mid + 1;
            else
                hi = mid - 1;
        }
        return ans;
    }
}
