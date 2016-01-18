package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class SieveOfEratosthenes {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);

        int n = in.i();
        boolean []prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false; // 0 & 1 are not primes

        /* We only need consider up to i*i because of the inner 'if'
        But anyway, all divisors are considered before we reach i*i
        so larger than that, there are only primes left.*/
        for(int i = 2; i * i <= n; ++i) {
            if(prime[i]) {
                /* we consider from i*i because i*2,i*3,...,i*(i-1)
                is already considered before */
                if(1L * i * i <= n) {
                    for(int j = i * i; j <= n; j += i) {
                        prime[j] = false;
                    }
                }
            }
        }

        int cnt = 0;
        for(boolean b : prime) cnt += b ? 1 : 0;
        out.println("Number of primes: " + cnt);
        for(int i = 0; i < prime.length; ++i) {
            if(prime[i])
                out.print(i + " ");
        }
        out.println();
    }
}
