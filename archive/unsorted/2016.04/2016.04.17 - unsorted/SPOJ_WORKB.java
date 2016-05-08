package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_WORKB {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), a = in.i(), b = in.i();
        int []events = new int[n];
        for(int i = 0; i < n; ++i)
            events[i] = in.i();

        long cost = a + b;
        for(int i = 1; i < n; ++i) {
            boolean stay = false;
            int duration = events[i] - events[i - 1];
            long stayCost = (long)b * duration;
            long travelCost = 2L * a + b;
            if(duration <= 2 || stayCost <= travelCost)
                stay = true;

            cost += stay ? stayCost : travelCost;
        }
        cost += a;

        out.printf("Case #%d: %d\n", testNumber, cost);
    }
}