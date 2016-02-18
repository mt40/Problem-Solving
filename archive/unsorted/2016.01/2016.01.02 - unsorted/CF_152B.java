package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_152B {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i(), m = in.i();
        int x0 = in.i(), y0 = in.i();
        int k = in.i();
        Vec []vec = new Vec[k];
        for(int i = 0; i < k; ++i) vec[i] = new Vec(in.i(), in.i());

        long ans = 0;
        for(int i = 0; i < k; ++i) {
            Vec v = vec[i];
            int difx = (v.x >= 0) ? n - x0 : 1-x0;
            int dify = (v.y >= 0) ? m - y0 : 1-y0;
            int t = inf;
            if(v.x != 0) t = difx / v.x;
            if(v.y != 0) t = Math.min(dify / v.y, t);
            x0 += t * v.x;
            y0 += t * v.y;
            ans += t;
        }

        out.println(ans);
    }

    class Vec {
        int x, y;

        public Vec(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
