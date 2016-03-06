package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_OAE {
    int inf = Integer.MAX_VALUE;
    final int mod = 314159;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);

        int lim = 1000*1000;
        int []even = new int[lim+1], odd = new int[lim+1];
        even[1] = 9; // 1,2,...,9
        odd[1] = 1; // 0
        for(int i = 2; i <= lim; ++i) {
            even[i] = ((even[i-1] * 9) % mod + odd[i-1]) % mod;
            odd[i] = ((odd[i-1] * 9) % mod + even[i-1]) % mod;
        }

        int t = in.i();
        while(t-- > 0) {
            int n = in.i();
            out.println(even[n]);
        }
    }
}