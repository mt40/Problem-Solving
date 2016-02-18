package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SOPJ_RPLE {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), k = in.i();
        boolean []isSpy = new boolean[10000 + 1];
        int []a = new int[k], b = new int[k];

        boolean ok = true;
        for(int i = 0; i < k; ++i) {
            a[i] = in.i();
            b[i] = in.i();
        }

        for(int ai : a) isSpy[ai] = true;
        for(int bi : b) if(isSpy[bi]) ok = false;

        out.printf("Scenario #%d: ", testNumber);
        out.println(ok ? "spying" : "spied");
    }
}