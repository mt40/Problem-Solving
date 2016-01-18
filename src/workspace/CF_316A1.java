package workspace;

import java.math.BigInteger;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_316A1 {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        char []a = in.c();

        int cnt = 0;
        int []f = new int[11];
        boolean []visit = new boolean[26];
        for(int i = 0; i < a.length; ++i) {
            if(a[i] == '?')
                f[(i == 0) ? 9 : 10]++;
            else if(Character.isLetter(a[i]) && !visit[a[i] - 'A']) {
                f[(i == 0) ? 9 - cnt : 10 - cnt]++;
                cnt++;
                visit[a[i] - 'A'] = true;
            }
        }

        BigInteger ans = BigInteger.ONE;
        for(int i = 1; i <= 10; ++i) {
            ans = ans.multiply(BigInteger.valueOf(i).pow(f[i]));
        }

        out.println(ans);
    }
}
