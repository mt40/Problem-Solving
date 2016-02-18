package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class MedianOf2SortedArrays_set2 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        n = in.i();
        m = in.i();
        int []a = in.arr(n);
        int []b = in.arr(m);

        half = (n + m) / 2;
        int med = cal(a, b, 0, n - 1);
        out.println(med);
    }

    int n, m;
    int half; // half of the final array (not include the median)
    int step = 1;
    int cal(int []a, int []b, int l, int r) {
        /* Assume a[i] is the median, then we must have
        the equal number of elements to the left and right.
        Base on that, we calculate our expected number of lesser
        elements in array b */
        int i = (l + r) / 2; // i is also the number of lesser elements in a
        int j = half - i - 1; // expected number of lesser elements in b

        /* Median is not in array a, switch 2 arrays
        and find the median in b */
        if(l > r || j < 0)
            return cal(b, a, 0, b.length - 1);

        display(a, b, i, j); // for debugging

        // We found the median! Recursion ends here
        if(a[i] > b[j] && (j == m - 1 || a[i] <= b[j + 1])) {
            int x = a[i], y = inf, rs;
            if((n + m) % 2 > 0) // odd length -> median is the middle element
                rs = a[i];
            /* Even length -> median is average of 2 middle elements
            the 1st middle elem is of course a[i], the 2nd one
            is b[j] or a[i - 1] */
            else if(i == 0 || b[j] > a[i - 1]) {
                rs = (a[i] + b[j]) / 2;                     y = b[j]; // debug
            }
            else {
                rs = (a[i] + a[i - 1]) / 2;                 y = a[i - 1]; // debug
            }

            displayRs(x, y); // debug
            return rs;
        }

        // a[i] is greater than the real median, search in the left half
        else if(a[i] > b[j] && j != m - 1 && a[i] > b[j + 1])
            return cal(a, b, l, i - 1);
        // a[i] is smaller, search in the right
        return cal(a, b, i + 1, r);
    }

    void display(int []a, int []b, int i, int j) {
        System.out.printf("Step %d: ", ++step);
        int []merge = new int[i + j + 1];
        System.arraycopy(a, 0, merge, 0, i);
        System.arraycopy(b, 0, merge, i, j + 1);
        System.out.printf("Looking at %d.\n- If %d is median, expected smaller elements are: %s\n",
                a[i], a[i],
                Arrays.toString(merge));
    }

    void displayRs(int x, int y) {
        System.out.printf("Calculate median from: %s %s\n", x, (y == inf) ? "" : y);
    }
}