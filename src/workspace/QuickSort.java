package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class QuickSort {
    int n;
    int []a;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        n = in.nextInt();
        a = new int[n];

        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        quickSort(0, n - 1);

        for(int i = 0; i < n; ++i)
            out.print(a[i] + " ");
        out.println();
    }

    public void quickSort(int low, int hi) {
        int i = low, j = hi;
        int p = (low + hi) / 2;
        while(i <= j) {
            while (a[i] < a[p]) i++;
            while (a[j] > a[p]) j--;
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
