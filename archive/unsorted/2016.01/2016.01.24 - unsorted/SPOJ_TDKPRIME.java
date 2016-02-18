package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_TDKPRIME {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = 100 * 1000 * 1000;
        int []p = sieve(n);
        //ArrayList<Integer> p = segSieve(n);
        int q = in.i();
        while(q-- > 0) {
            int x = in.i();
            out.println(p[x]);
        }
    }

    int[] sieve(int n) {
        BitSet b = new BitSet(n + 1);
        b.set(2, n+1);
        for (int i = 3; 1L * i * i <= n; i += 2) {
            if (!b.get(i)) continue;
            if (1L * i * i <= n) {
                for (int j = i * i; j <= n; j += (i << 1)) // skip even multiple
                    b.set(j, false);
            }
        }

        int size = 1;
        for(int i = 3; i <= n; i += 2)
            if(b.get(i)) size++;

        int[] rs = new int[size + 1];
        rs[1] = 2;
        for (int i = 3, j = 2; i <= n; i += 2) {
            if(b.get(i))
                rs[j++] = i;
        }

        return rs;
    }
}