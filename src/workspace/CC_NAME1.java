package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CC_NAME1 {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        char []a = (in.s() + in.s()).toCharArray();
        int n = in.i();

        int []f = new int[26];
        for(char c : a) f[c - 'a']++;
        for(int i = 0; i < n; ++i) {
            char []b = in.c();
            for(char c : b) f[c - 'a']--;
        }

        boolean ok = true;
        for(int i : f) {
            if(i < 0) ok = false;
        }

        out.println(ok ? "YES" : "NO");
    }
}
