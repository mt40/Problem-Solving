package workspace;

import java.util.*;
import java.io.PrintWriter;

public class CC_CHRL4 {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i(), k = in.i();
        int m = 1000000007;
        int []a = in.arr(n);

        double []lg = new double[n];
        for(int i = 0; i < n; ++i) lg[i] = Math.log(a[i]);

        long []min = new long[n];
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(lg[0], 0));
        min[0] = a[0] % m;
        for(int i = 1; i < n; ++i) {
            while(!q.isEmpty() && q.peek().id < i - k)
                q.poll();
            int pos = q.peek().id;
            min[i] = mul(min[pos], a[i], m);
            q.add(new Pair(q.peek().v + lg[i], i));
        }

        out.println(min[n - 1]);
    }

    long mul(long a, long b, int m) {
        return ((a % m) * (b % m)) % m;
    }

    class Pair implements Comparable<Pair> {
        double v;
        int id;

        public Pair(double v, int id) {
            this.v = v;
            this.id = id;
        }

        @Override
        public int compareTo(Pair o) {
            return Double.compare(v, o.v);
        }
    }
}
