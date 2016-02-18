package workspace;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_402B2 {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i(), k = in.i();
        int []a = in.arr(n);

        int []b = new int[n];
        int ans = inf;
        ArrayList<Entry> list = new ArrayList<>();
        for(int i = 1; i <= 2000; ++i) {
            b[0] = i;
            for(int j = 1; j < n; ++j) {
                b[j] = b[j - 1] + k;
            }
            int cnt = 0;
            ArrayList<Entry> tmp = new ArrayList<>();
            for(int j = 0; j < n; ++j) {
                if(a[j] != b[j]) {
                    cnt++;
                    if(b[j] > a[j]) tmp.add(new Entry('+', j + 1, b[j] - a[j]));
                    else tmp.add(new Entry('-', j + 1, a[j] - b[j]));
                }
            }
            if(cnt < ans) {
                ans = cnt;
                list = tmp;
            }
        }

        out.println(ans);
        if(ans > 0) {
            for(Entry e : list) {
                out.printf("%c %d %d\n", e.sign, e.a, e.b);
            }
        }
    }

    class Entry {
        char sign;
        int a, b;

        public Entry(char sign, int a, int b) {
            this.sign = sign;
            this.a = a;
            this.b = b;
        }
    }
}
