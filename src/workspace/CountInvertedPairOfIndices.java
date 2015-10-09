package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class CountInvertedPairOfIndices {
    /**
     * Count the number of pair i, j (i < j) such that a[i] > a[j]
     * The idea is to use merge sort, complexity O(nlogn)
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();
        ans = 0;
        mergeSort(a);
        out.println(ans);
    }

    int ans = 0;

    int[] mergeSort(int []a) {
        int n = a.length;
        if(n <= 1) return a;
        int mid = n / 2;
        int []left = mergeSort(Arrays.copyOfRange(a, 0, mid));
        int []right = mergeSort(Arrays.copyOfRange(a, mid, n));
        int []merge = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while(i < left.length && j < right.length) {
            if(left[i] > right[j]) {
                ans += left.length - i;
                merge[k++] = right[j++];
            }
            else
                merge[k++] = left[i++];
        }
        while(i < left.length)
            merge[k++] = left[i++];
        while(j < right.length)
            merge[k++] = right[j++];

        return merge;
    }
}
