package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_580A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        int ans = 1;
        for(int i = 0; i < n; ++i) {
            int tmp = 1;
            while(i < n - 1 && a[i + 1] >= a[i]) {
                tmp++;
                i++;
                ans = Math.max(ans, tmp);
            }
        }

        out.println(ans);
    }
}
