package workspace;

import java.util.Random;
import java.util.Scanner;
import java.io.PrintWriter;

public class QuickSort2 {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        quickSort(a);
        out.println(arrStr(a));
    }

    String arrStr(int []a) {
        String s = "";
        for(int x : a)
            s += x + " ";
        return s;
    }

    void quickSort(int []a) {
        quickSort(a, 0, a.length - 1);
    }

    void quickSort(int []a, int l, int r) {
        int pivot = a[new Random().nextInt(r + 1 - l) + l];
        int i = l, j = r;
        while(i <= j) {
            while(a[i] < pivot) ++i;
            while(pivot < a[j]) --j;
            if(i <= j) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                ++i; --j;
            }
        }
        if(i < r) quickSort(a, i, r);
        if(l < j) quickSort(a, l, j);
    }
}
