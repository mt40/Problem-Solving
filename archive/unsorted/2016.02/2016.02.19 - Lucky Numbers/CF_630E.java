package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_630E {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        long x1 = in.i(), y1 = in.i(), x2 = in.i(), y2 = in.i();
        long tx2 = x2, ty2 = y2;
        if(odd(x2)) x2++;
        if(odd(y2)) y2++;
        long h = (y2-y1) / 2;
        if(odd(y1) && odd(x1)) h++;
        long w = (x2-x1) / 2;
        if(odd(x1) && odd(y1)) w++;

        long hx1 = h-1;
        if(x1 < x2) {
            if(odd(ty2)) hx1 = h - 1;
            else hx1 = h;
            if(!odd(y1)) hx1++;
        }

        long rem = tx2-x1+1 - w;
        long ans = w*h + rem*hx1;
        out.println(ans);
    }

    boolean odd(long x) {
        return (x&1) > 0;
    }
}