package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_SYNC13C {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int a = in.i(), b = in.i();
        if(isEven(a) || isEven(b))
            out.println("Suresh");
        else
            out.println("Ramesh");
    }

    boolean isEven(int x) {
        return (x & 1) == 0;
    }
}