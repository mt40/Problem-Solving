package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_659F {
    int inf = Integer.MAX_VALUE;
    int [][]moves = Util.getKingMoves();

    int rows, cols;
    long k;
    int [][]grid, ans;
    Subset [][]subsets;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        rows = in.i();
        cols = in.i();
        k = in.l();
        grid = in.arr(rows, cols);

        Cell []cells = makeCells();
        Arrays.sort(cells, (o1, o2) -> Integer.compare(o2.h, o1.h)); // descending
        makeSubsets();

        boolean [][]added = new boolean[rows][cols];
        L1:
        for(Cell cell : cells) {
            added[cell.r][cell.c] = true;
            if(cell.h == 0) continue;
            for(int i = 0; i < 4; ++i) {
                int nr = cell.r + moves[i][0];
                int nc = cell.c + moves[i][1];
                if(!reachable(nr, nc) || !added[nr][nc] || grid[nr][nc] == 0) continue;

                Subset ss = union(cell, new Cell(nr, nc, grid[nr][nc]));
                int height = ss.minHeight.h;
                if((k % height) == 0 && k / height <= ss.size) {
                    makeAnswer(ss.minHeight, k / height);
                    break L1;
                }
            }
        }

        if(ans == null)
            out.println("NO");
        else {
            out.println("YES");
            for (int i = 0; i < rows; ++i, out.println())
                for (int j = 0; j < cols; ++j)
                    out.print(ans[i][j] + " ");
        }
    }

    boolean [][]visit;
    void makeAnswer(Cell u, long needed) {
        ans = new int[rows][cols];
        visit = new boolean[rows][cols];
        dfsUtil(u.r, u.c, u.h, needed);
    }

    void dfsUtil(int r, int c, int h, long cnt) {
        if(cnt <= 0) return;
        visit[r][c] = true;
        ans[r][c] = (grid[r][c] >= h) ? h : 0;
        for(int i = 0; i < 4; ++i) {
            int nr = r + moves[i][0];
            int nc = c + moves[i][1];
            if(!reachable(nr, nc) || visit[nr][nc] || grid[nr][nc] < h) continue;
            dfsUtil(nr, nc, h, --cnt);
        }
    }

    Subset union(Cell x, Cell y) {
        Cell px = find(x), py = find(y);
        Subset sx = subsets[px.r][px.c], sy = subsets[py.r][py.c];
        if(sx.root.equals(sy.root))
            return sx;

        if(sx.rank > sy.rank) {
            sy.root = sx.root;
            sx.merge(sy);
            return sx;
        }
        else if(sx.rank < sy.rank) {
            sx.root = sy.root;
            sy.merge(sx);
            return sy;
        }
        else {
            sy.root = sx.root;
            sx.rank++;
            sx.merge(sy);
            return sx;
        }
    }

    Cell find(Cell x) {
        Subset cur = subsets[x.r][x.c];
        if(cur.root.equals(x))
            return cur.root;
        return cur.root = find(cur.root);
    }

    void makeSubsets() {
        subsets = new Subset[rows][cols];
        for(int i = 0; i < rows; ++i)
            for(int j = 0; j < cols; ++j)
                subsets[i][j] = new Subset(new Cell(i, j, grid[i][j]));
    }

    Cell[] makeCells() {
        Cell []cells = new Cell[rows * cols];
        for(int i = 0, idx = 0; i < rows; ++i)
            for(int j = 0; j < cols; ++j)
                cells[idx++] = new Cell(i, j, grid[i][j]);
        return cells;
    }

    boolean reachable(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

    class Subset {
        Cell root;
        int rank = 1, size = 1;
        Cell minHeight;

        public Subset(Cell root) {
            this.root = root;
            minHeight = root;
        }

        void merge(Subset other) {
            size += other.size;
            if(other.minHeight.h < minHeight.h)
                minHeight = other.minHeight;
        }
    }

    class Cell {
        int r, c, h;

        public Cell(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }

        boolean equals(Cell other) {
            return r == other.r && c == other.c && h == other.h;
        }
    }
}