package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;

public class CF_297B {
    class ShortScanner{InputReader in;ShortScanner(InputReader in){this.in=in;}int i(){return in.nextInt();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i(), m = in.i(), k = in.i();
        Integer []a = new Integer[n], b = new Integer[m];
        for(int i = 0; i < n; ++i) a[i] = in.i();
        for(int i = 0; i < m; ++i) b[i] = in.i();
        boolean ok = false;
        if(n > m) ok = true;
        else {
            Arrays.sort(a, Collections.reverseOrder());
            Arrays.sort(b, Collections.reverseOrder());
            for(int i = n - 1; i >= 0; --i) {
                if(a[i] > b[i]) ok = true;
            }
        }

        out.println(ok ? "YES" : "NO");
    }
}
