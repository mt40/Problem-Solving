package workspace;

import java.util.*;
import java.io.PrintWriter;

public class CF_609C {
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

        out.println(cal(a, n));
    }

    int cal(int []a, int n) {
        Arrays.sort(a);
        if(a[n-1] - a[0] == 0) return 0;
        int sum = 0;
        for(int i = 0; i < n; ++i) sum += a[i];

        int big = sum % n, small = n - big;
        int cb = 0, cs = 0;
        for(int i = 0; i < n; ++i) {
            if(a[i] == Math.ceil(sum*1.0 / n)) cb++;
            if(a[i] == sum / n) cs++;
        }
        if(cb == big && cs == small) return 0;

        int []b = new int[n];
        for(int i = 0; i < small; ++i) b[i] = sum/n;
        for(int i = small; i < big + small; ++i) b[i] = (int)Math.ceil(sum*1.0/n);

        long ans = 0;
        for(int i = 0; i < n; ++i) {
            ans += Math.abs(a[i] - b[i]);
        }
        return (int)(ans / 2);
    }
}
