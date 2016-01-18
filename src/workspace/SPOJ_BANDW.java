package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_BANDW {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        while(true) {
            char[]a = in.c(), b = in.c();
            if(a[0] == '*') return;
            boolean ok = true;
            int ans = 0;
            for(int i = 0; i < a.length; ++i) {
                if(a[i] != b[i]) ok = false;
                else if(!ok) {
                    ans++;
                    ok = true;
                }
            }
            if(!ok) ans++;
            out.println(ans);
        }
    }
}