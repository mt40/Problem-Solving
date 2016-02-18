package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_PTIME {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int[] e = new int[n], p = sieve(n);
        for (int i = 2; i <= n; ++i) {
            int x = i;
            for (int pi : p) {
                while (x % pi == 0) {
                    e[pi]++;
                    x /= pi;
                }
            }
        }

        boolean state = false;
        for(int i = 0; i < n; ++i) {
            if(e[i] == 0) continue;
            if(state) out.print(" * ");
            out.printf("%d^%d", i, e[i]);
            state = true;
        }
        out.println();
    }

    int[] sieve(int n) {
        boolean []b = new boolean[n+1];
        Arrays.fill(b, true);
        b[0] = b[1] = false;
        for(int i = 2; 1L*i*i <= n; ++i) {
            if(!b[i]) continue;
            for(int j = i * i; j <= n; j += i)
                b[j] = false;
        }

        int cnt = 0;
        for(boolean bi : b) if(bi) cnt++;
        int []rs = new int[cnt];
        for(int i = 0, j = 0; i < b.length; ++i)
            if(b[i]) rs[j++] = i;
        return rs;
    }
}