package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_SUBS {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        char []x = in.c(), y = in.c();

        int low = 0, hi = y.length / x.length, ans = low;
        while(low <= hi) {
            int m = low + (hi - low) / 2;
            char []tmp = create(x, m);
            if(isSubseq(tmp, y)) {
                low = m + 1;
                ans = m;
            }
            else hi = m - 1;
        }

        out.println(ans);
    }

    char []create(char []base, int exp) {
        char []rs = new char[base.length * exp];
        int idx = 0;
        for(char c : base) {
            for(int i = 0; i < exp; ++i)
                rs[idx++] = c;
        }
        return rs;
    }

    boolean isSubseq(char []x, char []y) {
        if(x.length > y.length) return false;
        int len = 0;
        for(char yi : y) {
            if(len < x.length && yi == x[len])
                len++;
        }
        return len == x.length;
    }
}