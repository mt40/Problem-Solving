package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_NG0FRCTN {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        while((n = in.l()) > 0) {
            int h = (int)(Math.log(n) / Math.log(2));
            long prev = (1L << h) - 1;
            long row = n - prev;
            Fraction ans = cal(h, row);
            out.printf("%d/%d\n", ans.a, ans.b);
        }
    }

    long n;
    Fraction cal(int lvl, long row) {
        if(lvl == 0)
            return new Fraction(1, 1);
        long parent = (row + 1) >> 1;
        Fraction p = cal(lvl-1, parent);
        // this is left or right child ?
        return ((row & 1) > 0) ? p.left() : p.right();
    }

    class Fraction {
        long a, b;

        public Fraction(long a, long b) {
            this.a = a;
            this.b = b;
        }

        Fraction right() {
            return new Fraction(a + b, b);
        }

        Fraction left() {
            return new Fraction(a, a+b);
        }
    }
}
