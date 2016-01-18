package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class CF_588A {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int min = Integer.MAX_VALUE;
        int ans = 0;
        while(n-- > 0) {
            int a = in.nextInt(), c = in.nextInt();
            ans += Math.min(c, min) * a;
            min = Math.min(c, min);
        }

        out.println(ans);
    }
}
