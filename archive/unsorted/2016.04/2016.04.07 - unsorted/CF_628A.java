package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_628A {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), b = in.i(), p = in.i();

        int bottles = 0, towels = p * n;
        while(n > 1) {
            int k = Integer.highestOneBit(n);
            bottles += b * k + k / 2;
            n = k / 2 + (n - k);
        }

        out.printf("%d %d\n", bottles, towels);
    }
}