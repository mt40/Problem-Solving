package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_CISTFILL {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        Cistern []a = new Cistern[n];
        int max_h = 0;
        for(int i = 0; i < n; ++i) {
            a[i] = new Cistern(in.i(), in.i(), in.i(), in.i());
            max_h = Math.max(a[i].top, max_h);
        }
        int v = in.i();

        double ans = cal(a, v);
        if(ans == -1 || gt(ans, max_h))
            out.println("OVERFLOW");
        else
            out.printf("%.2f\n", ans);
    }

    double cal(Cistern []a, int v) {
        int max = inf;
        double low = 0, hi = max, mid = -1, rs = -1;
        while(low < hi) {
            mid = low + (hi - low) / 2;
            if(dEq(mid, low) || dEq(mid, hi)) break;
            double vol = volumeAt(a, mid);
            if(vol < v)
                low = mid;
            else {
                hi = mid;
                rs = mid;
            }
        }
        return rs;
    }

    double volumeAt(Cistern []a, double lv) {
        double v = 0;
        for(Cistern ai : a) {
            if(lv > ai.top)
                v += ai.vol();
            else if(lv > ai.b)
                v += (lv - ai.b)*ai.w*ai.d;
        }
        return v;
    }

    boolean gt(double a, double b) {
        double eps = 1e-7;
        return a - b >= eps;
    }

    boolean dEq(double a, double b) {
        double eps = 1e-8;
        return Math.abs(a - b) <= eps;
    }

    class Cistern {
        int b, h, w, d, top;

        public Cistern(int b, int h, int w, int d) {
            this.b = b;
            this.h = h;
            this.w = w;
            this.d = d;
            top = b + h;
        }

        int vol() {
            return h*w*d;
        }
    }
}