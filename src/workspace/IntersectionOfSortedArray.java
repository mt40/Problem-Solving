package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class IntersectionOfSortedArray {
    /**
     * Find the array C which is the intersection of 2 sorted
     * array A & B
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        int []a = new int[n], b = new int[m];
        for(int i = 0; i < n; ++i) a[i] = in.nextInt();
        for(int i = 0; i < m; ++i) b[i] = in.nextInt();

        Integer []ans = new Integer[Math.min(n, m)];
        int i = 0, j = 0, k = 0;
        while(i < n && j < m) {
            if(a[i] == b[j]) {
                ans[k++] = a[i];
                i++; j++;
            }
            else if(a[i] < b[j])
                i++;
            else
                j++;
        }

        for(Integer x : ans) {
            if(x != null)
                out.print(x + " ");
        }
        out.println();
    }
}
