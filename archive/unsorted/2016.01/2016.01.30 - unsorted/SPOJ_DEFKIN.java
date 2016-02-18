package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_DEFKIN {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int m = in.i(), n = in.i(), t = in.i();
        boolean []row = new boolean[n+1];
        boolean []col = new boolean[m+1];
        for(int i = 0; i < t; ++i) {
            col[in.i()] = true;
            row[in.i()] = true;
        }

        int mx_r = 0, mx_c = 0;
        int cnt = 0;
        for(int i = 1; i <= n; ++i) {
            if(row[i]) {
                mx_r = Math.max(cnt, mx_r);
                cnt = 0;
            }
            else cnt++;
        }
        if(cnt > 0) mx_r = Math.max(cnt, mx_r);
        cnt = 0;
        for(int i = 1; i <= m; ++i) {
            if(col[i]) {
                mx_c = Math.max(cnt, mx_c);
                cnt = 0;
            }
            else cnt++;
        }
        if(cnt > 0) mx_c = Math.max(cnt, mx_c);

        int ans = mx_r * mx_c;
        out.println(ans);
    }
}