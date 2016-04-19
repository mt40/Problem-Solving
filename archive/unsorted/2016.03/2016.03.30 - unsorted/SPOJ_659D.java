package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_659D {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        Point []pts = new Point[n + 1];
        for(int i = 0; i <= n; ++i)
            pts[i] = new Point(in.i(), in.i());

        int ans = 0;
        for(int i = 1; i < n; ++i) {
            Point a = pts[i-1], b = pts[i], c = pts[i + 1];
            int angle = orientation(a, b, c);
            if(angle < 0) // left turn
                ans++;
        }

        out.println(ans);
    }

    // 0: straight, 1: clockwise, -1: counter-clockwise
    int orientation(Point a, Point b, Point c) {
        int sign_of_slope = (b.y - a.y)*(c.x - b.x) - (c.y - b.y)*(b.x - a.x);
        if(sign_of_slope == 0) return 0;
        return (sign_of_slope > 0) ? 1 : -1;
    }

    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}