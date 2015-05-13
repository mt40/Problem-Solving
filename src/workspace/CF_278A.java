package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class CF_278A {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int sum = 0;
        int []a = new int[n + 1];

        for(int i = 1; i <= n; ++i) {
            a[i] = in.nextInt();
            sum += a[i];
        }

        int x = in.nextInt(), y = in.nextInt();
        int tmp = x;
        x = Math.min(x, y);
        y = Math.max(tmp, y);

        int ans = 0;
        for(int i = x; i < y; ++i)
            ans += a[i];

        out.println(Math.min(ans, sum - ans));
    }
}
