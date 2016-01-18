package workspace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_350B {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i();
        boolean []hotel = new boolean[n];
        for(int i = 0; i < n; ++i) hotel[i] = (in.i() == 1);
        int []prev = new int[n], deg = new int[n];
        Arrays.fill(prev, -1);
        for(int i = 0; i < n; ++i) {
            int x = in.i() - 1;
            if(x < 0) continue;
            prev[i] = x;
            deg[x]++;
        }

        Object []rs = {};
        List<Integer> tmp = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
            if(!hotel[i]) continue;
            int cur = i;
            tmp.clear();
            tmp.add(cur + 1);
            while(prev[cur] >= 0 && deg[prev[cur]] == 1 && !hotel[prev[cur]]) {
                tmp.add(prev[cur] + 1);
                cur = prev[cur];
            }
            if(tmp.size() > rs.length)
                rs = tmp.toArray();
        }

        out.println(rs.length);
        for(int i = rs.length - 1; i >= 0; --i) out.print(rs[i] + " ");
    }
}
