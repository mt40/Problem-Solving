package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class CF_476A {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();

        int ans = -1;
        for(int i = 1; i <= n/m; ++i) {
            int b = n - m * i;
            if(b >= 0) {
                int a = n - 2 * b;
                if(a >= 0) {
                    if (a + b < ans || ans == -1)
                        ans = a + b;
                }
            }
        }

        out.println(ans);
    }
}
