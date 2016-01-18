package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_279C {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i(), m = in.i();
        int []a = in.arr(n);

        int []left = new int[n], right = new int[n];
        int prev = 0;
        for(int i = 1; i < n; ++i) {
            if(a[i] < a[i - 1]) {
                for(int j = prev; j < i; ++j) right[j] = i - 1;
                prev = i;
            }
        }
        for(int j = prev; j < n; ++j) right[j] = n - 1;
        prev = 0;
        for(int i = 1; i < n; ++i) {
            if(a[i] > a[i - 1]) {
                for(int j = prev; j < i; ++j) left[j] = prev;
                prev = i;
            }
        }
        for(int j = prev; j < n; ++j) left[j] = prev;

        while(m-- > 0) {
            int l = in.i(), r = in.i();
            out.println((right[l-1] >= left[r-1]) ? "Yes" : "No");
        }
    }
}
