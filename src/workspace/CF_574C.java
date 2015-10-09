package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_574C {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        for(int i = 0; i < n; ++i) {
            a[i] = reduce(a[i]);
        }

        for(int i = 1; i < n; ++i) {
            if(a[i] != a[0]) {
                out.println("No");
                return;
            }
        }
        out.println("Yes");
    }

    int reduce(int x) {
        while(x % 2 == 0) x /= 2;
        while(x % 3 == 0) x /= 3;
        return x;
    }
}
