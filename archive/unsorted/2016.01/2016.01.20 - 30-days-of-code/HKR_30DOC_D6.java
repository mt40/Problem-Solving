package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class HKR_30DOC_D6 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; ++i) {
            int zero = n - i, j = i;
            while(zero-- > 0) sb.append(" ");
            while(j-- > 0) sb.append("#");
            out.println(sb.toString());
            sb = new StringBuilder();
        }
    }
}