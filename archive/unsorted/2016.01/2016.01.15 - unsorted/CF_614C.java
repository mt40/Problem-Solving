package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;

import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_614C {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        Point p = new Point(in.i(), in.i());
        Point far = null, near = null;
        double max_d = 0, min_d = Long.MAX_VALUE;
        for(int i = 0; i < n; ++i) {
            Point t = new Point(in.i(), in.i());
            double d = dt(p, t);
            if(d > max_d) {
                max_d = d;
                far = t;
            }
            if(d < min_d) {
                min_d = d;
                near = t;
            }
        }

        double inner_r = dt(p, near);
        double outer_r = dt(p, far);
        BigDecimal ans = area(outer_r).subtract(area(inner_r));
        out.println(ans.setScale(18, RoundingMode.CEILING));
    }

    BigDecimal pi = BigDecimal.valueOf(Math.PI);
    BigDecimal area(double r) {
        return pi.multiply(BigDecimal.valueOf(r*r));
    }

    double dt(Point a, Point b) {
        return Math.sqrt(sqr(b.x - a.x) + sqr(b.y - a.y));
    }

    double sqr(double a) {
        return a*a;
    }

    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}