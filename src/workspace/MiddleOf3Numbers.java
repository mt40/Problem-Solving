package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

/**
 * Given 3 numbers, find the number in middle (or 2nd smallest)
 */
public class MiddleOf3Numbers {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int a = in.i(), b = in.i(), c = in.i();

        //int ans = a + b + c - max(a, b, c) - min(a, b, c);
        int ans = middle(a, b, c);

        out.println(ans);
    }

    int middle(int a, int b, int c) {
        if(a > b) {
            if(b > c) return b;
            if(c > a) return a;
            return c;
        }
        else {
            if(a > c) return a;
            if(c > b) return b;
            return c;
        }
    }

    int max(int a, int b, int c) {
        return max(max(a, b), c);
    }

    int max(int a, int b) {
        return (a >= b) ? a : b;
    }

    int min(int a, int b, int c) {
        return min(min(a, b), c);
    }

    int min(int a, int b) {
        return (a < b) ? a : b;
    }
}