package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_MKEQUAL {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []a = in.arr(n);

        int min = a[0];
        for(int ai : a) min = Math.min(ai, min);

        long dif = 0;
        for(int ai : a) dif += ai - min;

        if(dif % n == 0)
            out.println(n);
        else
            out.println(n - 1);
    }
}