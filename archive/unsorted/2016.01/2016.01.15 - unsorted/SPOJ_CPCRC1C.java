package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_CPCRC1C {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        while(true) {
            int a = in.i(), b = in.i();
            if(a < 0) return;
            long x = cal(a-1), y = cal(b);
            out.println(y - x);
        }
    }

    long cal(long num) {
        if(num <= 0)
            return 0;
        long q = num / 10;
        long r = num % 10;

        return 45L * q + 10 * cal(q - 1) + r * (r + 1) / 2 + sumDigit(q) * (r + 1);
    }

    int sumDigit(long x) {
        int rs = 0;
        while (x > 0) {
            rs += x % 10;
            x /= 10;
        }
        return rs;
    }
}