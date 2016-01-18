package workspace;

import java.util.*;
import java.io.PrintWriter;

public class CF_510D {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i();
        int []l = in.arr(n);
        int []c = in.arr(n);

        Map<Integer, Integer> dp = new HashMap<>();
        List<Integer> list = new ArrayList<>(), tmp = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < list.size(); ++j) {
                int g = gcd(l[i], list.get(j));
                if(dp.containsKey(g))
                    dp.put(g, Math.min(c[i] + dp.get(list.get(j)), dp.get(g)));
                else {
                    tmp.add(g);
                    dp.put(g, c[i] + dp.get(list.get(j)));
                }
            }
            if(!dp.containsKey(l[i])) {
                dp.put(l[i], c[i]);
                tmp.add(l[i]);
            }
            else {
                dp.put(l[i], Math.min(c[i], dp.get(l[i])));
            }
            while(!tmp.isEmpty()) {
                list.add(tmp.remove(0));
            }
        }
        if(dp.containsKey(1))
            out.println(dp.get(1));
        else
            out.println(-1);
    }

    int gcd(int a, int b) {
        if(a == 0) return b;
        return gcd(b % a, a);
    }
}
