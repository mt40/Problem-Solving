package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_604C {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        char []a = in.next().toCharArray();
        int ans = count(a, n);
        int pairs = Math.min(2, n - ans);
        out.println(ans + pairs);
    }

    int count(char []a, int n) {
        int rs = 1;
        char prev = a[0];
        for(int i = 1; i < n; ++i) {
            if(a[i] != prev) {
                rs++;
                prev = a[i];
            }
        }
        return rs;
    }
}
