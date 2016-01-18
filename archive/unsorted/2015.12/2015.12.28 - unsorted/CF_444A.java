package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_444A {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i(), m = in.i();
        int []a = new int[n+1];
        for(int i = 1; i <= n; ++i) a[i] = in.i();
        int [][]g = new int[n+1][n+1];
        for(int i = 0; i < m; ++i) {
            int x = in.i(), y = in.i(), c = in.i();
            g[x][y] = g[y][x] = c;
        }

        double max = 0;
        //for(int i = 1; i <= n; ++i) max = Math.max(a[i], max);

        for(int i = 1; i <= n; ++i) {
            for(int j = 1; j <= n; ++j) {
                if(g[i][j] == 0) continue;
                max = Math.max(1.0*(a[i] + a[j]) / g[i][j], max);
            }
        }

        out.printf("%.15f\n", max);
    }
}
