package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_285C {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        Integer []a = new Integer[n]; // use wrapper Integer to make Arrays.sort use Merge sort
        for(int i = 0; i < n; ++i)
            a[i] = new Integer(in.nextInt());

        Arrays.sort(a);
        long ans = 0;
        for(int i = 0; i < n; ++i) {
            ans += Math.abs((i + 1) * 1l - a[i]);
        }

        out.println(ans);
    }
}
