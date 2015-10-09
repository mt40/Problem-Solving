package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class ArrayRotation {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
        }

        while(m-- > 0) {
            int offset = in.nextInt();
            //out.println(arrString(linear(a, offset)));
            out.println(arrString(constant(a, offset)));

        }
    }

    String arrString(int []a) {
        String rs = "";
        for(int x : a)
            rs += x + " ";
        return rs;
    }

    // reverse using linear storage
    int[] linear(int []a, int offset) {
        int []clone = a.clone();
        int n = a.length;
        for(int i = 0; i < a.length; ++i) {
            /* Both lines below works. Choose 1 */
            //clone[(i + offset) % n] = a[i];
            clone[i] = a[(n - offset + i) % n];
        }
        return clone;
    }

    /**
     * Rotate using constant storage
     */
    int[] constant(int []a, int offset) {
        int []clone = a.clone();
        int n = a.length;
        reverse(clone, 0, n - 1);
        reverse(clone, 0, offset - 1);
        reverse(clone, offset, n - 1);
        return clone;
    }

    void reverse(int[] a, int l, int r) {
        for(int i = 0; i < (r - l + 1) / 2; ++i) {
            swap(a, l + i, r - i);
        }
    }

    void swap(int []a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
