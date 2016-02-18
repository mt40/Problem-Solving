package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_141B {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int a = in.i(), x = in.i(), y = in.i();

        out.println(cal(a, x, y));
    }

    double e = 1e-7;
    int cal(int a, int x, int y) {
        int k = y / a;
        if(k * a == y) return -1;
        int t = (k % 2 > 0 || k == 0) ? 1 : 2;

        int id = k + (k/2);
        if(k % 2 > 0 || k == 0) id++;

        double half = a / 2.0;
        if(t == 1) {
            if(less(x, -half) || more(x, half))
                return -1;
            return id;
        }
        else {
            if(less(x, -a) || more(x, a) || x == 0)
                return -1;
            return (x < 0) ? id : id + 1;
        }
    }

    boolean less(double a, double b) {
        return a < b || Math.abs(a - b) <= e;
    }

    boolean more(double a, double b) {
        return a > b || Math.abs(a - b) <= e;
    }
}
