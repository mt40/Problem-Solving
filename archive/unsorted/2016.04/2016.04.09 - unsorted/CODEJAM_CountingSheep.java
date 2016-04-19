package workspace;

import helperClasses.InputReader;

import java.io.PrintWriter;

import helperClasses.FastScanner;
import helperClasses.Util;

public class CODEJAM_CountingSheep {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);

        int n = in.i();

        boolean[] digit = new boolean[10];
        int cnt = 0;
        long mul = n;
        for (int i = 0; i < 1000 * 1000; ++i) {
            long tmp = mul;
            // count digits
            while (tmp > 0) {
                int d = (int) tmp % 10;
                if (!digit[d]) {
                    cnt++;
                    digit[d] = true;
                }
                tmp /= 10;
            }
            if (cnt == 10)
                break;
            mul += n;
        }

        if (cnt < 10)
            out.printf("Case #%d: INSOMNIA\n", testNumber);
        else
            out.printf("Case #%d: %d\n", testNumber, mul);
    }
}