package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_COLONY {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int year = in.i();
        long pos = in.l();

        boolean ans = cal(year, pos);
        out.println(ans ? "red" : "blue");
    }

    boolean cal(int year, long pos) {
        if(year == 0) return true;
        if(year == 1) return pos == 1;

        long len = 1l << year;
        long half = len >> 1;

        if(pos >= half) return cal(year - 1, pos - half);
        long left = 0;
        int prevYear = year - 2;
        half >>= 1;
        while(half > 0) {
            if(pos < left + half) return cal(prevYear, pos - left);

            left += half;
            half >>= 1;
            prevYear--;
        }
        return false;
    }
}