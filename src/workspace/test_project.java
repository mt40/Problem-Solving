package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class test_project {
    int []a;
    int n;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        n = in.nextInt();
        a = new int[n];

        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        qSort(a, 0, n - 1);
        for(int i = 0; i < n; ++i)
            out.print(a[i] + " ");
    }

    void qSort(int []a, int low, int hi) {
        int i = low, j = hi;
        int mid = (i + j) / 2;
        while(i <= j) {
            while(a[i] < a[mid]) i++;
            while(a[j] > a[mid]) j--;
            if(i <= j) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++; j--;
            }
        }
        if(low < j) qSort(a, low, j);
        if(i < hi) qSort(a, i, hi);
    }
}
