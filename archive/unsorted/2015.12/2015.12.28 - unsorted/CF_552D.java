package workspace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_552D {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i();
        Pair []pts = new Pair[n];
        for(int i = 0; i < n; ++i) pts[i] = new Pair(in.i(), in.i());

        boolean hasOrigin = false;
        Map<Double, ArrayList<Pair>> map = new HashMap<>();
        for(Pair p : pts) {
            if(p.x == 0 && p.y == 0) {
                hasOrigin = true;
                continue;
            }
            //add(map, getK(p), p);
        }
        if(hasOrigin) {
            for(Double key : map.keySet())
                map.get(key).add(new Pair(0,0));
        }

        int ans = 0;
//        for(Map.Entry<Double, ArrayList<Pair>> e : map.entrySet()) {
//            for(Pair p : e.getKey())
//        }

        out.println(ans);
//        out.println(comb(2, 1));
//        out.println(comb(3, 2));
//        out.println(comb(20, 2));
    }

    int comb(int n, int r) {
        int a = r + 1, b = 1, rs = 1;
        for(int i = 0; i < n - r; ++i) {
            rs *= a + i;
            rs /= b + i;
        }
        return rs;
    }

    double getK(Pair p) {
        if(p.x == 0 && p.y == 0)
            return inf; // origin
        else if(p.x == 0)
            return -inf; // on y axis
        return p.y / p.x;
    }

    <K,V> void add(Map<K, Integer> map, K p) {
        if(map.containsKey(p))
            map.put(p, map.get(p) + 1);
        else
            map.put(p, 1);
    }

    class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (x != pair.x) return false;
            return y == pair.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
