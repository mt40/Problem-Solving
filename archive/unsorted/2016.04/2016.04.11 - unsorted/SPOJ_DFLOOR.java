package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

/**
 * The idea is to use DFS, complexity is
 * Solution is from a very smart implementation:
 * http://apps.topcoder.com/forums/?module=RevisionHistory&messageID=1445710
 */
public class SPOJ_DFLOOR {
    int inf = Integer.MAX_VALUE;
    int cols, rows;
    char [][]a;
    boolean [][]trace;
    int [][]moves = Util.getKingMoves();

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        while((cols = in.i()) > 0) {
            rows = in.i();
            a = in.c(rows, cols, true);

            trace = new boolean[rokws + 1][cols + 1];

            boolean ans = dfs(1, 1);
            if(ans) {
                int cnt = 0;
                for(int i = 1; i <= rows; ++i)
                    for(int j = 1; j <= cols; ++j)
                        cnt += trace[i][j] ? 1 : 0;
                out.println(cnt);
                for(int i = 1; i <= rows; ++i)
                    for(int j = 1; j <= cols; ++j)
                        if(trace[i][j])
                            out.printf("%d %d\n", j, i);
            }
            else
                out.println(-1);
        }
    }

    boolean dfs(int r, int c) {
        int nr = (c < cols) ? r : r + 1;
        int nc = (c < cols) ? c + 1 : 1;
        if(r == 1) {
            // not flip here
            if(dfs(nr, nc)) return true; // success

            // flip here
            flip(r, c);
            if(dfs(nr, nc)) return true;

            flip(r, c); // not succeed, reset
        }
        else if(r <= rows) {
            // If the upper cell is '0', we have to flip here
            if(a[r - 1][c] == '0') {
                flip(r, c);
                if (dfs(nr, nc)) return true;

                flip(r, c); // not succeed, reset
            }
            else {
                // not flip here
                if (dfs(nr, nc)) return true; // success
            }
        }
        else { // done, now check everything
//            for(int i = 1; i <= rows; ++i)
//                System.out.println(Arrays.toString(a[i]));
//            System.out.println();
            for(int i = 1; i <= cols; ++i)
                if(a[rows][i] == '0')
                    return false;
            return true;
        }
        return false;
    }

    void flip(int r, int c) {
        a[r][c] = opposite(a[r][c]);
        for(int i = 0; i < 4; ++i) {
            int nr = r + moves[i][0];
            int nc = c + moves[i][1];
            if(reachable(nr, nc))
                a[nr][nc] = opposite(a[nr][nc]);
        }
        trace[r][c] = !trace[r][c];
    }

    char opposite(char c) {
        return (c == '0') ? '1' : '0';
    }

    boolean reachable(int r, int c) {
        return r > 0 && r <= rows && c > 0 && c <= cols;
    }
}