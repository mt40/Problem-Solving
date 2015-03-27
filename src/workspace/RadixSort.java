package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class RadixSort {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        radixSort(a, n);
        for(int i = 0; i < n; ++i)
            out.print(a[i] + " ");
        out.println();
    }

    void radixSort(int arr[], int n) {
        // find the max value to know the maximum number of digits
        int max = getMax(arr);

        // instead of creating the array of digits,
        // we pass the exponent
        for(int exp = 1; max / exp > 0; ++exp)
            countingSort(arr, exp);
    }

    void countingSort(int []arr, int exp) {
        int n = arr.length;
        int []count = new int[10];

        // store frequency
        for(int i = 0; i < n; ++i)
            count[(arr[i] / exp) % 10]++;

        // convert to position
        for(int i = 1; i < 10; ++i)
            count[i] += count[i - 1];

        int []result = new int[n];
        for(int i = n - 1; i >= 0; --i) {
            int digit = (arr[i] / exp) % 10;
            result[ count[digit] - 1 ] = arr[i];
            count[digit]--;
        }

        // copy back
        for(int i = 0; i < n; ++i)
            arr[i] = result[i];
    }

    int getMax(int []arr) {
        int max = arr[0];
        for(int i = 1; i < arr.length; ++i)
            if(arr[i] > max)
                max = arr[i];
        return max;
    }
}
