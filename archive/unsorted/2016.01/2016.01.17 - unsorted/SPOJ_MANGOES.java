package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_MANGOES {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();

        int x = n - 2;
        int odds = x / 2;
        if(x % 2 > 0) odds++;
        long ans = (1L * odds * odds) % n;
        out.println(ans);
    }
}