package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_652A {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int h1 = in.i(), h2 = in.i();
        int a = in.i(), b = in.i();

        int days = 0, y = h1 + 8 * a;
        if(y >= h2) {
            out.println(0);
            return;
        }
        else
            y -= 12 * b;
        int prevH = -1;
        while(y < h2) {
            days++;
            y += 12 * a;
            if(y >= h2) {
//                y -= 12 * a;
//                if(y + 4 * a > h2 && days > 0)
//                    days--;
                break;
            }
            if(y <= prevH) {
                out.println(-1);
                return;
            }
            prevH = y;
            y -= 12 * b;
        }

        out.println(days);
    }
}