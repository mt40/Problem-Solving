package workspace;

import helperClasses.InputReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_NFACTOR {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int t = in.i();
        while (t-- > 0) {
            int a = in.i(), b = in.i(), n = in.i();

            int low = Collections.binarySearch(al[n], a);
            if (low < 0) low = ~low;
            int hi = Collections.binarySearch(al[n], b);
            hi = (hi < 0) ? ~hi : hi + 1;
            int ans = hi - low;
            out.println(ans);
        }
    }

    ArrayList<Integer>[] al = new ArrayList[11];

    {
        for (int i = 0; i < al.length; ++i)
            al[i] = new ArrayList<>(1024);
        sieve(1000 * 1000);
    }

    void sieve(int n) {
        int[] f = new int[n + 1];
        BitSet bs = new BitSet(n + 1);
        bs.set(2, n + 2, true);
        for (int i = 2; (i << 1) <= n; ) {
            if (bs.get(i)) {
                f[i] = 1;
                for (int j = 2 * i; j <= n; j += i) {
                    bs.set(j, false);
                    f[j]++;
                }
            }
            if (i > 2) i += 2;
            else i++;
        }

        for (int i = 1; i < f.length; ++i) {
            if (i > 1 && f[i] == 0) f[i] = 1;
            if(f[i] < al.length)
                al[f[i]].add(i);
        }
    }
}