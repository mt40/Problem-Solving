package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_628C {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), k = in.i();
        char []a = in.c();

        char []ans = new char[n];
        for(int i = 0; i < n; ++i) {
            char c = a[i], d;
            int left = c - 'a', right = 'z' - c;
            if(left >= right)
                d = (char)(c - Math.min(left, k));
            else
                d = (char)(c + Math.min(right, k));
            k -= dist(d, c);
            ans[i] = d;
        }

        if(k == 0)
            out.println(String.valueOf(ans));
        else
            out.println(-1);
    }

    int dist(char x, char y) {
        return Math.abs(x - y);
    }
}