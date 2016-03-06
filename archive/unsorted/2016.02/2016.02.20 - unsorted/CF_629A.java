package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_629A {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        char [][]a = in.c(n, n);

        int ans = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                if(a[i][j] == '.') continue;
                for(int k = j + 1; k < n; ++k)
                    if(a[i][k] == 'C') ans++;
                for(int k = i + 1; k < n; ++k)
                    if(a[k][j] == 'C') ans++;
            }
        }

        out.println(ans);
    }
}