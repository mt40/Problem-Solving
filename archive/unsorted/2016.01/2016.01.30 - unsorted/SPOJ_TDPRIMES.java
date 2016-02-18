package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.BitSet;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_TDPRIMES {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = 1000 * 1000 * 100;

        BitSet bs = new BitSet(n);
        bs.set(2, n + 1);
        for(int i = 3; 1L*i*i <= n; i += 2) {
            if(!bs.get(i)) continue;
            if(1L*i*i <= n) {
                int inc = i << 1;
                for(int j = i*i; j <= n; j += inc) {
                    bs.set(j, false);
                }
            }
        }

        int size = 1;
        for(int i = 3; i <= n; i += 2)
            if(bs.get(i)) size++;

        int []primes = new int[size];
        primes[0] = 2;
        for(int i = 3, j = 1; i <= n; i += 2)
            if(bs.get(i))
                primes[j++] = i;

        for(int i = 0; i < size; i += 100)
            out.println(primes[i]);
    }
}