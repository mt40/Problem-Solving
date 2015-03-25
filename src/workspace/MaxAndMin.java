package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class MaxAndMin {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        int i = 0, min = a[0], max = a[0], count = 0;
        while(i + 1 < n) {
            if(a[i] < a[i + 1]) {
                min = Math.min(min, a[i]);
                max = Math.max(max, a[i + 1]);
            }
            else {
                min = Math.min(min, a[i + 1]);
                max = Math.max(max, a[i]);
            }
            count++; i++;
        }

        out.printf("min: %d\n max: %d\n comparisons: %d\n", min, max, count);
    }
}
