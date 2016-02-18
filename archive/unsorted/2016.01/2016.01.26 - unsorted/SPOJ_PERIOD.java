package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_PERIOD {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        char []c = in.c(true);

        int []f = new int[n+1];
        for(int i = 2, j = 1; i <= n; ++i) {
            if(c[i] == c[j]) {
                f[i] = 1 + f[i - 1];
                j++;
            }
            else j = 1;
        }

        out.printf("Test case #%d\n", testNumber);
        for(int i = 2; i <= n; ++i) {
            if(f[i] == 0) continue;
            int base = i - f[i];
            if(i % base == 0) {
                out.printf("%d %d\n", i, i / base);
            }
        }
        out.println();
    }
}