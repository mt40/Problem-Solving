package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class QuickSort {
    int n, cnt1, cnt2;
    int []a;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        n = in.nextInt();
        a = new int[n];
        cnt1 = cnt2 = 0;

        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        quickSort(0, n - 1);

        for(int i = 0; i < n; ++i)
            out.print(a[i] + " ");
        out.println();

        out.printf("Comparisons: %d %d\n", cnt1, cnt2);
    }

    public void quickSort(int low, int hi) {
        System.out.printf("size: %d\n", hi - low + 1);
        int i = low, j = hi;
        int p = low; //(low + hi) / 2;
        while(i <= j) {
            while (a[i] < a[p]) {
                i++; cnt1++;
            }
            while (a[j] > a[p]) {
                j--; cnt2++;
            }
            if (i <= j) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++; j--;
            }
        }
        if(low < j) quickSort(low, j);
        if(i < hi) quickSort(i, hi);
    }
}
