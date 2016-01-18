package workspace;

import java.util.Scanner;
import java.io.PrintWriter;
import helperClasses.ShortScanner;

public class CF_0A {
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i(), m = in.i();
        boolean []b = new boolean[m];
        for(int i = 0; i < n; ++i) {
            int k = in.i();
            for(int j = 0; j < k; ++j) {
                b[in.i() - 1] = true;
            }
        }

        boolean ok = true;
        for(int i = 0; i < m; ++i) if(!b[i]) ok = false;

        out.println(ok ? "YES" : "NO");
    }
}
