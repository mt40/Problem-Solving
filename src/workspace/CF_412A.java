package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_412A {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i(), k = in.i();
        char []a = in.c();
        int left = k - 1, right = n - k;
        if(left <= right) {
            goLeftMost(k, out);
            out.println("PRINT " + a[0]);
            for(int i = 2; i <= n; ++i) {
                out.printf("RIGHT\nPRINT %c\n", a[i-1]);
            }
        }
        else {
            goRightMost(k, n, out);
            out.println("PRINT " + a[n-1]);
            for(int i = n - 1; i >= 1; --i) {
                out.printf("LEFT\nPRINT %c\n", a[i-1]);
            }
        }
    }

    void goLeftMost(int k, PrintWriter out) {
        while(k-- > 1) out.println("LEFT");
    }

    void goRightMost(int k, int n, PrintWriter out) {
        while(k++ < n) out.println("RIGHT");
    }
}
