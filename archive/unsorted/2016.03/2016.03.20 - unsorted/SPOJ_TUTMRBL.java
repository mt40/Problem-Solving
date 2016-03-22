package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_TUTMRBL {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n;
        while((n = in.i()) > 0) {
            boolean flag = false;
            int cnt = 1, oldN = n;
            out.printf("%d =", n);
            int sqrt = (int)Math.sqrt(n) + 1;
            for(int p : primes) {
                if(p > sqrt || n <= 1) break;
                int factors = 0;
                while(n % p == 0) {
                    n /= p;

                    if(flag)
                        out.printf(" * %d", p);
                    else {
                        flag = true;
                        out.printf(" %d", p);
                    }
                    factors++;
                }
                if(factors > 0) cnt *= factors + 1;
            }
            if(n > 1) {
                cnt *= 2;
                if(flag)
                    out.printf(" * %d", n);
                else
                    out.printf(" %d", n);
            }
            out.println();
            out.printf("With %d marbles, %d different rectangles can be constructed.\n",
                    oldN, isPerfectSquare(oldN) ? cnt/2+1 : cnt/2);
        }
    }

    boolean isPerfectSquare(int x) {
        int sqrt = (int)Math.sqrt(x);
        return sqrt*sqrt == x;
    }

    static List<Integer> primes;
    static {
        sieve(1000*1000*10);
    }

    static void sieve(int limit) {
        BitSet bs = new BitSet(limit);
        bs.set(2, limit + 1, true);
        for(int i = 3; i*i <= limit; i += 2) {
            if(!bs.get(i)) continue;
            for(int j = i*i; j <= limit; j += i)
                bs.set(j, false);
        }

        primes = new ArrayList<>(bs.cardinality());
        primes.add(2);
        for(int i = 3; i <= limit; i += 2) {
            if(bs.get(i))
                primes.add(i);
        }
    }
}