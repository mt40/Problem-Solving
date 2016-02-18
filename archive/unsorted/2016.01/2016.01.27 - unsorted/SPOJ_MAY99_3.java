package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_MAY99_3 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int x = in.i(), y = in.i(), z = in.i();
        boolean ok = true;
        if(z > x && z > y) ok = false;
        if(z % gcd(x, y) != 0) ok = false;
        out.println(ok ? "YES" : "NO");
    }

    int gcd(int a, int b) {
        if(a == 0) return b;
        return gcd(b % a, a);
    }
}