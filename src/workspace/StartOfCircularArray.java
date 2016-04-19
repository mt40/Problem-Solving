package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

/**
 * Given a circular sorted array, find its starting point
 * (i.e. position of the minimum element)
 */
public class StartOfCircularArray {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []a = in.arr(n);

        int min = binSearch(a);
        out.println(a[min]);
    }

    int binSearch(int []a) {
        int low = 0, hi = a.length - 1;
        while(a[low] > a[hi]) {
            int mid = low + (hi - low) / 2;
            if(a[mid] > a[hi]) // the right part is unsorted, min must be in it
                low = mid + 1;
            else
                hi = mid;
        }
        return low;
    }
}