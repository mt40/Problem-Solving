package workspace;

import java.util.*;
import java.io.PrintWriter;

public class LineInHashmap {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    double inf = Double.MAX_VALUE;

    /**
     * Here is a way to store a line in a map and
     * then later test if a new point belongs to which
     * line
     */
    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i();
        Point []pts = new Point[n];
        for(int i = 0; i < n; ++i) pts[i] = new Point(in.i(), in.i());

        /**
         * The idea is to use this 2d line equation:
         * A(x-x0) + B(y-y0) = 0 (with normal vector n=(A,B))
         * After expanding we have:
         * Ax + By + C = 0
         * Then represent the triplet (A, B, C) by a single hash value
         * Also, to ensure the line equation will be the same
         * regardless of the order of 2 points, make a always > 0
         * and normalize by gcd
         */

        Map<Integer, Set<Point>> map = new HashMap<>(); // number of of points of each line
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                if(i == j) continue;
                int a = pts[j].y - pts[i].y;
                int b = pts[i].x - pts[j].x;
                int c = -pts[j].x * a - pts[j].y * b;

                int g = gcd(a, b);
                a /= g; b /= g; c /= g;

                if(a < 0 || (a == 0 && b < 0)) {
                    a = -a;
                    b = -b;
                    c = -c;
                }
                int hash = 73*73*a + 73*b + c; // can use 31 as default in Java
                add(map, hash, pts[i]);
                add(map, hash, pts[j]);
            }
        }

        out.printf("Number of lines: %d\n", map.size());
        out.println("Points on the same row belongs to the same line:");
        for(Map.Entry<Integer, Set<Point>> e : map.entrySet()) {
            out.println(Arrays.toString(e.getValue().toArray()).replaceAll("[\\[\\]]", ""));
        }

    }

    int gcd(int a, int b) {
        if(a == 0) return b;
        return gcd(b % a, a);
    }

    <K, V> void add(Map<K, Set<V>> map, K key, V val) {
        if(map.containsKey(key))
            map.get(key).add(val);
        else {
            Set<V> set = new HashSet<>();
            set.add(val);
            map.put(key, set);
        }
    }

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

        @Override
        public String toString() {
            return String.format("{%d;%d}", x, y);
        }
    }
}
