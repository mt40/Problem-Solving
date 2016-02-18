package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Stack;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_BSHEEP {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        HashMap<Point, Integer> map = new HashMap<>();
        Point []tmp = new Point[n];
        int size = 0;
        for(int i = 0; i < n; ++i) {
            Point p = new Point(in.i(), in.i());
            if(map.containsKey(p)) continue;
            tmp[size++] = p;
            map.put(p, i);
        }

        Point []pts = new Point[size];
        System.arraycopy(tmp, 0, pts, 0, size);

        Point[] ans = convexHull(pts);
        double total = 0;
        n = ans.length;
        for(int i = 0; i < n; ++i)
            total += Math.sqrt(sqrDist(ans[i], ans[(i + 1) % n]));
        out.printf("%.2f\n", total);
        for(Point p : ans)
            out.print((map.get(p) + 1) + " ");
        out.println("\n");
    }

    Point[] convexHull(Point []pts) {
        int n = pts.length;

        int minY = getMinY(pts);
        swap(pts, 0, minY);
        root = pts[0]; // use for sorting

        Arrays.sort(pts, 1, n, cprt);

        // if 3 points are on the same line, only keep the
        // 1st and furthest point
        int m = 1;
        for(int i = 1; i < n; ++i) {
            while(i < n - 1 && orientation(root, pts[i], pts[i + 1]) == 0)
                i++;
            pts[m++] = pts[i];
        }
        n = m;
        if(n < 3) return Arrays.copyOfRange(pts, 0, n);

        Stack<Point> s = new Stack<>();
        s.push(pts[0]);
        s.push(pts[1]);
        s.push(pts[2]);
        for(int i = 3; i < n; ++i) {
            while(s.size() >= 2 && orientation(nextToTop(s), s.peek(), pts[i]) != 2)
                s.pop();
            s.push(pts[i]);
        }

        Point []rs = new Point[s.size()];
        int id = 0;
        for(Point si : s) rs[id++] = si;

        return rs;
    }

    <T>T nextToTop(Stack<T> s) {
        T top = s.pop();
        T rs = s.peek();
        s.push(top);
        return rs;
    }

    Point root;
    Comparator<Point> cprt = new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            int o = orientation(root, o1, o2);
            if(o == 0) {
                if(sqrDist(root, o1) <= sqrDist(root, o2))
                    return -1;
                return 1;
            }
            return (o == 1) ? 1 : -1;
        }
    };

    int getMinY(Point []pts) {
        int id = 0;
        Point minY = pts[0];
        for(int i = 1; i < pts.length; ++i) {
            if(pts[i].y < minY.y || (pts[i].y == minY.y && pts[i].x < minY.x)) {
                id = i;
                minY = pts[i];
            }
        }
        return id;
    }

    int orientation(Point a, Point b, Point c) {
        int sign = (b.y - a.y) * (c.x - b.x) - (c.y - b.y) * (b.x - a.x);
        return (sign == 0)
                ? 0
                : (sign > 0) ? 1 : 2; // clockwise and counter clockwise
    }

    <T>void swap(T []a, int i, int j) {
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}