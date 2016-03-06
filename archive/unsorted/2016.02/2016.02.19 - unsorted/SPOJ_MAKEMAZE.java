package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_MAKEMAZE {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        n = in.i();
        m = in.i();
        char [][]a = in.c(n,m);

        boolean ans = cal(a);
        out.println(ans ? "valid" : "invalid");
    }

    boolean cal(char [][]a) {
        int entry_cnt = 0;
        Graph g = new Graph(n*m);
        int []entries = {0,0};

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                if(a[i][j] == '#') continue;
                int u = id(i,j);

                if(i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    if(entry_cnt < 2) entries[entry_cnt] = u;
                    entry_cnt++;
                }

                if(i > 0 && a[i-1][j] == '.') // top
                    g.add(u, id(i-1,j));
                if(i < n-1 && a[i+1][j] == '.') // bottom
                    g.add(u, id(i+1,j));
                if(j > 0 && a[i][j-1] == '.') // left
                    g.add(u, id(i,j-1));
                if(j < m-1 && a[i][j+1] == '.') // right
                    g.add(u, id(i,j+1));
            }
        }

        if(entry_cnt != 2)
            return false;

        return bfs(g, entries[0], entries[1]);
    }

    boolean bfs(Graph g, int src, int des) {
        boolean []vst = new boolean[g.V + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vst[src] = true;
        while(!q.isEmpty()) {
            int u = q.poll();
            if(u == des) return true;
            for(Edge e = g.al[u].head; e != null; e = e.next) {
                if(vst[e.des]) continue;
                q.add(e.des);
                vst[e.des] = true;
            }
        }
        return false;
    }

    int n, m;
    int id(int i, int j) {
        return i*m + j + 1;
    }

    class Graph {
        int V;
        AdjList []al;

        public Graph(int v) {
            V = v;
            al = new AdjList[v + 1];
            for(int i = 1; i <= v; ++i) al[i] = new AdjList();
        }

        void add(int src, int des) {
            Edge e = new Edge(des);
            e.next = al[src].head;
            al[src].head = e;
        }
    }

    class Edge {
        int des;
        Edge next;

        public Edge(int des) {
            this.des = des;
        }
    }

    class AdjList {
        Edge head;
    }
}