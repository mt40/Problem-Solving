package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_WTK {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        //int ans = cal(n, 1);
        int ans = 1;
        for(int i = 2, k = n - 1; i <= n; ++i, --k)
            ans = (ans + k - 1) % i + 1;
        out.println(ans);
    }

    // too slow to pass :(
    int cal(int n, int k) {
        if(n == 1) return 1;
        return (cal(n - 1, k + 1) + k-1) % n + 1;
    }
}