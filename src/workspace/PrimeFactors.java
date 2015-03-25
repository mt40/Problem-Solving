package workspace;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.PrintWriter;

public class PrimeFactors {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        long n = in.nextLong();
        // we only need prime <= sqrt(n)
        LinkedList<Long> primes = sieve((long)Math.sqrt(n) + 1);

        LinkedList<Long> factors = new LinkedList<Long>();
        int p_id = 0;
        long p = primes.get(p_id);
        // loop until n <= 1 and p <= sqrt(n)
        while(n > 1 && p * p <= n
                && p_id < primes.size() - 1) {
            if(n % p == 0) {
                factors.add(p);
                while (n % p == 0)
                    n /= p;
            }
            p = primes.get(++p_id);
        }

        // in case n is prime
        if(n != 1)
            factors.add(n);

        for(int i = 0; i < factors.size(); ++i)
            out.print(factors.get(i) + " ");
        out.println();
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
