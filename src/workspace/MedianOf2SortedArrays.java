package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

/**
 * Divide and conquer approach.
 * This approach is easy to understand but require too
 * much code therefore easy to make mistake. Also, it does not
 * work for array of length 1 (see the results of the tests)
 * ref: http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
 */
public class MedianOf2SortedArrays {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), m = in.i();
        a = in.arr(n);
        b = in.arr(m);

        int med = cal(0, n - 1, 0, m - 1);
        out.println(med);
    }

    int []a, b;
    int step = 0;
    int cal(int al, int ar, int bl, int br) {
        // For debug purpose
        display(al, ar, bl, br);

        int n = ar - al + 1, m = br - bl + 1;
        // Base case
        if(n <= 2 && m <= 2)
            return base(al, ar, bl, br);

        int m1 = median(a, al, ar);
        int m2 = median(b, bl, br);

        if(m1 == m2)
            return m1;
        else if(m1 < m2) {
            int m1_i = (n % 2 == 0) ? al + n/2 - 1 : al + n/2;
            int m2_i = (m % 2 == 0) ? bl + m/2 : bl + m/2;
            return cal(m1_i, ar, bl, m2_i);
        }
        else {
            int m1_i = (n % 2 == 0) ? al + n/2 : al + n/2;
            int m2_i = (m % 2 == 0) ? bl + m/2 - 1 : bl + m/2;
            return cal(al, m1_i, m2_i, br);
        }
    }

    int base(int al, int ar, int bl, int br) {
        int n = ar - al + 1, m = br - bl + 1;
        int []merge = new int[n + m];
        System.arraycopy(a, al, merge, 0, n);
        System.arraycopy(b, bl, merge, n, m);
        Arrays.sort(merge);
        return median(merge, 0, n + m - 1);
    }

    int median(int []arr, int l, int r) {
        int n = r - l + 1;
        if(n % 2 == 0)
            return (arr[l + n/2 - 1] + arr[l + n/2]) / 2;
        else
            return arr[l + n/2];
    }

    void display(int al, int ar, int bl, int br) {
        System.out.printf("Step %d: ", ++step);
        System.out.printf("%s %s\n",
                Arrays.toString(Arrays.copyOfRange(a, al, ar + 1)),
                Arrays.toString(Arrays.copyOfRange(b, bl, br + 1)));
    }
}