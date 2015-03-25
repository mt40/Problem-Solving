package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class SPOJ_DIEHARD {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int h = in.nextInt();
        int a = in.nextInt();

        int ans = 0;
        for(int i = 0; i < 3; ++i) {
            int rs = dp(0, i, h, a);
            if (rs > ans)
                ans = rs;
        }

        out.println(ans - 1);
    }

    int dp(int t, int i, int h, int a) {
        if (h <= 0 || a <= 0)
            return t;
        if (i == 0) {
            if(a <= 10)
                return dp(t + 1, 2,  h - 20, a + 5);
            return dp(t + 1, 1, h - 5, a - 10);
//            return Math.max(
//                    dp(t + 1, 1, h - 5, a - 10),
//                    dp(t + 1, 2, h - 20, a + 5));
        } else if (i == 1) {
            return dp(t + 1, 0, h + 3, a + 2);
//            return Math.max(
//                    dp(t + 1, 0, h + 3, a + 2),
//                    dp(t + 1, 2, h - 20, a + 5));
        } else {
            return dp(t + 1, 0, h + 3, a + 2);
//            return Math.max(
//                    dp(t + 1, 0, h + 3, a + 2),
//                    dp(t + 1, 1, h - 5, a - 10));
        }
    }
}
