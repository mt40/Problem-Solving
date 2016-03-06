package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.*;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_CLEANRBT {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        while(true) {
            int cols = in.i(), rows = in.i();
            if(cols == 0 && rows == 0) return;
            char[][] a = in.c(rows, cols);

            Graph first = build(a, rows, cols);
            Edge src = new Edge(0, 0);
            Graph second = buildFromBfs(first, a, rows, cols, src);

            int ans = tsp(second, src.des);
            out.println(ans);
        }
    }

    // Travelling salesman problem dp approach
    int tsp(Graph g, int src) {
        int lim = (1 << 11) + 1; // at most 10 valid nodes so we need mask = 2^10
        int [][]dp = new int[lim][g.V];
        for(int []dpi : dp) Arrays.fill(dpi, -1);

        // base case, size = 2
        for(int i = 1; i < g.V; ++i) {
            int mask = 1 | (1 << i);
            int dt = g.get(0, i);
            if(dt == inf) continue;
            dp[mask][i] = dt;
        }

        for(int len = 3; len <= g.V; ++len) {
            for(int v = 1; v < g.V; ++v) { //  not in set
                for(int u = 1; u < g.V; ++u) { // in the set
                    if(u == v) continue;
                    for (int mask = 1; mask < lim; ++mask) {
                        int d_uv = g.get(u, v);
                        if (contains(mask, v) // already in the set
                                || dp[mask][u] < 0 // u is not in the set
                                || d_uv == inf // edge u-v not exists
                                || Integer.bitCount(mask) != len-1) // incorrect size
                            continue;

                        int includeV = mask | (1 << v);
                        int d_to_v = dp[mask][u] + d_uv;
                        if(dp[includeV][v] < 0 || d_to_v < dp[includeV][v])
                            dp[includeV][v] = d_to_v;
                    }
                }
            }
        }

        int rs = inf, mask = (1 << g.validNodes) - 1;
        for(int i = 1; i < g.V; ++i) {
            if (dp[mask][i] < 0) continue;
            rs = Math.min(dp[mask][i], rs);
        }
        return (rs == inf) ? -1 : rs;
    }

    boolean contains(int mask, int i) {
        return (mask & (1 << i)) > 0;
    }

    Graph buildFromBfs(Graph base, char [][]a, int rows, int cols, Edge src) {
        Graph g = new Graph(10); // at most 10
        // find all valid nodes
        int compressIdx = 0;
        int []map = new int[base.V];
        List<Integer> nodes = new ArrayList<>();
        for(int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (a[i][j] == 'o' || a[i][j] == '*') {
                    int u = indexOf(i, j, cols);
                    nodes.add(u);

                    map[u] = compressIdx;
                    if (a[i][j] == 'o')
                        src.des = compressIdx;
                    compressIdx++;
                }
            }
        }
        g.validNodes = compressIdx;

        for(int u : nodes) {
            for(int v : nodes) {
                if(u == v) continue;
                int shortestPath = bfs(base, u, v);
                g.add(map[u], map[v], shortestPath);
            }
        }

        return g;
    }

    int bfs(Graph g, int src, int des) {
        boolean []vst = new boolean[g.V];
        Queue<Edge> q = new LinkedList<>();
        q.add(new Edge(src, 0));
        vst[src] = true;
        while(!q.isEmpty()) {
            Edge min = q.poll();
            int u = min.des;
            if(u == des)
                return min.len;
            for(Edge e = g.al[u].head; e != null; e = e.next) {
                if(vst[e.des]) continue;
                vst[e.des] = true;
                q.add(new Edge(e.des, min.len + e.len));
            }
        }
        return inf;
    }

    Graph build(char [][]a, int rows, int cols) {
        Graph g = new Graph(rows * cols);
        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < cols; ++j) {
                if(a[i][j] == 'x') continue;
                int u = indexOf(i, j, cols);
                if(i > 0 && a[i-1][j] != 'x') // top
                    g.add(u, indexOf(i-1, j, cols), 1);

                if(i < rows - 1 && a[i+1][j] != 'x')  // bottom
                    g.add(u, indexOf(i+1, j, cols), 1);

                if(j > 0 && a[i][j-1] != 'x') // left
                    g.add(u, indexOf(i, j-1, cols), 1);

                if(j < cols - 1 && a[i][j+1] != 'x') // right
                    g.add(u, indexOf(i, j+1, cols), 1);
            }
        }
        return g;
    }

    int indexOf(int i, int j, int cols) {
        return i * cols + j;
    }

    class Graph {
        int V, validNodes;
        AdjList []al;

        public Graph(int v) {
            V = v;
            al = new AdjList[v];
            for(int i = 0; i < v; ++i) al[i] = new AdjList();
        }

        void add(int src, int des, int len) {
            Edge e = new Edge(des, len);
            e.next = al[src].head;
            al[src].head = e;

            e = new Edge(src, len);
            e.next = al[des].head;
            al[des].head = e;
        }

        int get(int u, int v) {
            for(Edge e = al[u].head; e != null; e = e.next)
                if(e.des == v)
                    return e.len;
            return inf;
        }
    }

    class Edge {
        int des, len;
        Edge next;

        public Edge(int des, int len) {
            this.des = des;
            this.len = len;
        }
    }

    class AdjList {
        Edge head;
    }
}