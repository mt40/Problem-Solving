package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_669B {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        char []direction = in.c();
        int []len = in.arr(n);

        boolean ans = true;
        boolean []visit = new boolean[n];
        int u = 0;
        for(int iter = 0; iter <= n; ++iter) {
            if(isOutside(u, n))
                break;
            if(visit[u]) {
                ans = false;
                break;
            }

            visit[u] = true;
            u += (direction[u] == '>') ? len[u] : -len[u];
        }

        out.println(ans ? "FINITE" : "INFINITE");
    }

    boolean isOutside(int u, int n) {
        return u < 0 || u >= n;
    }
}