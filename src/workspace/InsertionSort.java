package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class InsertionSort {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];

        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        for(int i = 0; i < n; ++i) {
            int val = a[i];
            int j = i + 1;
            while(j < n && val > a[j])
                a[i] = a[j++];
            a[j - 1] = val;
        }

        // output
        for(int i = 0; i < n; ++i)
            out.print(a[i] + " ");
        out.println();
    }
}
