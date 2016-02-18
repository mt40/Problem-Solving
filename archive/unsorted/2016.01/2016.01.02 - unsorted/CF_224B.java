package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.HashSet;

public class CF_224B {
    class ShortScanner{InputReader in;ShortScanner(InputReader in){this.in=in;}int i(){return in.nextInt();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i(), k = in.i();
        int []a = in.arr(n);

        int r = n - 1, i;
        HashSet<Integer> set = new HashSet<>();
        for(i = r; i >= 0; --i) {
            set.add(a[i]);
            if(set.size() > k) {
                i++;
                break;
            }
            if(set.size() == k) {
                break;
            }
        }
        while(r > i && r > 0 && a[r-1] == a[r])
            r--;

        if(set.size() != k || i > r)
            out.println("-1 -1");
        else
            out.printf("%d %d\n", i + 1, r + 1);
    }
}
