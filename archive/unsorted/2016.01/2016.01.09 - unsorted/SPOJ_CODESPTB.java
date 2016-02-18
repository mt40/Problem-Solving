package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;
import helperClasses.ShortScanner;

public class SPOJ_CODESPTB {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i();
        int []a = in.arr(n);
        ans = 0;
        mergeSort(a);

        out.println(ans);
    }

    long ans = 0;

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
