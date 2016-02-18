package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_AP3 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        long three = in.l(), four = in.l(), sum = in.l();
        long d = Long.divideUnsigned(three - 1, 2);

        int n = 0;
        long a1 = 1;
        while(sum > 0) {
            sum -= a1;
            a1 += d;
            n++;
        }

        out.println(n);
        a1 = 1;
        for(int i = 0; i < n; ++i) {
            out.print(Long.toUnsignedString(a1) + " ");
            a1 += d;
        }
        out.println();
    }
}