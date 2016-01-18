package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.math.BigDecimal;

import helperClasses.FastScanner;
import helperClasses.Util;

public class HKR_MOST_DISTANT {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        Point []a = new Point[4]; // +max_x, -max_x, +max_y, -max_y
        for(int i = 0; i < n; ++i) {
            Point p = new Point(in.i(), in.i());
            if(a[0] == null || a[0].x < p.x)
                a[0] = p;
            if(a[1] == null || p.x < a[1].x)
                a[1] = p;
            if(a[2] == null || a[2].y < p.y)
                a[2] = p;
            if(a[3] == null || p.y < a[3].y)
                a[3] = p;
        }

        double ans = 0;
        for(int i = 0; i < 4; ++i)
            for(int j = 0; j < 4; ++j)
                ans = Math.max(dist(a[i], a[j]), ans);

        out.printf("%.6f\n", new BigDecimal(ans).setScale(12, BigDecimal.ROUND_HALF_UP));
    }

    double dist(Point a, Point b) {
        return Math.sqrt(sqr(b.x - a.x) + sqr(b.y - a.y));
    }

    double sqr(double x) {
        return x * x;
    }

    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}