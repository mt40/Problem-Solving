package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_505C {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i(), d = in.i(), m = 30001;
        int []a = new int[m];
        for(int i = 0; i < n; ++i) a[in.i()]++;

        boolean [][]visit = new boolean[m][500];
        int [][]dp = new int[m][500];
        dp[d][250] = a[d];
        visit[d][250] = true;
        int ans = dp[d][250];
        for(int i = d; i < m; ++i) {
            for(int j = 0; j < 500; ++j) {
                if(visit[i][j]) {
                    int len = d + j - 250;
                    if(len - 1 > 0 && i + len - 1 < m) {
                        dp[i + len - 1][j - 1] = Math.max(dp[i][j] + a[i + len - 1], dp[i + len - 1][j - 1]);
                        visit[i + len - 1][j - 1] = true;
                    }
                    if(i + len < m) {
                        dp[i + len][j] = Math.max(dp[i][j] + a[i + len], dp[i + len][j]);
                        visit[i + len][j] = true;
                    }
                    if(i + len + 1 < m) {
                        dp[i + len + 1][j + 1] = Math.max(dp[i][j] + a[i + len + 1], dp[i + len + 1][j + 1]);
                        visit[i + len + 1][j + 1] = true;
                    }
                    ans = Math.max(dp[i][j], ans);
                }
            }
        }

        out.println(ans);
    }
}
