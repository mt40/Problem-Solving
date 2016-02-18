package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_POSTERS {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        EndPoint []b = new EndPoint[2*n];
        for(int i = 0, j = 0; i < n; ++i) {
            int x1 = in.i(), x2 = in.i();
            b[j++] = new EndPoint(x1, i);
            b[j++] = new EndPoint(x2 + 1, i, true);
        }

        Arrays.sort(b, (p1, p2) -> Integer.compare(p1.a, p2.a));
        PriorityQueue<Integer> heap = new PriorityQueue<>(n, Collections.reverseOrder());
        boolean []vst = new boolean[n];
        int ans = 0;

        int cur_x = b[0].a;
        for (int i = 0; i < b.length; ++i) {
            int x = b[i].a;
            if (cur_x < x) {
                if (heap.size() > 0) {
                    int seg = heap.peek();
                    boolean ok = vst[seg] == false;
                    if (ok) {
                        ans++;
                        vst[seg] = true;
                    }
                }
                cur_x = x;
            }
            if (b[i].isEnd)
                heap.remove(b[i].h);
            else
                heap.add(b[i].h);
        }

        out.println(ans);
    }

    class EndPoint {
        int a, h;
        boolean isEnd = false;

        public EndPoint(int a, int h) {
            this.a = a;
            this.h = h;
        }

        public EndPoint(int a, int h, boolean isEnd) {
            this.a = a;
            this.h = h;
            this.isEnd = isEnd;
        }
    }
}