package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_ALLIZWEL {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        n = in.i();
        m= in.i();
        g = in.c(n, m);


        boolean ans = false;
        L:
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                if(g[i][j] == 'A') {
                    vst = new boolean[n][m];
                    ans |= dfs(i, j, 1);
                    if(ans) break L;
                }
            }
        }

        out.println(ans ? "YES" : "NO");
    }
    int n, m;
    boolean [][]vst;
    char [][]g;
    char []map = "ALLIZZWELL".toCharArray();
    boolean dfs(int r, int c, int l) {
        if(l == map.length) return true;
        char target = map[l];
        boolean ans = false;
        vst[r][c] = true;

        for(int i = r - 1; i <= r + 1 && i < n; ++i) {
            if(i < 0) continue;
            for(int j = c - 1; j <= c + 1 && j < m; ++j) {
                if(j < 0 || (i == r && j == c)) continue;
                if(g[i][j] == target && !vst[i][j]) {
                    ans |= dfs(i, j, l + 1);
                    if(ans) return ans;
                }
            }
        }
        vst[r][c] = false; // release
        return ans;
    }
}