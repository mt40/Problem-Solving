package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class DutchNationalFlag {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        int pivot = a[k];
        int smaller = 0, equal = 0, larger = n - 1;
        while(equal <= larger) {
            if(a[equal] < pivot)
                swap(a, smaller++, equal++);
            else if(a[equal] == pivot)
                equal++;
            else
                swap(a, equal, larger--);
        }

        for(int x : a)
            out.printf("%d ", x);
        out.println();
    }

    void swap(int []a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
