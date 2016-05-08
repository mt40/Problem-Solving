package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

import helperClasses.FastScanner;

/**
 * Given a sorted array A and number x in A, find frequency of x
 */
public class FrequencyInSortedArray {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), x = in.i();
        int []a = in.arr(n);

        int ans = calc(a, n, x);
        out.println(ans);
    }

    int calc(int []a, int n, int x) {
        int low = binSearch(a, n, x);
        int hi = binSearch(a, n, x + 1);
        if(low < 0)
            return 0;
        if(hi < 0) hi = ~hi;
        return hi - low;
    }

    int binSearch(int []a, int n, int key) {
        int low = 0, hi = n - 1, rs = -1;
        while(low <= hi) {
            int mid = low + (hi - low) / 2;
            if(a[mid] == key) {
                rs = mid;
                hi = mid - 1;
            }
            else if(a[mid] > key)
                hi = mid - 1;
            else
                low = mid + 1;
        }
        if(rs < 0)
            return -(low + 1);
        return rs;
    }
}