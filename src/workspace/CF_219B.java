package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_219B {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] readArr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        long p = in.l(), d = in.l();
        long e = 10, t = 0, i = 0;
        while(p / e > 0) {
            long c = letter(p, i++);
            if(c != 9) {
                long dif = (c + 1) * (e/10);
                t += dif;
                if (t <= d) {
                    p -= dif;
                }
                else break;
            }
            e *= 10;
        }

        out.println(p);
    }

    long letter(long x, long p) {
        while(p-- > 0) {
            x /= 10;
        }
        return x % 10;
    }
}
