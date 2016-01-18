package workspace;

import sun.awt.image.ByteComponentRaster;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_527D {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i();
        Pair []a = new Pair[n];
        for(int i = 0; i < n; ++i) a[i] = new Pair(in.i(), in.i());

        Arrays.sort(a);
        int last = 0, ans = 1;
        for(int i = 1; i < n; ++i) {
            if(a[i].x - a[i].w >= a[last].x + a[last].w) {
                last = i;
                ans++;
            }
        }

        out.println(ans);
    }

    class Pair implements Comparable<Pair> {
        int x, w;

        public Pair(int x, int w) {
            this.x = x;
            this.w = w;
        }


        @Override
        public int compareTo(Pair o) {
            return Integer.compare(x + w, o.x + o.w);
        }
    }
}
