package workspace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_588B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        long n = in.nextLong();
        List<Long> primes = primeFactors(n);

        long ans = 1;
        for(long p : primes)
            ans *= p;
        out.println(ans);
    }

    List<Long> primeFactors(long n) {
        List<Long> rs = new ArrayList<Long>();
        rs.add(1l);
        double sqrt = Math.sqrt(n);
        for(int i = 2; i <= sqrt; ++i) {
            if(n % i == 0) {
                rs.add((long)i);
                while(n % i == 0)
                    n /= i;
            }
        }

        // if n is itself a prime
        if(n >= 2)
            rs.add(n);
        return rs;
    }
}
