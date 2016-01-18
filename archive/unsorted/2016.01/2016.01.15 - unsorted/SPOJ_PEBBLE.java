package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_PEBBLE {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int t = 1;
        while(true) {
            char []a;
            try {
                a = in.c();
            } catch(Exception e) {
                return;
            }

            int ans = 0, n = a.length;
            for(int i = n - 1; i >= 0; --i) {
                if(a[i] == '1') {
                    ans += (i == n - 1) ? 1 : 2;
                    while(i >= 0 && a[i] == '1') i--;
                    i++;
                }
            }

            out.printf("Game #%d: %d\n", t++, ans);
        }
    }
}