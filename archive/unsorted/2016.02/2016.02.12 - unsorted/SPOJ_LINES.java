package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.HashSet;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_LINES {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n;
        while((n = in.i()) > 0) {
            Pair[] p = new Pair[n];
            for (int i = 0; i < n; ++i)
                p[i] = new Pair(in.i(), in.i());

            HashSet<Pair> set = new HashSet<>();
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (i == j) continue;

                    int dx = p[j].dx - p[i].dx;
                    int dy = p[j].dy - p[i].dy;

                    if (dx < 0) {
                        dx = -dx;
                        dy = -dy;
                    }
                    int g = gcd(dx, dy);
                    dx /= g;
                    dy /= g;

                    Pair slope = new Pair(dx, dy);

                    if (!set.contains(slope))
                        set.add(slope);
                }
            }

            out.println(set.size());
        }
    }

    int gcd(int a, int b) {
        if(a == 0) return b;
        return gcd(b % a, a);
    }

    class Pair {
        int dx, dy;

        public Pair(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (dx != pair.dx) return false;
            return dy == pair.dy;

        }

        @Override
        public int hashCode() {
            return 73*dx + dy;
        }
    }
}