package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_ELEVTRBL {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int f = in.i(), s = in.i(), g = in.i(), u = in.i(), d = in.i();

        int ans = bfs(f, s, g, u, d);
        out.println((ans >= 0) ? ans : "use the stairs");
    }

    int bfs(int f, int s, int g, int u, int d) {
        Queue<Integer> q = new LinkedList<>();
        boolean []vst = new boolean[f + 1];
        int []cnt = new int[f + 1];
        q.add(s);
        vst[s] = true;
        while(!q.isEmpty()) {
            int nd = q.poll();
            if(nd == g) return cnt[nd];
            int up = nd + u, down = nd - d;
            if(up <= f && !vst[up]) {
                q.add(up);
                vst[up] = true;
                cnt[up] = cnt[nd] + 1;
            }
            if(down >= 1 && !vst[down]) {
                q.add(down);
                vst[down] = true;
                cnt[down] = cnt[nd] + 1;
            }
        }
        return -1;
    }
}