package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_669A {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int ans = calc(n);

        out.println(ans);
    }

    int calc(int n) {
        if(n == 0) return 0;
        if(n < 3) return 1;
        return 2 * (n / 3) + calc(n % 3);
    }
}