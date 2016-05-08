package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.*;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_WATER {
    int inf = Integer.MAX_VALUE;
    int [][]moves = Util.getKingMoves();

    int rows, cols;
    Cell[][]grid;
    int [][]filled;
    PriorityQueue<Cell> borders;
    boolean [][]visit;

    /**
     * The idea is to process the 'border' cells by increasing order of height
     * For each 'border' cell with height h, cells that can be
     * reached will be filled to h, unreachable cells (ones that have height > h)
     * are added as new borders
     */
    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        rows = in.i(); cols = in.i();
        grid = new Cell[rows][cols];
        for(int i = 0; i < rows; ++i)
            for(int j = 0; j < cols; ++j)
                grid[i][j] = new Cell(i, j, in.i());

        calc();

        int volume = 0;
//        for(int []ar : filled)
//            out.println(Arrays.toString(ar));
        for(int i = 1; i < rows - 1; ++i)
            for(int j = 1; j < cols - 1; ++j)
                volume += filled[i][j];
        out.println(volume);
    }

    void calc() {
        filled = new int[rows][cols];
        visit = new boolean[rows][cols];
        borders = new PriorityQueue<>(cprt); // increasing order of height
        for(int i = 0; i < rows; ++i) {
            borders.add(grid[i][0]);
            borders.add(grid[i][cols - 1]);
        }
        for(int i = 0; i < cols; ++i) {
            borders.add(grid[0][i]);
            borders.add(grid[rows - 1][i]);
        }

        while(!borders.isEmpty()) {
            Cell p = borders.poll();
            floodFill(p.r, p.c, p.h);
        }
    }

    void floodFill(int r, int c, int h) {
        Queue<Cell> queue = new LinkedList<>();
        queue.add(grid[r][c]);
        visit[r][c] = true;

        while(!queue.isEmpty()) {
            Cell u = queue.poll();
            for(int i = 0; i < 4; ++i) {
                int nr = u.r + moves[i][0];
                int nc = u.c + moves[i][1];
                if(!reachable(nr, nc) || visit[nr][nc] || isBorder(nr, nc))
                    continue;
                visit[nr][nc] = true;
                if(grid[nr][nc].h > h) // higher height, added as new border
                    borders.add(grid[nr][nc]);
                else {
                    filled[nr][nc] = h - grid[nr][nc].h;
                    queue.add(grid[nr][nc]);
                }
            }
        }
    }

    boolean reachable(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

    boolean isBorder(int r, int c) {
        return r == 0 || r == rows - 1 || c == 0 || c == cols - 1;
    }

    Comparator<Cell> cprt = (o1, o2) -> Integer.compare(o1.h, o2.h);

    class Cell {
        int r, c, h;

        public Cell(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }
    }
}