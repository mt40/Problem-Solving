package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_626A {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        char []a = in.c();

        int ans = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = i; j < n; ++j) {
                if(check(a, i, j))
                    ans++;
            }
        }

        out.println(ans);
    }

    boolean check(char []a, int l, int r) {
        int x = 0, y = 0;
        for(int i = l; i <= r; ++i) {
            if(a[i] == 'U') y++;
            else if(a[i] == 'D') y--;
            else if(a[i] == 'L') x--;
            else x++;
        }
        return x == 0 && y == 0;
    }
}