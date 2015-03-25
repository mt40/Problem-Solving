package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class BubbleSort {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];

        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        bubbleSort(a, n);
        out.println(Arrays.toString(a));
    }

    public void bubbleSort(int []a, int n) {
        boolean stop = false;
        while(!stop) {
            stop = true;
            for(int i = 0; i + 1 < n; ++i) {
                if(a[i] > a[i + 1]) {
                    int tmp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = tmp;
                    stop = false;
                }
            }
        }
    }
}
