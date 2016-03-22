package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_MTWALK {
    int inf = Integer.MAX_VALUE;
    int [][]move = {{0,-1}, {-1,0}, {0,1}, {1,0}};

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        n = in.i();
        graph = in.arr(n, n);

        int ans = cal();
        out.print(ans);
    }

    int [][]graph;
    boolean [][]visit;
    int n;

    int cal() {
        visit = new boolean[n][n];
        int low = 0, hi = 110;
        while(low < hi) {
            int mid = low + (hi - low) / 2;

            reset();

            reached = false;
            if(dfs(0, 0, mid, graph[0][0], graph[0][0])) {
                hi = mid;
            }
            else low = mid + 1;
        }
        return hi;
    }

    boolean reached = false;
    boolean dfs(int r, int c, int maxDif, int curMax, int curMin) {
        visit[r][c] = true;
        if(curMax - curMin > maxDif) {
            visit[r][c] = false;
            return false;
        }
//        if(maxDif == 3)
//            System.out.printf("At %d %d: max=%d min=%d\n", r, c, curMax, curMin);
        if(r == n - 1 && c == n - 1) {
            return reached = true;
        }

        boolean resultHere = false;
        for(int i = 0; i < 4; ++i) {
            int nr = r + move[i][0], nc = c + move[i][1];
            if(reachable(nr, nc, n) && !visit[nr][nc] && !reached) {
                int newMax = Math.max(graph[nr][nc], curMax);
                int newMin = Math.min(graph[nr][nc], curMin);
                resultHere |= dfs(nr, nc, maxDif, newMax, newMin);
            }
        }
        visit[r][c] = false;
        return resultHere;
    }

    void reset() {
        for(boolean []bi : visit)
            Arrays.fill(bi, false);
    }

    boolean reachable(int r, int c, int n) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}