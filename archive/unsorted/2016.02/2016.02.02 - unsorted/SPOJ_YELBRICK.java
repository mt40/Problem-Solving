package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_YELBRICK {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n;
        while((n = in.i()) > 0) {
            Rec []a = new Rec[n];
            for(int i = 0; i < n; ++i) a[i] = new Rec(in.i(), in.i(), in.i());

            int min = a[0].a;
            for(Rec ai : a) min = Util.min(ai.a, ai.b, ai.c, min);

            long ans = 0;
            for(Rec ai : a) ans += ai.count(min);

            out.println(ans);
        }
    }

    class Rec {
        int a, b, c;

        public Rec(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        int count(int cube) {
            return (a/cube) * (b/cube) * (c/cube);
        }
    }
}