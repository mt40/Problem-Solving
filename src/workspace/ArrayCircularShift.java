package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class ArrayCircularShift {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int []a = new int[n];

        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        for(int i = n - k - 1; i >= 0; --i) {
            //shift right k pos
            for(int j = i ; j < k + i ; ++j) {
                int tmp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = tmp;
            }
        }

        // print
        for(int i = 0; i < n; ++i)
            out.print(a[i] + " ");
        out.println();
    }
}
