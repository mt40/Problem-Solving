package workspace;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.TreeSet;

public class CF_567D {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i(), k = in.i(), a = in.i(), m = in.i();
        int []arr = in.arr(m);
        TreeSet<Pair> set = new TreeSet<>();
        set.add(new Pair(1, n, ships(a, 1, n)));
        int max = ships(a, 1, n);

        for(int i = 0; i < m; ++i) {
            Pair cover = set.floor(new Pair(arr[i], arr[i])); // interval that covers this point
            Pair left = new Pair(cover.l, arr[i]-1);
            Pair right = new Pair(arr[i]+1, cover.r);
            int n_left = ships(a, left.l, left.r);
            int n_right = ships(a, right.l, right.r);
            if(n_left + n_right < cover.cnt) {
                int dif = cover.cnt - n_left - n_right;
                max -= dif;
                if(max < k) {
                    out.println(i + 1);
                    return;
                }
            }

            set.remove(cover);
            max = Math.max(max - cover.cnt + n_left + n_right, max);
            left.cnt = n_left; right.cnt = n_right;
            if(left.l <= left.r) set.add(left);
            if(right.l <= right.r) set.add(right);
        }
        out.println(-1);
    }

    int ships(int a, int l, int r) {
        int len = r-l+1, rs = len / (a+1);
        if(len - rs*(a+1) == a) rs++;
        return rs;
    }

    class Pair implements Comparable<Pair> {
        int l, r, cnt;

        public Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }

        public Pair(int l, int r, int cnt) {
            this.l = l;
            this.r = r;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(l, o.l);
        }

        @Override
        public boolean equals(Object o) {
            Pair p = (Pair)o;
            return l == p.l && r == p.l;
        }

        @Override
        public int hashCode() {
            int result = l;
            result = 31 * result + r;
            return result;
        }
    }
}
