package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_611A {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = Integer.valueOf(in.s()); in.s(); String t = in.s();
        int ans = 0;
        if(t.charAt(0) == 'w') {
            if(n == 5 || n == 6) ans = 53;
            else ans = 52;
        }
        else {
            if(n <= 29) ans = 12;
            else if(n == 30) ans = 11;
            else ans = 7;
        }
        out.println(ans);
    }
}
