package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_ADV04J {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        out.println(cal(n));
    }

    int cal(int x) {
        if(x < 3) return 0;
        if(x == 3 || x == 4) return 3;
        return cal((int)Math.ceil(x/2.0)) + 1;
    }
}