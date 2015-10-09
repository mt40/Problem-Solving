package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class SearchFor_Ai_Equal_i {
    /**
     * Search for i such that a[i] = i
     * Array contains only distinct elements
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        out.println(binSearch(a));
    }

    int binSearch(int []a) {
        int n = a.length, low = 0, hi = n - 1;
        while(low <= hi) {
            int mid = low + (hi - low) / 2;
            if(a[mid] == mid)
                return mid;
            else if(a[mid] < mid)
                low = mid + 1;
            else
                hi = mid - 1;
        }
        return -1;
    }
}
