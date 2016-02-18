package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class CF_295B {
    class ShortScanner{InputReader in;ShortScanner(InputReader in){this.in=in;}int i(){return in.nextInt();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i();
        int [][]g = new int[n][n];
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < n; ++j)
                g[i][j] = in.i();

        int []a = new int[n];
        for(int i = n - 1; i >= 0; --i) a[i] = in.i() - 1;

        //Floyd Warshall
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; ++i) Arrays.fill(dist[i], inf);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j) dist[i][j] = 0;
                else
                    dist[i][j] = g[i][j];
            }
        }

        long[] ans = new long[n];
        boolean []visit = new boolean[n];
        for(int kk = 0; kk < n; ++kk) {
            int k = a[kk];
            visit[k] = true;
            long sum = 0;
            for(int i = 0; i < n; ++i) {
                for(int j = 0; j < n; ++j) {
                    if(j == i) continue;
                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                    if(!visit[i] || !visit[j]) continue;
                    sum += (dist[i][j] != inf) ? dist[i][j] : 0;
                }
            }
            ans[n - 1 - kk] = sum;
        }

        for(long l : ans) out.print(l + " ");
        out.println();
    }
}
