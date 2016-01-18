package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_364A {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int a = in.i();
        char []c = in.c();
        int n = c.length;
        int []b = new int[n];
        for(int i = 0; i < n; ++i) b[i] = c[i] - '0';

        int [][]sum = new int[n][n];
        int []f = new int[9 * n + 1];
        int zero = 0;
        for(int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                if(j > i)
                    sum[i][j] = sum[i][j - 1] + b[j];
                else
                    sum[i][j] = b[j];
                f[sum[i][j]]++;
                zero++;
            }
        }

        long ans = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = i; j < n; ++j) {
                if(sum[i][j] > 0 && a % sum[i][j] == 0 && a/sum[i][j] <= 9 * n) {
                    if (f[a / sum[i][j]] > 0)
                        ans += f[a / sum[i][j]];
                }
                else if(sum[i][j] == 0 && a == 0) {
                    ans += zero;
                }
            }
        }

        out.println(ans);
    }
}
