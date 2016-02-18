package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_219C {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}

    int inf = Integer.MAX_VALUE;
    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i(), k = in.i();
        char []a = (in.s() + '$').toCharArray();

        int ans = 0, l = 0, r = 0;

        if(k == 2) {
            char []c = new char[a.length], b = new char[a.length];
            Arrays.fill(c, 'A'); Arrays.fill(b, 'A');
            for(int i = 0; i < n; ++i) {
                if(i % 2 == 0) b[i] = 'B';
                else c[i] = 'B';
            }
            int ans1 = 0, ans2 = 0;
            for(int i = 0; i < n; ++i) ans1 += (a[i] != b[i]) ? 1 : 0;
            for(int i = 0; i < n; ++i) ans2 += (a[i] != c[i]) ? 1 : 0;
            if(ans1 < ans2) out.printf("%d\n%s\n", ans1, String.valueOf(b, 0, n));
            if(ans2 <= ans1) out.printf("%d\n%s\n", ans2, String.valueOf(c, 0, n));
            return;
        }

        for(int i = 1; i < a.length; ++i) {
            int len = r - l + 1;
            if (a[i] != a[i - 1]) {
                ans += len / 2;
                char x = find(k, a[l], a[i]);
                if(len % 2 > 0) x = find(k, a[l], a[l]);
                for(int j = l; j <= r; ++j) {
                    if((j - l) % 2 > 0) a[j] = x;
                }
                l = i;
            }
            r = i;
        }

        out.println(ans);
        for(int i = 0; i < a.length-1; ++i)
            out.print(a[i]);
        out.println();
    }

    char find(int k, char a, char b) {
        for(int i = 0; i < k; ++i) {
            if('A' + i != a && 'A' + i != b)
                return (char)('A' + i);
        }
        return '$';
    }
}
