package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_GUESSTHE {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        String s;
        while(!(s = in.s()).equals("*")) {
            char []a = s.toCharArray();
            int n = a.length;
            long ans = -1;
            for(int i = 0; i < n; ++i) {
                if(a[i] == 'Y')
                    ans = (ans == -1) ? i + 1 : lcm(i + 1, ans);
            }
            for(int i = 0; i < n; ++i)
                if(a[i] == 'N' && ans % (i + 1) == 0)
                    ans = -1;
            out.println(ans);
        }
    }

    long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    long gcd(long a, long b) {
        return (a == 0) ? b : gcd(b % a, a);
    }
}