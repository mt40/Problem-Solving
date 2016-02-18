package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_523A {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int m = in.i(), n = in.i();
        char [][]a = new char[m][n];
        for(int i = 0; i < n; ++i) {
            char []line = in.c();
            for(int j = 0; j < m; ++j) {
                a[j][i] = line[j];
            }
        }

        char [][]b = new char[2*m][2*n];
        for(int i = 0; i < m; ++i) {
            char prev = a[i][0];
            int l = 0;
            lb = 0;
            for(int j = 0; j < n; ++j) {
                if(a[i][j] != prev) {
                    add(b, i, j - l, prev);
                    l = j;
                    prev = a[i][j];
                }
            }
            add(b, i, n - l, prev);
        }

        for(int i = 0; i < b.length; ++i)
            out.println(String.valueOf(b[i]));
    }

    int lb = 0;
    void add(char [][]b, int row, int len, char c) {
        for(int i = 0; i < 2 * len; ++i)
            b[2*row][lb + i] = c;
        for(int i = 0; i < 2 * len; ++i)
            b[2*row + 1][lb++] = c;
    }
}
