package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import helperClasses.FastScanner;
import helperClasses.Util;

/**
 * Bitmask to find subsets and apply
 * inclusion-exclusion priciple
 */
public class SPOJ_NGM2 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), k = in.i();
        int []a = in.arr(k);

        int lim = 1 << k;
        long subtract = 0;
        for(int mask = 1; mask < lim; ++mask) {
            long lcm = 1, cnt = 0;
            for(int i = 0; i < k; ++i) {
                int d = mask & (1 << i);
                if(d > 0) {
                    lcm = lcm(a[i], lcm);
                    cnt++;
                }
            }

            if((cnt & 1) > 0)
                subtract += n / lcm;
            else
                subtract -= n / lcm;
        }
        long ans = n - subtract;
        out.println(ans);
    }

    long lcm(long a, long b) {
        return a / gcd(a, b) * b; // avoid overflow
    }

    long gcd(long a, long b) {
        if(a == 0)
            return b;
        return gcd(b % a, a);
    }
}