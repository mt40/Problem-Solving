package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_371C {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        char []a = in.c();
        int nb = in.i(), ns = in.i(), nc = in.i();
        int pb = in.i(), ps = in.i(), pc = in.i();
        long r = in.l();

        int cb = 0, cs = 0, cc = 0;
        for(char c : a) {
            if(c == 'B') cb++;
            if(c == 'S') cs++;
            if(c == 'C') cc++;
        }

        long low = 0, hi = 2*(long)1e12, ans = low;
        while(low <= hi) {
            long mid = low + (hi - low) / 2;
            long cost = 0;
            if(cb > 0) cost += max(pb*(cb*mid - nb), 0);
            if(cs > 0) cost += max(ps*(cs*mid - ns), 0);
            if(cc > 0) cost += max(pc*(cc*mid - nc), 0);
            if(cost <= r) {
                ans = mid;
                low = mid + 1;
            }
            else hi = mid - 1;
        }

        out.println(ans);
    }
}
