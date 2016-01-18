package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_466B {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);

        long n = in.i();
        long A = in.i();
        long B = in.i();

        long a = Math.min(A, B);
        long b = Math.max(A, B);

        if(a * b >= 6 * n) {
            out.printf("%d\n%d %d\n", a * b, a, b);
        }
        else {
            long ans = Long.MAX_VALUE;
            long sqrt = (long)Math.ceil(Math.sqrt(6 * n));
            for (long i = a; i <= sqrt; ++i) {
                long j = (long)Math.floor(6 * n * 1.0 / i);
                if(i * j < 6 * n)
                    j = (long)Math.ceil(6 * n * 1.0 / i);
                if(i * j >= 6 * n && i * j < ans && j >= Math.max(A, B)) {
                    ans = i * j;
                    a = i;
                    b = j;
                }
            }

            if(a < A)
                out.printf("%d\n%d %d\n", ans, b, a);
            else
                out.printf("%d\n%d %d\n", ans, a, b);
        }
    }
}
