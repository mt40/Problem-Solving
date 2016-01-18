package workspace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_492D {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i(), x = in.i(), y = in.i();

        int cx = 0, cy = 0;
        List<String> list = new ArrayList<>();
        while(cx < x && cy < y) {
            double a = 1.0 * (cx+1) / x;
            double b = 1.0 * (cy+1) / y;
            if(Math.abs(a - b) < 1e-12) {
                list.add("Both"); list.add("Both");
                cx++; cy++;
            }
            else if(a < b) {
                list.add("Vanya");
                cx++;
            }
            else {
                list.add("Vova");
                cy++;
            }
        }

        for(int i = 0; i < n; ++i) {
            int a = in.i();
            out.println(list.get((a-1) % (x + y)));
        }
    }
}
