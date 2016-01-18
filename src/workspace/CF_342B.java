package workspace;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_342B {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i(), m = in.i(), s = in.i(), f = in.i();
        Map<Integer, Pair> map = new HashMap<>();
        for(int i = 0; i < m; ++i) map.put(in.i(), new Pair(in.i(), in.i()));

        int step = 1, cur = s;
        while(true) {
            if(cur == f) break;
            boolean ok = true;
            if(map.containsKey(step)) {
                Pair p = map.get(step);
                if(p.a <= cur && cur <= p.b) ok = false;
                if(f > s && p.a <= cur + 1 && cur + 1 <= p.b) ok = false;
                if(f < s && p.a <= cur - 1 && cur - 1 <= p.b) ok = false;
            }
            if(ok) {
                if(f > s) {
                    out.print('R');
                    cur++;
                }
                else {
                    out.print('L');
                    cur--;
                }
            }
            else
                out.print('X');
            step++;
        }
        out.println();
    }

    class Pair {
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (a != pair.a) return false;
            return b == pair.b;

        }

        @Override
        public int hashCode() {
            int result = a;
            result = 31 * result + b;
            return result;
        }
    }
}
