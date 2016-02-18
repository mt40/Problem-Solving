package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_CPRIME {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n;
        while((n = in.i()) > 0) {
            int id = Collections.binarySearch(primes, n);
            int pi;
            if(id >= 0) pi = id + 1;
            else pi = ~id;

            double ans = Math.abs(pi - 1.0*n/Math.log(n))/pi * 100;
            out.printf("%.1f\n", ans);
        }
    }

    static final int lim = 1000*1000*100;
    static ArrayList<Integer> primes;
    static {
        sieve();
    }

    static void sieve() {
        BitSet b = new BitSet(lim+1);
        b.set(2, lim+1);
        for(int i = 3; 1L*i*i <= lim; i += 2) {
            if(!b.get(i)) continue;
            for(int j = i*i; j <= lim; j += i)
                b.set(j, false);
        }

        primes = new ArrayList<>(10*000*1000);
        primes.add(2);
        for(int i = 3; i <= lim; i += 2)
            if(b.get(i))
                primes.add(i);
    }
}