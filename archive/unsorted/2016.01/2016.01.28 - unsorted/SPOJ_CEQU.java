package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_CEQU {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int a = in.i(), b = in.i(), c = in.i();
        out.printf("Case %d: ", testNumber);
        if(c % gcd(a, b) == 0)
            out.println("Yes");
        else out.println("No");
    }

    int gcd(int a, int b) {
        if(a == 0) return b;
        return gcd(b % a, a);
    }
}