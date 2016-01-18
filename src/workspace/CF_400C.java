package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_400C {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i(), m = in.i(), x = in.i(), y = in.i(), z = in.i(), p = in.i();
        Pair []pairs = new Pair[p];
        for(int i = 0; i < p; ++i) pairs[i] = new Pair(in.i() - 1, in.i() - 1);

        int xt = x % 4, yt = y % 2, zt = z % 4;
        for(int i = 0; i < p; ++i) {
            int nn = n, mm = m;
            if(cw(pairs[i], xt, nn - 1, mm - 1)) {
                int tmp = nn;
                nn = mm; mm = tmp;
            }
            flip(pairs[i], yt, nn - 1, mm - 1);
            ccw(pairs[i], zt, nn - 1, mm - 1);
            out.printf("%d %d\n", pairs[i].a + 1, pairs[i].b + 1);
        }
    }

    void flip(Pair p, int t, int n, int m) {
        if(t == 0) return;
        p.b = m - p.b;
    }

    boolean cw(Pair p, int t, int n, int m) {
        if(t == 0) return false;
        if(t == 1) {
            int tmp = p.a;
            p.a = p.b;
            p.b = n - tmp;
            return true; // swap width and height
        }
        if(t == 2) {
            p.a = n - p.a;
            p.b = m - p.b;
            return false;
        }
        else {
            int tmp = p.a;
            p.a = m - p.b;
            p.b = tmp;
            return true;
        }
    }

    boolean ccw(Pair p, int t, int n, int m) {
        if(t == 0) return false;
        if(t == 3) {
            int tmp = p.a;
            p.a = p.b;
            p.b = n - tmp;
            return true;
        }
        if(t == 2) {
            p.a = n - p.a;
            p.b = m - p.b;
            return false;
        }
        else {
            int tmp = p.a;
            p.a = m - p.b;
            p.b = tmp;
            return true;
        }
    }

    class Pair {
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
