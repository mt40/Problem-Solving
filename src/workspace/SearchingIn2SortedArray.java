package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class SearchingIn2SortedArray {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        int []a = new int[n], b = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();
        for(int i = 0; i < n; ++i)
            b[i] = in.nextInt();

        while(m-- > 0) {
            int k = in.nextInt();
            out.println(getKthSmallest(a, b, k));
        }
    }

    /**
     * Find the k-th smallest value of a sorted array c
     * contains all elements of a & b
     */
    int getKthSmallest(int []a, int []b, int k) {
        int low = 0, hi = Math.min(Math.max(a.length, b.length), k);
        while(low <= hi) {
            int x = low + (hi - low) / 2;
            if(low == hi)
                return Math.max(a[x - 1], b[k - x - 1]);
            if(a[x - 1] == b[k - x - 1])
                return a[x - 1];
            else if(a[x - 1] < b[k - x - 1])
                low = x + 1;
            else
                hi = x - 1;
        }
        return -1;
    }
}
