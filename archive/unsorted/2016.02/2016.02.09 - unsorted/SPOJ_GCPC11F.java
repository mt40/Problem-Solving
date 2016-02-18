package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_GCPC11F {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        char []c = in.sl().toCharArray();
        int n = c.length;

        int ans = -1;
        char []t = new char[n], save = {};
        for(int d = 0; d <= 25; ++d) {
            t = new char[n];
            for(int i = 0; i < n; ++i) {
                char ci = c[i];
                if(ci != ' ') {
                    ci = (char)((num(ci) - d + 26) % 26 + 'A');
                }
                t[i] = ci;
            }
            if(check(t)) {
                if(ans >= 0) {
                    ans = -1;
                    break;
                }
                ans = d;
                save = t;
            }
        }

        if(ans >= 0)
            out.printf("%d %s\n", ans, String.valueOf(save));
        else
            out.println("NOT POSSIBLE");
    }

    boolean check(char []c) {
        int []f = new int[26];
        for(char ci : c)
            if(ci != ' ')
                f[num(ci)]++;
        return findMax(f) == 4; // 4 is E
    }

    int findMax(int []ar) {
        int mx = 0;
        for(int i = 0; i < ar.length; ++i)
            if(ar[mx] < ar[i])
                mx = i;
        for(int i = 0; i < ar.length; ++i)
            if(i != mx && ar[i] == ar[mx])
                return -1;
        return mx;
    }

    int num(char c) {
        return c - 'A';
    }
}