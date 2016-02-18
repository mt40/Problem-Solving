package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class CF_466A {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();

        int ans = 0;
        int rem = n / m;
        if(rem * b <= rem * m * a)
            ans = rem * b;
        else
            ans = rem * m * a;
        ans += Math.min((n - rem * m) * a, b);

        out.println(ans);
    }
}
