package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPJ_MAY99_2 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        long n = in.l();

        char []map = {'u','m','a','n','k'};
        String ans = "";
        while(n > 0) {
            int c = (int)(n % 10);
            ans = map[c % 5] + ans;
            n = (n-1)/5;
        }

        out.println(ans);
    }
}