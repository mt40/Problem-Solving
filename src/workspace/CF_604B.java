package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_604B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), k = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i) a[i] = in.nextInt();

        int n_left = n, k_left = k;
        int ans = a[0];
        while(n_left != 2 * k_left && n_left > 0) {
            ans = Math.max(a[n_left - 1], ans);
            n_left--;
            k_left--;
        }
        int m = n_left;
        for(int i = 0; i < m/2; ++i) {
            ans = Math.max(ans, a[i] + a[m - 1 - i]);
        }
        out.println(ans);
    }
}
