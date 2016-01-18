package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.*;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_PFDEP {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), m = in.i();
        boolean[][] g = new boolean[n + 1][n + 1];
        boolean[] isRoot = new boolean[n + 1];
        Arrays.fill(isRoot, 1, n + 1, true);
        for (int i = 0; i < m; ++i) {
            int v = in.i(), t = in.i();
            if (t > 0) isRoot[v] = false;
            while (t-- > 0) {
                int src = in.i();
                g[src][v] = true;
            }
        }

        for (int i = 1; i <= n; ++i)
            if (isRoot[i])
                g[0][i] = true; // pseudo root

        topo = new LinkedList<>();
        boolean[] vst = new boolean[n + 1];
        dfs(g, 0, vst);

        for (int i : topo) out.print(i + " ");
        out.println();
    }

    Deque<Integer> topo;

    void dfs(boolean[][] g, int v, boolean[] vst) {
        vst[v] = true;
        for (int i = g.length - 1; i >= 0; --i) {
            if (vst[i]) continue;
            if (g[v][i]) {
                dfs(g, i, vst);
            }
        }
        if (v > 0)
            topo.addFirst(v);
    }
}