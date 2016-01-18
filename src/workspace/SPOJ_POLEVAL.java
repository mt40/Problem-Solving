package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class SPOJ_POLEVAL {
    class ShortScanner{InputReader in;ShortScanner(InputReader in){this.in=in;}int i(){return in.nextInt();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n, t = 1;
        while((n = in.i()) > 0) {
            out.printf("Case %d:\n", t++);

            int []c = in.arr(n + 1);
            int k = in.i();
            int []x = in.arr(k);
            for(int i = 0; i < k; ++i) {
                long ans = Horner(n, c, x[i]);
                out.println(ans);
            }
        }
    }

    long Horner(int n, int []c, int x) {
        long ans = c[0];
        for(int i = 1; i <= n; ++i) {
            ans = ans * x + c[i];
        }
        return ans;
    }
}
