package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_ACPC10E {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int g;
        while((g = in.i()) >= 0) {
            long t = in.i(), a = in.i(), d = in.i();
            long group_matches = g * ((t - 1)*t/2);
            long teams = nextPowerOf2(a * g + d);
            long added = teams - (a * g + d);
            long total = (teams - 1) + group_matches;
            out.printf("%d*%d/%d+%d=%d+%d\n", g, a, t, d, total, added);
        }
    }

    long nextPowerOf2(long n) {
        long rounded = Long.highestOneBit(n);
        return (rounded == 0) // 0 is a power of 2
                ? rounded
                : (Long.bitCount(n) == 1) // already a power of 2
                    ? rounded
                    : rounded << 1;
    }
}