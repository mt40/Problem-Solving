package workspace;

import java.util.*;
import java.io.PrintWriter;

public class SPOJ_WATER {
    int n, m;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        n = in.nextInt(); m = in.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                a[i][j] = in.nextInt();

        boolean [][]graph = new boolean[n * m + 1][n * m + 1];
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                checkWall(a, graph, i - 1, j, i, j); // top
                checkWall(a, graph, i, j + 1, i, j); // right
                checkWall(a, graph, i + 1, j, i, j); // bottom
                checkWall(a, graph, i, j - 1, i, j); // left
            }
        }

        // flood fill
        PriorityQueue<Cell> heap = new PriorityQueue<Cell>(n * m, new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                return Integer.compare(o1.height, o2.height);
            }
        });
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < m; ++j)
                heap.add(new Cell(i, j, a[i][j]));
        int ans = 0;
        while(heap.size() > 0) {
            Cell start = heap.poll();
            ans += bfs(graph, a, start.A, start.B);
        }

        out.println(ans);
    }

    class Cell {
        int A, B, height;

        public Cell(int a, int b, int height) {
            A = a;
            B = b;
            this.height = height;
        }

        @Override
        public String toString() {
            return String.format("%d %d %d", A, B, height);
        }
    }

    int bfs(boolean [][]graph, int [][]a, int s_i, int s_j) {
        int increase = 0;
        int level = a[s_i][s_j]; // the beginning level of water
        Queue<Integer> q = new LinkedList<Integer>();
        boolean []visit = new boolean[n * m + 1];
        q.add(getId(s_i, s_j));
        while(q.size() > 0) {
            int x = q.poll();
            for(int i = 0; i < graph[x].length; ++i) {
                if(visit[i]) continue;
                int tmp_i = getI(i), tmp_j = getJ(i);
                if(tmp_i == 0 || tmp_i == n - 1 || tmp_j == 0 || tmp_j == m - 1)
                    continue;
                if (graph[x][i] && a[tmp_i][tmp_j] < level) {
                    q.add(i);
                    increase += level - a[tmp_i][tmp_j];
                    update(graph, a, tmp_i, tmp_j, level);
                    visit[i] = true;
                }
            }
        }
        return increase;
    }

    void update(boolean [][]graph, int [][]a, int i, int j, int newVal) {
        a[i][j] = newVal;
//        checkWall(a, graph, i - 1, j, i, j); // top
//        checkWall(a, graph, i, j + 1, i, j); // right
//        checkWall(a, graph, i + 1, j, i, j); // bottom
//        checkWall(a, graph, i, j - 1, i, j); // left
    }

    void checkWall(int [][]a, boolean [][]graph, int wall_i, int wall_j, int i, int j) {
        if(wall_i < 0 || wall_i == n || wall_j < 0 || wall_j == m)
            return;
        int start = getId(i, j), end = getId(wall_i, wall_j);
        graph[start][end] = false;
        if(a[wall_i][wall_j] <= a[i][j]) {
            graph[start][end] = true;
        }
    }

    int getId(int i, int j) {
        return i * m + j + 1;
    }

    int getI(int id) {
        return (id - 1)/ m;
    }

    int getJ(int id) {
        return (id - 1)% m;
    }
}
