package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class RadixSort2 {
    /**
     * Radix sort revisit
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        radixSort(a);

        for(int x : a)
            out.print(x + " ");
        out.println();
    }

    void radixSort(int []a) {
        int max = getMax(a);
        for(int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(a, exp);
        }
    }

    void countingSort(int []a, int exp) {
        int []count = new int[10];
        int n = a.length;

        for(int i = 0; i < n; ++i)
            count[ (a[i] / exp) % 10 ]++;

        for(int i = 1; i < 10; ++i)
            count[i] += count[i - 1];

        int []sorted = new int[n];
        for(int i = n - 1; i >= 0; --i) { // loop from the right to ensure the previous order
            int pos = count[ (a[i] / exp) % 10 ] - 1;
            sorted[pos] = a[i];
            --count[ (a[i] / exp) % 10 ]; // update the position for future lookup
        }

        // copy back to original array
        for(int i = 0; i < n; ++i)
            a[i] = sorted[i];
    }

    int getMax(int []a) {
        int max = a[0];
        for(int i = 1; i < a.length; ++i)
            max = Math.max(max, a[i]);
        return max;
    }
}
