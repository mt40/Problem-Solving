package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_658A {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), c =in.i();
        int []score = in.arr(n);
        int []time = in.arr(n);

        int time1 = 0, time2 = 0;
        int limak = 0, rade = 0;
        for(int i = 0; i < n; ++i) {
            time1 += time[i];
            limak += Math.max(0, score[i] - c * time1);
        }
        for(int i = n - 1; i >= 0; --i) {
            time2 += time[i];
            rade += Math.max(0, score[i] - c * time2);
        }

        if(limak == rade)
            out.println("Tie");
        else if(limak > rade)
            out.println("Limak");
        else
            out.println("Radewoosh");
    }
}