package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_144C {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        char []a = in.c(), p = in.c();
        int n = a.length, m = p.length;

        int []wc = new int[n]; // wild cards
        int [][]f = new int[n][26];
        int []fp = new int[26];
        for(int i = 0; i < n; ++i) {
            if(i > 0)
                System.arraycopy(f[i - 1], 0, f[i], 0, 26);
            wc[i] = (i > 0) ? wc[i - 1] : 0;
            if(a[i] == '?') wc[i]++;
            else {
                f[i][a[i] - 'a']++;
            }
        }
        for(int i = 0; i < m; ++i)
            fp[p[i] - 'a']++;

        int ans = 0;
        for(int i = 0; i + m - 1 < n; ++i) {
            int []tmp = (i > 0) ? sub(f[i + m - 1], f[i - 1]) : f[i + m - 1];
            int []dif = sub(tmp, fp);
            boolean ok = true;
            int d = 0;
            for (int aDif : dif) {
                if (aDif > 0) ok = false;
                else d += -aDif;
            }
            if(!ok) continue;
            int w = (i > 0) ? wc[i + m - 1] - wc[i - 1] : wc[i + m - 1];
            if(d == w)
                ans++;
        }

        out.println(ans);
    }

    int[] sub(int []f1, int []f2) {
        int []rs = new int[f1.length];
        for(int j = 0; j < 26; ++j) {
            rs[j] = f1[j] - f2[j];
        }
        return rs;
    }
}
