package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class BinarySearch2 {
    int n, m;
    int []a;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();
        out.println(binSearch(m));
    }

    /**
     * Search for the max element but <= target
     */
    int binSearch(int target) {
        int low = 0, hi = n - 1;
        int max = -1;
        while(low <= hi) {
            int mid = (low + hi) / 2;
            if(a[mid] > max && a[mid] <= target)
                max = a[mid];
            if(a[mid] > target)
                hi = mid - 1;
            else
                low = mid + 1;
        }

        return max;
    }
}
