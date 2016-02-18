package workspace;

import java.util.*;
import java.io.PrintWriter;

public class CF_159A {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i(), d = in.i();

        Map<Pair, TreeSet<Integer>> map = new HashMap<>();
        Set<Pair> ans = new HashSet<>();
        for(int i = 0; i < n; ++i) {
            String a = in.s(), b = in.s();
            int c = in.i();
            Pair p = new Pair(b, a), p2 = new Pair(a, b);
            if(map.containsKey(p)) {
                Integer t = map.get(p).ceiling(c - d);
                if(t != null && c - t > 0) {
                    if(!ans.contains(p) && !ans.contains(p2))
                        ans.add(p);
                }
            };
            if(map.containsKey(p2)) map.get(p2).add(c);
            else {
                TreeSet<Integer> tmp = new TreeSet<>();
                tmp.add(c);
                map.put(p2, tmp);
            }
        }

        out.println(ans.size());
        for(Pair p : ans)
            out.printf("%s %s\n", p.a, p.b);
    }

    class Pair {
        String a, b;

        public Pair(String a, String b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (a != null ? !a.equals(pair.a) : pair.a != null) return false;
            return b != null ? b.equals(pair.b) : pair.b == null;

        }

        @Override
        public int hashCode() {
            int result = a != null ? a.hashCode() : 0;
            result = 31 * result + (b != null ? b.hashCode() : 0);
            return result;
        }
    }
}
