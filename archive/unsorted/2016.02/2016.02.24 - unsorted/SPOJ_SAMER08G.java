package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_SAMER08G {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n;
        while((n = in.i()) > 0) {
            int []grid = new int[n+1];
            boolean ok = true;
            for(int i = 1; i <= n; ++i) {
                int car = in.i(), dif = in.i();
                int old = i + dif;
                if(old <= 0 || old > n || grid[old] > 0)
                    ok = false;
                else
                    grid[old] = car;
            }

            if(!ok)
                out.println(-1);
            else {
                for (int i = 1; i <= n; ++i)
                    out.print(grid[i] + " ");
                out.println();
            }
        }
    }
}