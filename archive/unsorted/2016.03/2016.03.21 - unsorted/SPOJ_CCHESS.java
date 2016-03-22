package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_CCHESS {
    int inf = Integer.MAX_VALUE;
    int[][] move = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2},
            {1, 2}, {2, 1}, {2, -1}, {1, -2}};
    int n = 8;
    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int a, b, c, d;
        while(true) {
            try{a = in.i();}catch(Exception e) {return;}
            b = in.i();
            c = in.i();
            d = in.i();

            int ans = bfs(new Pos(a, b), new Pos(c, d));
            out.println(ans);
        }
    }

    int bfs(Pos src, Pos des) {
        boolean [][]visit = new boolean[n][n];
        PriorityQueue<Pos> heap = new PriorityQueue<>(cprt);
        heap.add(src);
        while(!heap.isEmpty()) {
            Pos pos = heap.poll();
            if(pos.equals(des))
                return pos.cost;
            if(visit[pos.r][pos.c]) continue;
            visit[pos.r][pos.c] = true;
            //System.out.printf("At %d %d, cost=%d\n", pos.r, pos.c, pos.cost);

            for(int i = 0; i < 8; ++i) {
                int nr = pos.r + move[i][0];
                int nc = pos.c + move[i][1];
                if(reachable(nr, nc)) {
                    Pos newMove = new Pos(nr, nc);
                    newMove.cost = pos.cost + cost(pos, newMove);
                    heap.add(newMove);
                }
            }
        }
        return -1;
    }

    boolean reachable(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    int cost(Pos a, Pos b) {
        return a.r * b.r + a.c * b.c;
    }

    Comparator<Pos> cprt = (o1, o2) -> Integer.compare(o1.cost, o2.cost);

    class Pos {
        int r, c, cost;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }

        boolean equals(Pos o) {
            return r == o.r && c == o.c;
        }
    }
}