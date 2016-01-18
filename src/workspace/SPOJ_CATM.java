package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_CATM {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), m = in.i(), t = in.i();
        while(t-- > 0) {
            Pos mouse = new Pos(in.i(), in.i());
            Pos cat1 = new Pos(in.i(), in.i()), cat2 = new Pos(in.i(), in.i());
            boolean ok = false;

            // left
            Pos exit = new Pos(mouse.x, 1);
            int d1 = dist(exit, mouse), d2 = dist(exit, cat1), d3 = dist(exit, cat2);
            if (d1 < d2 && d1 < d3) ok = true;

            // top
            exit = new Pos(1, mouse.y);
            d1 = dist(exit, mouse);
            d2 = dist(exit, cat1);
            d3 = dist(exit, cat2);
            if (d1 < d2 && d1 < d3) ok = true;

            // bot
            exit = new Pos(n, mouse.y);
            d1 = dist(exit, mouse);
            d2 = dist(exit, cat1);
            d3 = dist(exit, cat2);
            if (d1 < d2 && d1 < d3) ok = true;

            // right
            exit = new Pos(mouse.x, m);
            d1 = dist(exit, mouse);
            d2 = dist(exit, cat1);
            d3 = dist(exit, cat2);
            if (d1 < d2 && d1 < d3) ok = true;

            if (ok) out.println("YES");
            else out.println("NO");
        }
    }

    int dist(Pos a, Pos b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}