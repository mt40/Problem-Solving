package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_448C {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i();
        int []a = in.arr(n);
        out.println(cal(a, 0, n - 1, 0));
    }

    int cal(int []a, int l, int r, int h) {
        int H = minH(a, l, r);
        int rs = H - h, state = 0, prev = l;
        for(int i = l; i <= r; ++i) {
            if(a[i] > H && state == 0) {
                state = 1;
                prev = i;
            }
            if(a[i] == H&& state == 1) {
                state = 0;
                rs += cal(a, prev, i-1, H);
            }
        }
        if(state == 1)
            rs += cal(a, prev, r, H);
        return Math.min(r - l + 1, rs);
    }

    int minH(int[]a, int l, int r) {
        int min = a[l];
        for(int i = l + 1; i <= r; ++i) min = Math.min(a[i], min);
        return min;
    }
}
