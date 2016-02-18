package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CC_CHEFARRP {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i();
        int []a = in.arr(n);

        int []sum = new int[n], p = new int[n];
        for (int i = 0; i < n; ++i) {
            sum[i] = a[i];
            p[i] = a[i];
            if (i > 0) {
                sum[i] += sum[i - 1];
                p[i] *= p[i - 1];
            }
        }

        int ans = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                if(getSum(sum, i, j) == getP(p, i, j))
                    ans++;
            }
        }

        out.println(ans);
    }

    int getSum(int []sum, int l, int r) {
        return (l == 0) ? sum[r] : sum[r] - sum[l - 1];
    }

    int getP(int []p, int l, int r) {
        return (l == 0) ? p[r] : p[r] / p[l - 1];
    }
}
