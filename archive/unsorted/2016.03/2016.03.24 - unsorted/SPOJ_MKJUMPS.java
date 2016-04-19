package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_MKJUMPS {
    int inf = Integer.MAX_VALUE;
    int [][]moves = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2},
            {1, 2}, {2, 1}, {2, -1}, {1, -2}};
    boolean [][]board;
    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n, test = 1;
        while((n = in.i()) > 0) {
            int count = 0;
            int startR = -1, startC = -1;
            board = new boolean[10][10];
            for(int i = 0; i < n; ++i) {
                int skip = in.i(), len = in.i();
                for(int j = skip; j < len + skip; ++j) {
                    if(startR < 0) {
                        startR = i;
                        startC = j;
                    }
                    board[i][j] = true;
                    count++;
                }
            }

            visit = new boolean[10][10];
            visit[startR][startC] = true;
            int reached = dfs(startR, startC);
            int ans = count - reached;
            if(ans == 1)
                out.printf("Case %d, %d square can not be reached.\n", test++, ans);
            else
                out.printf("Case %d, %d squares can not be reached.\n", test++, ans);
//            for(int []i : limit)
//                System.out.println(Arrays.toString(i));
        }
    }

    boolean [][]visit;
    // return number of squares reached
    int dfs(int r, int c) {
        int reached = 0;
        for(int i = 0; i < 8; ++i) {
            int nr = r + moves[i][0];
            int nc = c + moves[i][1];
            if(reachable(nr, nc) && !visit[nr][nc]) { // not visited by all neighbors
                visit[nr][nc] = true;
                reached = Math.max(dfs(nr, nc), reached);
                visit[nr][nc] = false;
            }
        }
        return reached + 1;
    }

    boolean reachable(int r, int c) {
        return (r >= 0 && r < 10 && c >= 0 && c < 10) && board[r][c];
    }

    class Pos {
        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}