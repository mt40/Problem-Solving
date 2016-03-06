package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_GSHOP {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), k = in.i();
        int []a = in.arr(n);

        int sum = 0;
        for(int ai : a)
            sum += ai;

        int ans = cal(a, n, sum, k);

        out.println(ans);
    }

    int cal(int []a, int n, int sum, int k) {
        for(int j = 0; j < n; ++j) {
            if(a[j] < 0) {
                a[j] = -a[j];
                sum += 2 * a[j];
                k--;
                if(k == 0) return sum;
            }
        }
        if((k & 1) > 0) {
            int min = Util.min(a);
            sum -= 2* min;
        }
        return sum;
    }
}