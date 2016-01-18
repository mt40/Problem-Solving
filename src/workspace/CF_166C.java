package workspace;

import javafx.collections.transformation.SortedList;

import java.util.*;
import java.io.PrintWriter;

public class CF_166C {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i(), x = in.i();
        int []a = in.arr(n);
        Arrays.sort(a);

        List<Integer> list = new ArrayList<>();
        for(int i : a) list.add(i);
        int ans = 0;
        if(!list.contains(x)) {
            int i = 0;
            for(; i < n; ++i) {
                if(list.get(i) > x) {
                    break;
                }
            }
            list.add(i, x);
            ans++;
        }
        int p = list.indexOf(x);
        while(list.get((list.size() + 1) / 2 - 1) != x) {
            list.add(p, x);
            ans++;
        }

        out.println(ans);
    }
}
