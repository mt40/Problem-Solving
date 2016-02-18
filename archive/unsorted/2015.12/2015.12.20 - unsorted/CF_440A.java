package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_440A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n - 1];
        for(int i = 0; i < n - 1; ++i) a[i] = in.nextInt();

        int xor = 0;
        for(int i = 1; i <= n; ++i) xor ^= i;
        for(int i : a) xor ^= i;

        out.println(xor);
    }
}
