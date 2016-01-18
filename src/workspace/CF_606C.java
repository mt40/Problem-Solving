package workspace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_606C {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
        }

        int []pos = new int[n + 1];
        int len = 1, l = 1, r = 1;
        for(int i = 0; i < n; ++i)
            pos[a[i]] = i;
        for(int i = 2; i <= n; ++i) {
            if(pos[i] > pos[i - 1]) {
                r = i;
                len = Math.max(len, r - l + 1);
            }
            else {
                l = r = i;
            }
        }

        int ans = n - len;
        out.println(ans);
    }
}
