package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_631B {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), m = in.i(), k = in.i();
        Op []rows = new Op[n+1], cols = new Op[m+1];
        for(int i = 0; i <= n; ++i) rows[i] = new Op(0, -1);
        for(int i = 0; i <= m; ++i) cols[i] = new Op(0, -1);

        for(int i = 0; i < k; ++i) {
            int t = in.i(), id = in.i(), color = in.i();
            if(t == 1)
                rows[id] = new Op(color, i);
            else
                cols[id] = new Op(color, i);
        }

        for(int i = 1; i <= n; ++i) {
            for(int j = 1; j <= m; ++j) {
                int color = 0;
                if(rows[i].time > cols[j].time)
                    color = rows[i].color;
                else
                    color = cols[j].color;
                out.print(color + " ");
            }
            out.println();
        }
    }

    class Op {
        int color, time = -1;

        public Op(int color, int time) {
            this.color = color;
            this.time = time;
        }
    }
}