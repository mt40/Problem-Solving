package workspace;

import helperClasses.FastScanner;
import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class SPOJ_MICEMAZE {

    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), e = in.i(), t = in.i(), m = in.i();
        int [][]g = new int[n + 1][n + 1];
        for(int []i : g) Arrays.fill(i, -1);

        for(int i = 1; i <= n; ++i) g[i][i] = 0;
        while(m-- > 0) {
            int a = in.i(), b = in.i(), v = in.i();
            g[a][b] = (g[a][b] < 0) ? v : Math.min(v, g[a][b]);
        }

        for(int k = 1; k <= n; ++k) {
            for(int i = 1; i <= n; ++i) {
                for(int j = 1; j <= n; ++j) {
                    if(g[i][k] >= 0 && g[k][j] >= 0)
                        if(g[i][j] < 0 || g[i][j] > g[i][k] + g[k][j])
                            g[i][j] = g[i][k] + g[k][j];
                }
            }
        }

        int ans = 0;
        for(int i = 1; i <= n; ++i)
            if(g[i][e] <= t && g[i][e] >= 0) ans++; // beware of disconnected components!

        out.println(ans);
    }
}
