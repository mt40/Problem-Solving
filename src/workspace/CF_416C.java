package workspace;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_416C {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i();
        Pair []req = new Pair[n];
        for(int i = 0; i < n; ++i) req[i] = new Pair(i, in.i(), in.i());
        int k = in.i();
        int []r = in.arr(k);
        boolean []booked = new boolean[k];

        Arrays.sort(req, Collections.reverseOrder());
        int ans = 0, cnt = 0;
        StringBuilder s = new StringBuilder();
        for(int j = 0; j < n; ++j) {
            Pair p = req[j];
            int min = -1;
            for(int i = 0; i < k; ++i) {
                if(min < 0) {
                    if(!booked[i] && r[i] >= p.a) min = i;
                }
                else if(r[i] < r[min] && !booked[i] && r[i] >= p.a) min = i;
            }
            if(min >= 0 && !booked[min]) {
                booked[min] = true;
                ans += p.b;
                cnt++;
                s.append(String.format("%d %d\n", p.id + 1, min + 1));
            }
        }
        out.printf("%d %d\n", cnt, ans);
        out.print(s.toString());
    }

    class Pair implements Comparable<Pair> {
        int id, a, b;

        public Pair(int id, int a, int b) {
            this.id = id;
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Pair o) {
            int t = Integer.compare(b, o.b);
            return (t == 0) ? Integer.compare(a, o.a) : t;
        }
    }
}
