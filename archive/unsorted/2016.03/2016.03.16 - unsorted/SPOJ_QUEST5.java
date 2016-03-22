package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_QUEST5 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        Point []pts = new Point[2*n];
        for(int i= 0, j = 0; i < n; ++i) {
            pts[j++] = new Point(in.i(), i, true);
            pts[j++] = new Point(in.i() + 1, i, false);
        }
        Arrays.sort(pts);

        int ans = 0;
        boolean []nailed = new boolean[n];
        HashSet<Integer> current = new HashSet<>();
        for(Point p : pts) {
            if(!p.isStart) {
                if(nailed[p.idx]) continue;

                for(Integer toNail : current)
                    nailed[toNail] = true; // nail it!
                current.remove(p.idx);
                ans++;
            }
            else
                current.add(p.idx);
        }

        out.println(ans);
    }

    class Point implements Comparable<Point> {
        int x, idx;
        boolean isStart;

        public Point(int x, int idx, boolean isStart) {
            this.x = x;
            this.idx = idx;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(x, o.x);
        }
    }
}