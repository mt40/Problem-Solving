package workspace;

import java.util.Scanner;
import java.io.PrintWriter;
import helperClasses.ShortScanner;

public class SPOJ_IITKWPCB {
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        long n = in.l();

        if(n % 2 != 0)
            out.println(n / 2);
        else {
            long k = n / 2;
            if(gcd(k, n) > 1)
                out.println((k % 2 == 0) ? k - 1 : k - 2);
            else out.println(k);
        }
    }

    long gcd(long a, long b) {
        if(a == 0) return b;
        return gcd(b % a, a);
    }
}
