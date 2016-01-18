package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_612A {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i(), p = in.i(), q = in.i();
        String s = in.s();
        for(int i = 0; i * p <= n; ++i) {
            int k = (n - i * p) / q;
            if(k * q + i * p == n) {
                out.println(i + k);
                for(int j = 0; j < i; ++j)
                    out.println(s.substring(p * j, p * j + p));
                for (int j = 0; j < k; ++j)
                    out.println(s.substring(i*p + q*j, i*p + q*j + q));
                return;
            }
        }
        out.println(-1);
    }
}
