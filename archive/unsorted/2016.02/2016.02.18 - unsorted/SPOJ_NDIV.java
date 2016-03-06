package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_NDIV {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int a = in.i(), b = in.i(), n = in.i();

        int ans = 0;
        for(int i = a; i <= b; ++i) {
            if(factorize(i) == n)
                ans++;
        }

        out.println(ans);
    }

    long factorize(int x) {
        long rs = 1; // number of divisors
        for(int p : primes) {
            int cnt = 0;
            while(x % p == 0) {
                cnt++;
                x /= p;
            }
            if(cnt > 0)
                rs *= cnt + 1;
        }
        if(x > 1)
            rs *= 2;
        return rs;
    }

    static final int limit = 1000*100;
    static List<Integer> primes;
    static {
        sieve();
    }

    static void sieve() {
        BitSet b = new BitSet(limit + 1);
        b.set(2, limit + 1);
        for(int i = 3; i*i <= limit; i += 2) {
            if(!b.get(i)) continue;
            for(int j = i*i; j <= limit; j += i)
                b.set(j, false);
        }

        primes = new ArrayList<>(b.cardinality());
        primes.add(2);
        for(int i = 3; i <= limit; i += 2)
            if(b.get(i))
                primes.add(i);
    }
}