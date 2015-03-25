package workspace;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.PrintWriter;

public class EulerPhi {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        // list of primes from 0 ... sqrt(n)
        LinkedList<Long> primes = sieve((long)Math.sqrt(n) + 1);

        out.println(EulerPhi(n, primes));
    }

    /**
     * Formula: phi(n) = n * tích (1 - 1/p)
     * voi p la tat ca thua so nguyen to khac nhau cua n
     */
    public long EulerPhi(long n, LinkedList<Long> primes) {
        int p_id = 0;
        long ans = n; // start from n
        long p = primes.get(p_id);
        while(n != 1 && p * p <= n
                && p_id < primes.size() - 1) {
            if(n % p == 0)
                ans = ans - ans / p;
            while(n % p == 0)
                n /= p;
            p = primes.get(++p_id);
        }

        // if n is prime
        if(n != 1) ans = ans - ans / n;
        return ans;
    }

    // generate list of prime numbers <= n
    public LinkedList<Long> sieve(Long n) {
        long []num = new long[n.intValue() + 1];
        LinkedList<Long> rs = new LinkedList<Long>();

        for(int i = 2; i <= n; ++i) {
            if(num[i] == 0) {
                rs.add((long) i);

                int f = 2;
                while(i * f <= n) {
                    num[i * f] = 1; // mark all multiples
                    f++;
                }
            }
        }
        return rs;
    }
}
