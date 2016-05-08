package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

import helperClasses.FastScanner;
import helperClasses.Util;

public class CODEJAM_2016_CoinJam {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        n = in.i(); J = in.i();

        //sieve();

        sb = new StringBuilder(n);
        sb.append('1');
        for(int i = 1; i <= n - 2; ++i)
            sb.append('0');
        sb.append('1');

        results = new ArrayList<>();
        pool = new HashSet<>();

        build(1);

//        for(String s : pool)
//            out.println(s);

        calc();
        out.printf("Case #%d:\n", testNumber);
        for(Entry e : results) {
            out.print(e.num);
            for(int i = 2; i <= 10; ++i) {
                out.print(" " + e.divisors[i]);
                BigInteger bi = new BigInteger(e.num, i);
                if(!bi.mod(e.divisors[i]).equals(zero))
                    out.println("Shit!");
            }
            out.println();
        }
    }

    Set<String> pool;
    List<Entry> results;
    StringBuilder sb;
    int n, J, lim = 5000;

    void calc() {
        boolean ok;
        BigInteger []bases = new BigInteger[11];
        for(String s : pool) {
            ok = true;
            System.out.print(s + " start ");
            for(int i = 2; i <= 10; ++i) {
                bases[i] = new BigInteger(s, i);
                System.out.print(i + " ");
                if(bases[i].isProbablePrime(1)) {
                    ok = false;
                    break; // can be a prime
                }
            }
            System.out.println("end");
            if(ok) {
                Entry e = new Entry();
                e.num = s;
                for(int i = 2; i <= 10; ++i) {
                    BigInteger bi = bases[i];
                    BigInteger d = smallestPrimeFactor(bi);
                    e.divisors[i] = d;
                }
                results.add(e);
                if(results.size() == J)
                    return;
            }
        }
    }

    BigInteger zero = BigInteger.valueOf(0);
    BigInteger one = BigInteger.valueOf(1);
    BigInteger two = BigInteger.valueOf(2);
    BigInteger three = BigInteger.valueOf(3);
    private BigInteger smallestPrimeFactor(BigInteger n) {
        if (n.mod(two).compareTo(BigInteger.ZERO) == 0)
            return two;

        BigInteger sqrt = sqrt(n).add(one);
        for (BigInteger i = three; i.compareTo(sqrt) <= 0; i = i.add(two)) {
            if (n.mod(i).compareTo(zero) == 0) {
                return i;
            }
        }
        return n;
    }

    public BigInteger sqrt(BigInteger n) {
        BigInteger a = one;
        BigInteger b = n.shiftRight(1).add(two);
        while (b.compareTo(a) >= 0) {
            BigInteger mid = a.add(b).shiftRight(1); // (a+b) >> 1
            if (mid.multiply(mid).compareTo(n) > 0)
                b = mid.subtract(one);
            else
                a = mid.add(one);
        }
        return a.subtract(one);
    }

    void build(int len) {
        if(pool.size() >= lim || len >= n - 1)
            return;
        for(int i = 0; i <= 1; ++i) {
            sb.setCharAt(len, (char)('0' + i));
            pool.add(sb.toString());
            build(len + 1);
        }
        sb.setCharAt(len, '0'); // reset
    }

    class Entry {
        String num;
        BigInteger []divisors = new BigInteger[11];
    }
}