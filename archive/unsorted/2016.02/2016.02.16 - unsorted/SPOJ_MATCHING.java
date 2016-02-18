package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_MATCHING {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        n = in.i(); m = in.i();
        int e = in.i();
        g = new boolean[n][m];
        for(int i = 0; i < e; ++i) {
            int u = in.i() - 1, v = in.i() - 1;
            g[u][v] = true;
        }

        int ans = maxBM();
        out.println(ans);
    }

    int n, m;
    boolean [][]g;
    boolean []vst;
    int []match;
    boolean dfs(int u) {
        for(int v = 0; v < m; ++v) {
            if(g[u][v] && !vst[v]) {
                vst[v] = true;
                // if v is available or prev matched vertex
                // with v can be matched with a new vertex
                if(match[v] < 0 || dfs(match[v])) {
                    match[v] = u;
                    return true;
                }
            }
        }
        return false;
    }

    // max bipartite matching
    int maxBM() {
        match = new int[m];
        Arrays.fill(match, -1);

        int rs = 0;
        for(int u = 0; u < n; ++u) {
            vst = new boolean[m];
            if(dfs(u))
                rs++;
        }
        return rs;
    }
}