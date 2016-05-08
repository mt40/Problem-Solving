package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.*;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_ODDDIV {
    int inf = Integer.MAX_VALUE;
    long lim = 1000*1000*1000*10L;
    List<Long> perfect = new ArrayList<>();
    List<Integer> sieve = new ArrayList<>();
    Map<Long, List<Integer>> mapFactors = new HashMap<>();

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);

        buildSieve();
        preprocess();
        build();

        int tests = in.i();
        while(tests-- > 0) {
            int k = in.i();
            long low = in.l(), hi = in.l();

            int left = find(low, false);
            int right = find(hi, true);

            int cnt = 0;
            for(int i = left; i <= right; ++i) {
                long num = perfect.get(i);
                long divisors = countDivisors(mapFactors.get(num));
                if(divisors == k) {
                    //System.out.println("Checked " + num);
                    cnt++;
                }
            }

            out.println(cnt);
        }
    }

    int find(long key, boolean isRight) {
        int idx = Collections.binarySearch(perfect, key);
        if(idx < 0) {
            idx = ~idx;
            if(isRight) idx--;
        }
        return idx;
    }

    long countDivisors(List<Integer> factorPower) {
        long rs = 1;
        for(int pi : factorPower)
            rs *= (pi + 1);
        return rs;
    }

    List<Integer> getFactorPower(long x) {
        List<Integer> powers = new ArrayList<>(15);
        for(int p : sieve) {
            if(p > x) break;
            int cnt = 0;
            while(x % p == 0) {
                x /= p;
                cnt++;
            }
            if(cnt > 0)
                powers.add(cnt);
        }
        return powers;
    }

    void preprocess() {
        int n = 1000*100;
        for(long i = 1; i <= n; ++i)
            mapFactors.put(i, getFactorPower(i));
    }

    void buildSieve() {
        int n = 1000*1000*10;
        BitSet bs = new BitSet(n + 1);
        bs.set(2, n + 2);
        for(int i = 3; i * i <= n; i += 2) {
            if(!bs.get(i)) continue;
            for(int j = i * i; j <= n; j += i)
                bs.set(j, false);
        }

        sieve.add(2);
        for(int i = 3; i <= n; i += 2)
            if(bs.get(i))
                sieve.add(i);
    }

    void build() {
        for(long i = 1; i * i < lim; ++i) {
            long sqr = i * i;
            perfect.add(sqr);
            List<Integer> powers;
            if(mapFactors.containsKey(sqr))
                powers = mapFactors.get(sqr);
            else
                powers = mergeDivisors(mapFactors.get(i));
            mapFactors.put(sqr, powers);
        }
    }

    List<Integer> mergeDivisors(List<Integer> factors) {
        List<Integer> merged = new ArrayList<>(factors.size());
        for(int fi : factors)
            merged.add(2 * fi);
        return merged;
    }
}