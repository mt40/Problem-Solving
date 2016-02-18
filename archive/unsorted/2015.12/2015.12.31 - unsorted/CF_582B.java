package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_582B {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i(), t = in.i();
        int []a = in.arr(n);
        int []lis = new int[n + 1], f = new int[301];
        int []first = new int[n], last = new int[n];
        for(int i : a) f[i]++;

        int len, mx = 0;
        for(int j = 0; j < n; ++j) {
            Arrays.fill(lis, inf);
            len = 0;
            for(int i = 0; i <= j; ++i) {
                if(a[i] > a[j]) continue;
                int p = least(lis, a, a[i]);
                lis[p] = i;
                len = Math.max(p, len);
                mx = Math.max(len, mx);
            }
            first[j] = len;
        }
        if(t == 1) {
            out.println(mx);
            return;
        }

        for(int j = 0; j < n; ++j) {
            Arrays.fill(lis, inf);
            len = 0;
            for(int i = j; i < n; ++i) {
                if(a[i] < a[j]) continue;
                int p = least(lis, a, a[i]);
                lis[p] = i;
                len = Math.max(p, len);
            }
            last[j] = len;
        }
        out.println(Arrays.toString(first));
        out.println(Arrays.toString(last));

        int max = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                if(a[j] >= a[i]) {
                    int val = first[i] + (t - 2) * f[a[i]] + last[j];
                    max = Math.max(val, max); out.println(val);
                    break;
                }
            }
        }
        out.println(max);
    }

    int least(int []lis, int []a, int key) {
        int low = 1, hi = lis.length - 1, rs = low;
        while(low <= hi) {
            int m = low + (hi - low) / 2;
            if(lis[m] == inf || a[lis[m]] > key) {
                hi = m - 1;
                rs = m;
            }
            else low = m + 1;
        }
        return rs;
    }
}
