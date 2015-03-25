package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CountingSort {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        int max = 0;
        for(int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
            if(a[i] > max) max = a[i];
        }

        int []count = new int[max + 1];
        for(int i = 0; i < n; ++i)
            count[a[i]]++;

        int []rs = new int[n];
        int j = 0;
        for(int i = 0; i <= max; ++i) {
            while(count[i] > 0) {
                rs[j] = i;
                count[i]--;
                j++;
            }
        }

        for(int i = 0; i < n; ++i)
            out.print(rs[i] + " ");
        out.println();
    }
}
