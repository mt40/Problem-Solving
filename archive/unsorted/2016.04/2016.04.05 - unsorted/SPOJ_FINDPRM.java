package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.BitSet;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_FINDPRM {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        sieve();
        int tests = in.i();
        while(tests-- > 0) {
            int n = in.i();

            int ans = 0;
            for(int pi : primes) {
                if(pi > n) break;
                if(pi * 2 > n)
                    ans++;
            }

            out.println(ans);
        }
    }

    int []primes;

    void sieve() {
        int limit = 1000 * 1000 * 10 + 1;
        BitSet bs = new BitSet(limit);
        bs.set(0, limit);
        for(int i = 3; i * i < limit; i += 2) {
            if(!bs.get(i)) continue;
            for(int j = i * i ; j < limit; j += i)
                bs.set(j, false);
        }

        int []tmp = new int[bs.cardinality()];
        int idx = 0;
        tmp[idx++] = 2;
        for(int i = 3; i < limit; i += 2) {
            if(bs.get(i))
                tmp[idx++] = i;
        }

        primes = Arrays.copyOf(tmp, idx);
    }
}