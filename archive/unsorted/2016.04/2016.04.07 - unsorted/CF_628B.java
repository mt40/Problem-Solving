package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_628B {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        char []a = in.c();
        int n = a.length;

        long ans = 0;
        int j = 0, cur = a[0] - '0';
        if(cur % 4 == 0)
            ans++;
        for(int i = 1; i < n; ++i) {
            j = i;
            int num = num(a[j - 1], a[j]);
            if(num % 4 == 0)
                ans += j;
            if((a[j] - '0') % 4 == 0)
                ans++;
        }

        out.println(ans);
    }

    // Create a 2-digit number xy
    int num(int x, int y) {
        return (x - '0') * 10 + (y - '0');
    }
}