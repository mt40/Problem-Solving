package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_484B {
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
        Arrays.sort(a);

        int []lower = new int[2000001];
        for(int i = 0, j = a[i] + 1; j < lower.length; ++j) {
            lower[j] = a[i];
            while(i < n - 1 && a[i + 1] == a[i]) i++;
            if(i < n - 1 && j == a[i + 1]) i++;
        }

        int max = a[n-1];
        int ans = 0;
        for(int i = 0; i < n; ++i) {
            if(a[i] == 1 || (i > 0 && a[i] == a[i-1])) continue;
            for(int k = 1; a[i] * k <= max; ++k) {
                int l = k * a[i], r = (k + 1) * a[i];
                int p = Math.max(a[i], lower[r]);
                ans = Math.max(p % a[i], ans);
            }
        }

        out.println(ans);
    }
}
