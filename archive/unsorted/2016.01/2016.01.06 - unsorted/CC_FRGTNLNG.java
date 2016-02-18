package workspace;

import java.util.*;
import java.io.PrintWriter;

public class CC_FRGTNLNG {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i(), k = in.i();
        boolean []ans = new boolean[n];
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; ++i) map.put(in.s(), i);
        while(k-- > 0) {
            int m = in.i();
            for(int i = 0; i < m; ++i) {
                String s = in.s();
                if(map.containsKey(s))
                    ans[map.get(s)] = true;
            }
        }

        for(boolean b : ans) out.print(b ? "YES " : "NO ");
        out.println();
    }
}
