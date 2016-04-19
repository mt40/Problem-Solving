package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_660B {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), m = in.i();
        Chair []left = new Chair[n];
        Chair []right = new Chair[n];
        for(int i = 0; i < n; ++i) {
            left[i] = new Chair();
            right[i] = new Chair();
        }

        for(int i = 1, j = 0; i <= m; ++j) {
            if(j == n)
                j = 0;
            left[j].add(i++);
            if(i <= m)
                right[j].add(i++);
        }

        for(int i = 0; i < n; ++i) {
            if(left[i].nonWindow > 0)
                out.print(left[i].nonWindow + " ");
            if(left[i].window > 0)
                out.print(left[i].window + " ");
            if(right[i].nonWindow > 0)
                out.print(right[i].nonWindow + " ");
            if(right[i].window > 0)
                out.print(right[i].window + " ");
        }
        out.println();
    }

    class Chair {
        int window, nonWindow;

        void add(int person) {
            if(window == 0)
                window = person;
            else
                nonWindow = person;
        }
    }
}