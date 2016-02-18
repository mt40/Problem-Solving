package workspace;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_412B {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] readArr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i(), k = in.i();
        int []a = in.readArr(n);
        Arrays.sort(a);
        for(int i = n-1; i >= 0; --i) {
            if(n-i == k) {
                out.println(a[i]);
                return;
            }
        }
    }
}
