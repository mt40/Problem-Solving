package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

import helperClasses.FastScanner;
import helperClasses.Util;

public class CLOPPAIR {
    int inf = Integer.MAX_VALUE;

    /**
     * I follow this article
     * http://www.geeksforgeeks.org/closest-pair-of-points/
     */
    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        Point []pts = new Point[n];
        for(int i = 0; i < n; ++i) {
            pts[i] = new Point(in.i(), in.i(), i);
        }

        Result ans = closest(pts);

        out.printf("%d %d %.6f\n",
                Math.min(ans.idxA, ans.idxB),
                Math.max(ans.idxA, ans.idxB),
                ans.dist);
    }

    Result closest(Point []pts) {
        Arrays.sort(pts, cprtX);
        return closest(pts, 0, pts.length - 1);
    }

    Result closest(Point []pts, int l, int r) {
        int n = r - l + 1;
        if(n <= 3)
            return bruteForce(pts, n, inf);

        int mid = n / 2;
        Point midPoint = pts[l + mid];
        Result left = closest(pts, l, mid);
        Result right = closest(pts, mid + 1, r);
        Result d = min(left, right);

        Point []strip = new Point[n];
        int idx = 0;
        for(int i = l; i <= r; ++i)
            if(Math.abs(pts[i].x - midPoint.x) < d.dist)
                strip[idx++] = pts[i];

        Result middle = bruteForce(strip, idx, d.dist);
        d = min(middle, d);

        return d;
    }

    <T extends Comparable<T>>T min(T a, T b) {
        return (a.compareTo(b) <= 0) ? a : b;
    }

    Result bruteForce(Point []strip, int n, double maxDist) {
        Arrays.sort(strip, 0, n, cprtY); // sort by y

        Result rs = new Result(-1, -1, inf);

        for(int i = 0; i < n; ++i) {
            for(int j = i + 1; j < n; ++j) {
                double dt = dist(strip[j], strip[i]);
                if(dt > maxDist) break;
                if(dt < rs.dist) {
                    rs.idxA = strip[i].idx;
                    rs.idxB = strip[j].idx;
                    rs.dist = dt;
                }
            }
        }
        return rs;
    }

    Comparator<Point> cprtX = (o1,o2) -> Integer.compare(o1.x, o2.x);

    Comparator<Point> cprtY = (o1,o2) -> Integer.compare(o1.y, o2.y);

    double dist(Point a, Point b) {
        return Math.sqrt((a.x - b.x)*(a.x - b.x) + (a.y - b.y)*(a.y - b.y));
    }

    class Result implements Comparable<Result> {
        int idxA, idxB;
        double dist;

        public Result(int idxA, int idxB, double dist) {
            this.idxA = idxA;
            this.idxB = idxB;
            this.dist = dist;
        }

        @Override
        public int compareTo(Result o) {
            return Double.compare(dist, o.dist);
        }
    }

    class Point {
        int x, y, idx;

        public Point(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }
}