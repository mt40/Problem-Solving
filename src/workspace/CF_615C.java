package workspace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;
import helperClasses.ShortScanner;

public class CF_615C {
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        String a = in.s(); char []aa = a.toCharArray();
        char []b = in.c();
        int n = a.length(), m = b.length;
        HashMap<String, Pair> map = new HashMap<>();

        StringBuilder sb, sb1;
        for(int i = 0; i < n; ++i) {
            sb = new StringBuilder();
            sb1 = new StringBuilder();
            for (int j = i; j < n; ++j) {
                sb.append(aa[j]);
                sb1.insert(0, aa[j]);
                map.putIfAbsent(sb.toString(), new Pair(i, j));
                map.putIfAbsent(sb1.toString(), new Pair(j, i));

            }
        }
//        for(int i = n - 1; i >= 0; --i) {
//            sb = new StringBuilder();
//            for (int j = i; j >= 0; --j) {
//                sb.append(aa[j]);
//                map.put(sb.toString(), new Pair(i, j));
//            }
//        }

        sb = new StringBuilder();
        List<Pair> list = new ArrayList<>();
        for(int i = 0; i < m; ++i) {
            Pair p = null;
            int j = i;
            for(; j < m; ++j) {
                sb.append(b[j]);
                String t = sb.toString();
                if(!map.containsKey(t)) {
                    break;
                }
                else {
                    p = map.get(t);
                }
            }
            if(p == null) {
                out.println(-1);
                return;
            }
            list.add(p);
            sb = new StringBuilder();
            i = j - 1;
        }

        out.println(list.size());
        for(Pair p : list) out.printf("%d %d\n", p.a + 1, p.b + 1);
    }

    class Pair {
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
