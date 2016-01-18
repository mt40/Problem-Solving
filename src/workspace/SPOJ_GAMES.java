package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class SPOJ_GAMES {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        char []n = in.c();
        long x = 0;
        int cnt = 0;
        boolean flag = false;
        for(char c : n) {
            if(c == '.') flag = true;
            else {
                if(flag) cnt++;
                x = x * 10 + (c - '0');
            }
        }
        int mul = (int)Math.pow(10, cnt);
        long ans = mul / gcd(x, mul);
        out.println(ans);
    }

    long gcd(long a, long b) {
        if(a == 0) return b;
        return gcd(b % a, a);
    }
}
