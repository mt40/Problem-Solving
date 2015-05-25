package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_182B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int d = in.nextInt();
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        int clock = 1, day = 1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (clock != day) {
                if (clock > day) {
                    ans += d - clock + 1;
                    clock = 1;
                }
                ans += day - clock;
                clock = day;
            }
            day = a[i];
            clock = a[i] + 1;
            if (clock > d)
                clock = 1;

            day = 1;
        }
        out.println(ans);
    }
}
