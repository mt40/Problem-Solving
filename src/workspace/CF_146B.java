package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_146B {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int a = in.i() + 1, b = in.i();

        while(true) {
            int m = mask(a);
            if(m == b) {
                out.println(a);
                return;
            }
            a++;
        }
    }

    int mask(int x) {
        int rs = 0, e = 1;
        while(x > 0) {
            int d = x % 10;
            if(d == 4 || d == 7) {
                rs += d * e;
                e *= 10;
            }
            x /= 10;
        }
        return rs;
    }
}
