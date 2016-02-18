package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_FINDSR {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        char []a;
        while((a = in.c())[0] != '*') {
            int ans = cal(a);
            out.println(ans);
        }
    }

    int cal(char []a) {
        int n = a.length;
        int []f = new int[n];
        for(int i = 1; i < n; ++i) {
            if(a[i] == a[f[i - 1]])
                f[i] = 1 + f[i - 1];
        }

        int rt = n - f[n - 1];
        return (n % rt == 0) ? n / rt : 1;
    }
}