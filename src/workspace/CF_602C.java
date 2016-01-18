package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;

public class CF_602C {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        boolean [][]rails = new boolean[n+1][n+1];
        boolean [][]roads = new boolean[n+1][n+1];
        for(int i = 1; i <= n; ++i) Arrays.fill(roads[i], true);
        for(int i = 0; i < m; ++i) {
            int x = in.nextInt(), y = in.nextInt();
            rails[x][y] = rails[y][x] = true;
            roads[x][y] = roads[y][x] = false;
        }

        int rail = bfs(rails, n);//System.out.println("--------------");
        int road = bfs(roads, n);

        out.println(rail * road < 0 ? -1 : Math.max(rail, road));
    }

    int bfs(boolean [][]graph, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean []visited = new boolean[n + 1];
        q.add(1); visited[1] = true;
        int min = -1;
        int []len = new int[n + 1];
        while(q.size() > 0) {
            int v = q.poll();
            //System.out.println("visit " + v);
            for(int i = 1; i <= n; ++i) {
                if(!visited[i] && graph[v][i]) {
                    q.add(i);
                    visited[i] = true;
                    len[i] = len[v] + 1;
                    if(i == n) {
                        min = (min == -1) ? len[i] : Math.min(len[i], min);
                    }
                }
            }
        }
        return min;
    }
}
