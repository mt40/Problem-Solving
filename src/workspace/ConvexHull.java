package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

import helperClasses.FastScanner;
import helperClasses.Util;

/**
 * Implementation of Graham' scan algorithm
 * ref: http://www.geeksforgeeks.org/convex-hull-set-2-graham-scan/
 */
public class ConvexHull {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);

        // POINTS MUST BE DISTINCT! read convexHull method for reason why
        int n = in.i();
        Point []pts = new Point[n];
        for(int i = 0; i < n; ++i)
            pts[i] = new Point(in.i(), in.i());

        Point []ans = convexHull(pts);

        if(ans == null || ans.length == 0)
            out.println("No convex hull found.");
        else {
            out.print("Convex hull: ");
            for(Point pt : ans)
                out.print(pt + ", ");
            out.println();
        }
    }

    Point[] convexHull(Point []pts) {
        int n = pts.length;

        int lowest = lowest(pts);
        swap(pts, 0, lowest); // bring this point to the front
        root = pts[0]; // save root to do the sorting

        // sort depends on the first point (root)
        Arrays.sort(pts, 1, pts.length, cprt);

        // Normally here we have to remove the points
        // that have the same angle, (from the above sort)
        // we only keep the furthest point in that case
        // but for simplicity, I skip it

        if(n < 3) return null; // no convex hull

        Stack<Point> s = new Stack<>();
        // the first 3 points are always accepted
        s.push(pts[0]);
        s.push(pts[1]);
        s.push(pts[2]);

        for(int i = 3; i < n; ++i) {
            while(orientation(nextToTop(s), s.peek(), pts[i]) != CCW)
                s.pop();
            s.push(pts[i]);
        }

        Point []rs = new Point[s.size()];
        int id = 0;
        for(Point si : s) rs[id++] = si;

        return rs;
    }

    Point root; // the first point of the convex hull

    Comparator<Point> cprt = new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            int o = orientation(root, o1, o2);
            if(o == COLLINEAR) {
                if(sqrDist(root, o1) < sqrDist(root, o2))
                    return -1;
                return 1;
            }

            return (o == CW) ? 1 : -1;
        }
    };

    /**
     * Find the Point with smallest Y (X as small as possible)
     */
    int lowest(Point []pts) {
        int rs = 0;
        Point minY = pts[0];
        for(int i = 1; i < pts.length; ++i) {
            if(pts[i].y < minY.y
                    || (pts[i].y == minY.y && pts[i].x < minY.x)) {
                minY = pts[i];
                rs = i;
            }
        }
        return rs;
    }

    // collinear = on the same line, cw = clockwise, ccw = counter clockwise
    static final int COLLINEAR = 0, CW = 1, CCW = 2;

    // the beauty is here! ^_^
    int orientation(Point a, Point b, Point c) {
        int sign_of_slope = (b.y - a.y)*(c.x - b.x) - (c.y - b.y)*(b.x - a.x);
        if(sign_of_slope == 0) return COLLINEAR;
        return (sign_of_slope > 0) ? CW : CCW;
    }

    <T>void swap(T []a, int i, int j) {
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    <T>T nextToTop(Stack<T> s) {
        T top = s.pop();
        T rs = s.peek();
        s.push(top);
        return rs;
    }

    /**
     * Square distance
     */
    double sqrDist(Point a, Point b) {
        return sqr(a.x - b.x) + sqr(a.y - b.y);
    }

    double sqr(double x) { return x*x; }

    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "{" + x + "," + y + '}';
        }
    }
}