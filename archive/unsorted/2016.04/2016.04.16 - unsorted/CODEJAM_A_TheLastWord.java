package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class CODEJAM_A_TheLastWord {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        char []a = in.c();
        int n = a.length;

        StringBuilder sb = new StringBuilder(n);
        char first = a[0];
        sb.append(a[0]);
        for (int i = 1; i < n; ++i) {
            char c = a[i];
            if (c < first)
                sb.append(c);
            else {
                sb.insert(0, c);
                first = c;
            }
        }

        out.printf("Case #%d: ", testNumber);
        out.println(sb.toString());
    }
}