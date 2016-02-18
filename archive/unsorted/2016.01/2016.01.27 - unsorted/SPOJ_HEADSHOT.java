package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_HEADSHOT {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        char []a = in.c();
        int n = a.length;

        int x = 0, y = 0;
        for(int i = 0; i < n; ++i) {
            if(a[i] == '0' && a[(i + 1) % n] == '1')
                x++;
            if(a[i] == '0' && a[(i + 1) % n] == '0')
                y++;
        }

        boolean allZero = true;
        for(int i = 0; i < n; ++i) if(a[i] == '1') allZero = false;
        if(allZero)
            out.println("EQUAL");
        else {
            if (x == y) out.println("EQUAL");
            else if (x > y) out.println("ROTATE");
            else out.println("SHOOT");
        }
    }
}