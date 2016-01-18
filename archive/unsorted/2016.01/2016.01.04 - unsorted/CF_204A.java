package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_204A {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    long []tenPower = power(19);

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        long l = in.l(), r = in.l();
        out.println(cal(r) - cal(l - 1));
    }

    long cal(long mx) {
        if(mx < 10) return mx;
        long ten = 1, ans = 0;
        int digits = 1;
        while(ten <= mx) {
            for(int i = 1; i <= 9 && i * ten <= mx; ++i) {
                if((i + 1) * ten <= mx) {
                    if (ten == 1)
                        ans++;
                    else
                        ans += tenPower[digits - 2];
                }
                else if(Long.compareUnsigned(i * ten + i, mx) <= 0) {
                    ans += 1 + (mx/10 - i * ten/10);
                    if(i > mx % 10) ans--;
                }
            }

            ten *= 10;
            digits++;
        }
        return ans;
    }

    long[] power(int max) {
        long []rs = new long[max + 1];
        rs[0] = 1;
        for(int i = 1; i <= max; ++i)
            rs[i] = rs[i - 1] * 10;
        return rs;
    }
}
