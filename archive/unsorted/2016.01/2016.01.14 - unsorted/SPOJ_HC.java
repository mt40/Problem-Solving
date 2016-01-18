package workspace;

import helperClasses.FastScanner;
import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.ShortScanner;
import helperClasses.Util;

public class SPOJ_HC {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []f = new int[2];
        while(n-- > 0) {
            String s = in.s();
            if(s.equals("lxh")) f[0]++;
            else f[1]++;
        }

        out.println(((f[0] & 1) > 0) ? "lxh" : "hhb");
    }
}
