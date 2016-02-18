package workspace;

import java.util.HashSet;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Set;

public class CF_182D {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        String sa = in.s(), sb = in.s();
        char []a = sa.toCharArray(), b = sb.toCharArray();

        Set<String> da = divisor(a, sa);
        Set<String> db = divisor(b, sb);
        da.retainAll(db);
        out.println(da.size());
    }

    Set<String> divisor(char []a, String str) {
        int n = a.length;
        int []all = new int[26];
        int []pre = new int[26];
        for(char c : a) all[c-'a']++;

        HashSet<String> set = new HashSet<>(), rs = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; ++i) {
            pre[a[i] - 'a']++;
            sb.append(a[i]);
            if(n % (i + 1) == 0)
                set.add(String.valueOf(sb.toString()));
        }

        for(String s : set) {
            sb = new StringBuilder();
            while(sb.length() < n)
                sb.append(s);
            if(str.equals(sb.toString()))
               rs.add(s);
        }
        return rs;
    }
}
