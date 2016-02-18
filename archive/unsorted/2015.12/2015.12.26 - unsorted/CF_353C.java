package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_353C {
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
        char []c = in.c();

        int []cul = new int[n];
        cul[0] = a[0];
        for(int i = 1; i < n; ++i) cul[i] = a[i] + cul[i - 1];

        int ans = 0;
        for(int i = 0; i < n; ++i)
            if(c[i] == '1')
                ans += a[i];

        int right = 0;
        for(int i = n - 1; i >= 0; --i) {
            if(c[i] == '1') {
                if(i > 0)
                    ans = Math.max(right + cul[i - 1], ans);
                right += a[i];
            }
        }

        out.println(ans);
    }
}
