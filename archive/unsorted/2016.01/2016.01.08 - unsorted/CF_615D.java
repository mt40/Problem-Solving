package workspace;

import java.util.Scanner;
import java.io.PrintWriter;
import helperClasses.ShortScanner;

public class CF_615D {
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int mod = 1000*1000*1000+7;
        int m = in.i();
        int []a = in.arr(m);

        long ans = 1;
        for(int i : a) {
            long p = pow(i, m - 1, mod);
            ans = (ans * p) % mod;
        }

        out.println(ans);
    }

    long pow(int x, int e, int mod) {
        while(e-- > 0) {
            x = (x * x + mod) % mod;
        }
        return x % mod;
    }
}
