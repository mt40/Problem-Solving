package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class MergeSort {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        int []ans = mergeSort(a);
        for(int i = 0; i < n; ++i)
            out.print(ans[i] + " ");
        out.println();
    }

    int[] mergeSort(int []arr) {
        int n = arr.length;
        if(n == 1)
            return arr;
        int mid = n / 2;
        int []left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int []right = mergeSort(Arrays.copyOfRange(arr, mid, n));
        int []merge = new int[n];

        int i = 0, j = 0, k = 0;
        while(i < left.length && j < right.length) {
            if(left[i] <= right[j]) {
                merge[k] = left[i];
                i++; k++;
            }
            else {
                merge[k] = right[j];
                j++; k++;
            }
        }
        while(i < left.length) {
            merge[k] = left[i];
            i++; k++;
        }
        while(j < right.length) {
            merge[k] = right[j];
            j++; k++;
        }
        return merge;
    }
}
