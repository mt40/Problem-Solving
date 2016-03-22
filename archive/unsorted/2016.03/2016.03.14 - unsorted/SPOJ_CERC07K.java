package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_CERC07K {
    int inf = Integer.MAX_VALUE;
    int rows, cols;
    char [][]a;
    int [][]moves = {{0,-1}, {-1,0}, {0,1}, {1,0}};
    // mask is like this: [red-green-blue-yellow]
    int [][][]dist;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        while((rows = in.i()) > 0) {
            cols = in.i();
            a = in.c(rows, cols);

            int srcR = 0, srcC = 0;
            for(int i = 0; i < rows; ++i) {
                for(int j = 0; j < cols; ++j) {
                    if(a[i][j] == '*') {
                        srcR = i;
                        srcC = j;
                    }
                }
            }
            dist = new int[rows][cols][16];
            for(int i = 0; i < rows; ++i)
                for(int j = 0; j < cols; ++j)
                    Arrays.fill(dist[i][j], -1);

            int ans = bfs(a, srcR, srcC);
            if(ans >= 0)
                out.printf("Escape possible in %d steps.\n", ans);
            else
                out.printf("The poor student is trapped!\n");
        }
    }

    int bfs(char [][]a, int srcR, int srcC) {
        Queue<State> q = new LinkedList<>();
        q.add(new State(srcR, srcC, 0));
        dist[srcR][srcC][0] = 0;

        while(!q.isEmpty()) {
            State st = q.poll();
            int r = st.r, c = st.c, mask = st.keyMask;

            if(a[r][c] == 'X') // destination
                return dist[r][c][mask];

            for(int i = 0; i < 4; ++i) {
                int nr = r + moves[i][0];
                int nc = c + moves[i][1];
                int distToHere = dist[r][c][mask];
                if(reachable(nr, nc)) {
                    int newMask = mask;
                    // the doors
                    if(a[nr][nc] == 'R' && (newMask & 1) == 0) continue;
                    if(a[nr][nc] == 'G' && (newMask & 2) == 0) continue;
                    if(a[nr][nc] == 'B' && (newMask & 4) == 0) continue;
                    if(a[nr][nc] == 'Y' && (newMask & 8) == 0) continue;

                    // the keys
                    if(a[nr][nc] == 'r') newMask |= 1;
                    if(a[nr][nc] == 'g') newMask |= 2;
                    if(a[nr][nc] == 'b') newMask |= 4;
                    if(a[nr][nc] == 'y') newMask |= 8;

                    if(dist[nr][nc][newMask] >= 0) continue; // visited!
                    dist[nr][nc][newMask] = distToHere + 1;

                    q.add(new State(nr, nc, newMask));
                }
            }
        }
        return -1; // no answer
    }

    boolean reachable(int r, int c) {
        return (r >= 0 && r < rows && c >= 0 && c < cols) && a[r][c] != '#';
    }

    class State {
        int r, c, keyMask;

        public State(int r, int c, int keyMask) {
            this.r = r;
            this.c = c;
            this.keyMask = keyMask;
        }
    }
}