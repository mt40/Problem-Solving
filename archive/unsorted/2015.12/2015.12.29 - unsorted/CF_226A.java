package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_226A {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i(), m = in.i();
        long ans = (((3%m) * (exp(3, n-1, m) - 1) % m) % m + 2%m)%m;
        out.println((ans + m) % m); // avoid negative result
    }

    long exp(long x, int e, int m) {
        long rs = 1;
        while(e > 0) {
            if(e % 2 > 0) {
                rs = (rs % m * (x % m)) % m;
            }
            x = (x*x) % m;
            e >>= 1;
        }
        return (long)(rs % m);
    }
}
