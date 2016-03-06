package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_DIV {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        int n = 1000*1000;
        divisors = new long[n + 1];
        primes = new TreeSet<>();
        good = new HashSet<>();
        bad = new HashSet<>();
        sieve(n);

        StringBuilder sb = new StringBuilder();
        int nine = 0;
        for(int i = 2; i <= n; ++i) {
            if(check(divisors[i])) {
                nine++;
                if(nine == 9) {
                    if(sb.length() > 0)
                        sb.append('\n');
                    sb.append(i);
                    nine = 0;
                }
            }
        }

        out.print(sb);
    }

    TreeSet<Integer> primes;
    HashSet<Long> good, bad;

    boolean check(long x) {
        long ori = x;
        if(good.contains(x)) return true;
        if(bad.contains(x)) return false;

        int cnt = 0;
        int []fac = new int[10];
        boolean ok = true;
        for(int p : primes) {
            if(p > x) break;
            int f = 0;
            while(x % p == 0) {
                f++;
                x /= p;
            }
            if(f > 0) {
                if(cnt > 1 || f > 1) {
                    ok = false;
                    break;
                }
                fac[cnt++] = f;
            }
        }
        ok = ok && cnt == 2 && fac[0] == fac[1] && fac[1] == 1;
        if(ok) good.add(ori);
        else bad.add(ori);

        return ok;
    }

    long []divisors;

    void sieve(int n) {
        boolean []b = new boolean[n + 1];
        Arrays.fill(b, 2, n + 1, true);
        primes.add(2);

        for(int i = 3; i*i <= n; i += 2) {
            if(!b[i]) continue;
            for(int j = i * i; j <= n; j += i)
                b[j] = false;
        }

        for(int i = 3; i <= n; i += 2)
            if(b[i]) primes.add(i);

        // Count divisors
        Arrays.fill(divisors, 1);
        for(int i = 2; i <= n; ++i) {
            for(int j = i; j <= n; j += i)
                divisors[j]++;
        }
    }
}