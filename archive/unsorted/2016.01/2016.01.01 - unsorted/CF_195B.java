package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_195B {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i(), m = in.i();
        int ctr = (m + 1) / 2, b = ctr;
        for(int i = 0; i < n; ++i) {
            out.println(b);
            if(m % 2 != 0) {
                if (b < ctr) b += 2 * (ctr - b);
                else if (b >= ctr) b -= 2 * (b - ctr) + 1;
            }
            else {
                if (b <= ctr) b += 2 * (ctr - b) + 1;
                else if (b > ctr) b -= 2 * (b - ctr);
            }
            if (b < 1 || b > m) b = ctr;
        }
    }
}
