package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class FloatingPointError {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        float a = 1 << 24;
        float b = a + 1;
        out.println("a & b should not be the same :)");
        out.printf("%.10f\n", a);
        out.printf("%.10f\n", b);
    }
}