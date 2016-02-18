package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_IITKWPCN {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int w = in.i(), b = in.i();
        // this problem exactly reflects the property of XOR
        // if there is 1 and the others are 0, answer is 1
        // because 1 xor 0 = 1 so 1 will eats all 0
        // but if there are odd 1s in the others elements then
        // the first 1 will be eaten because 1 xor 1 = 0
        double ans;
        if(b == 0) ans = 0;
        else {
            int x = b - 1;
            if(x % 2 == 0) ans = 1;
            else ans = 0;
        }

        out.printf("%.6f\n", ans);
    }
}