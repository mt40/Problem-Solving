package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_RANJAN02 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);

        long []moves = new long[36];
        for(int i = 1; i <= 35; ++i)
            moves[i] = 3 * moves[i - 1] + 2;

        int t = in.i();
        while(t-- > 0) {
            int n = in.i();
            out.println(moves[n]);
        }
    }
}