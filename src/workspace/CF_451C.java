package workspace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_451C {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int t = in.i();
        while(t-- > 0) {
            long n = in.l(), k = in.l(), d1 = in.l(), d2 = in.l();
            List<Long> rs = cal(k, d1, d2);
            String ans = "no";
            for(long l : rs) {
                if(n - k - l >= 0 && (n - k - l) % 3 == 0 && n % 3 == 0) ans = "yes";
            }
            out.println(ans);
        }
    }

    List<Long> cal(long k, long x, long y) {
        List<Long> rs = new ArrayList<>();
        long b1 = (k - x - y) / 3;
        long b2 = (k - x + y) / 3;
        long b3 = (k + x - y) / 3;
        long b4 = (k + x + y) / 3;

        if(b1 >= 0 && b1 * 3 + x + y == k) {
            long mx = max(b1+x, b1+y);
            rs.add(mx-b1-x + mx-b1 + mx-b1-y);
        }
        if(b2 >= 0 && b2 * 3 + x - y == k && b2-y >= 0) {
            long mx = b2+x;
            rs.add(mx-b2-x + mx-b2 + mx-b2+y);
        }
        if(b3 >= 0 && b3 * 3 - x + y == k && b3-x >= 0) {
            long mx = b3+y;
            rs.add(mx-b3+x + mx-b3 + mx-b3-y);
        }
        if(b4 >= 0 && b4 * 3 - x - y == k && b4-x >= 0 && b4-y >= 0) {
            long mx = b4;
            rs.add(mx-b4+x + mx-b4 + mx-b4+y);
        }
        return rs;
    }
}
