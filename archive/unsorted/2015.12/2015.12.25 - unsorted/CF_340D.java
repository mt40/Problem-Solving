package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_340D {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}

    int inf = Integer.MAX_VALUE;
    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i();
        int []a = in.arr(n);

        int []lis = new int[n + 1];
        Arrays.fill(lis, inf);
        int len = 0;
        for(int i = 0; i < n; ++i) {
            int p = firstBigger(lis, a[i]);
            lis[p] = a[i];
            len = (int)max(len, p);
        }

        out.println(len);
    }

    int firstBigger(int []a, int key) {
        int low = 1, hi = a.length - 1, rs = low;
        while(low <= hi) {
            int m = low + (hi - low) / 2;
            if(a[m] >= key) {
                rs = m;
                hi = m - 1;
            }
            else
                low = m + 1;
        }
        return rs;
    }
}
