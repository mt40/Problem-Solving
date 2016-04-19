package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.*;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_PICAD {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int test = 10;
        while(test-- > 0) {
            int p = 0, k = 0, n = 0;
            try {
                p = in.i();
                k = in.i();
                n = in.i();
            } catch(Exception e) {}
            List<Point> points = new ArrayList<>(2 * n);
            for (int i = 0; i < n; ++i) {
                int l = in.i(), r = in.i();
                if (r < p || l > k) continue; // out of range
                l = Math.max(l, p);
                r = Math.min(r, k);
                points.add(new Point(l, false));
                points.add(new Point(r + 0.5, true));
            }

            Collections.sort(points, cprt);

            int min = inf, max = 0, cur = 0;
            double prev_x = p;
            for (Point pt : points) {
                if (p <= prev_x && prev_x <= k && pt.val != prev_x) {
                    max = Math.max(cur, max);
                    min = Math.min(cur, min);
                }
                if (pt.isEnd)
                    cur--;
                else
                    cur++;
                prev_x = pt.val;
            }
            if (min == inf) min = 0;
            if (prev_x < k) min = 0;

            out.printf("%d %d\n", min, max);
        }
    }

    Comparator<Point> cprt = (p1, p2) -> {
        int t = Double.compare(p1.val, p2.val);
        return (t != 0) ? t : Boolean.compare(p1.isEnd, p2.isEnd);
    };

    class Point {
        double val;
        boolean isEnd;

        public Point(double val, boolean isEnd) {
            this.val = val;
            this.isEnd = isEnd;
        }
    }
}