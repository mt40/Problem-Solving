package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_BWIDOW {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        Ring []a = new Ring[n];
        for(int i = 0; i < n; ++i) a[i] = new Ring(in.i(), in.i(), i + 1);

        Arrays.sort(a);
        boolean ok = true;
        for(int i = 1; i < n; ++i) {
            if(a[i].outer > a[0].inner) ok = false;
        }

        out.println(ok ? a[0].id : -1);
    }

    class Ring implements Comparable<Ring> {
        int inner, outer, id;

        public Ring(int inner, int outer, int id) {
            this.inner = inner;
            this.outer = outer;
            this.id = id;
        }

        @Override
        public int compareTo(Ring o) {
            return Integer.compare(o.inner, inner);
        }
    }
}