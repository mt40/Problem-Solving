package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_MLASERP {
    int inf = Integer.MAX_VALUE;
    int rows, cols;
    char [][]a;
    // direction is: 0:left 1:up 2:right 3:down
    int [][]move = {{0,-1}, {-1,0}, {0,1}, {1,0}};

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        cols = in.i(); rows = in.i();
        a = in.c(rows, cols);

        int srcR = 0, srcC = 0;
        L1:
        for(int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (a[i][j] == 'C') {
                    srcR = i;
                    srcC = j;
                    break L1;
                }
            }
        }

        int ans = bfs(a, srcR, srcC);
        out.println(ans);
    }

    int bfs(char [][]a, int srcR, int srcC) {
        int ans = inf;
        Queue<State> q = new LinkedList<>();
        int [][][]mirrors = new int[rows][cols][4];
        for(int i = 0; i < rows; ++i)
            for(int j = 0; j < cols; ++j)
                Arrays.fill(mirrors[i][j], -1);

        for(int i = 0; i < 4; ++i) {
            q.add(new State(srcR, srcC, i));
            mirrors[srcR][srcC][i] = 0;
        }

        while(!q.isEmpty()) {
            State st = q.poll();
            int r = st.r, c = st.c, dir = st.direction;

            //print(r, c, dir, mirrors[r][c][dir]);

            if(a[r][c] == 'C' && (r != srcR || c != srcC)) {
                ans = Math.min(mirrors[r][c][dir], ans);
                continue;
            }

            int mirrorsHere = mirrors[r][c][dir];
            for(int i = 0; i < 4; ++i) {
                // a mirror can only help change direction to 90 degree
                if(i != dir && i != (dir + 1) % 4 && i != (dir + 3) % 4) continue;

                int nr = r + move[i][0], nc = c + move[i][1];

                if(isReachable(nr, nc)) {
                    int oldVal = mirrors[nr][nc][i];
                    int newVal = (i == dir) ? mirrorsHere : mirrorsHere + 1;
                    if(oldVal < 0 || oldVal > newVal) {
                        mirrors[nr][nc][i] = newVal;
                        q.add(new State(nr, nc, i));
                    }
                }
            }
        }
        return ans;
    }

    boolean isReachable(int r, int c) {
        return (r >= 0 && r < rows && c >= 0 && c < cols) && a[r][c] != '*';
    }

    void print(int r, int c, int dir, int mirrors) {
        String []tmp = {"left", "up", "right", "down"};
        System.out.printf("Row %d, col %d, %s: %d mirrors\n", r, c, tmp[dir], mirrors);
    }

    class State {
        int r, c, direction;

        public State(int r, int c, int direction) {
            this.r = r;
            this.c = c;
            this.direction = direction;
        }
    }
}