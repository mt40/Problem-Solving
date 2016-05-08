package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.LinkedList;

import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_659E {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), m = in.i();
        graph = new Graph(n);
        for(int i = 0; i < m; ++i)
            graph.addEdge(in.i(), in.i());

        int ans = cal();
        out.println(ans);
    }

    Graph graph;
    boolean []visit;
    int []parent;
    int vertices, edges;
    int cal() {
        visit = new boolean[graph.V + 1];
        parent = new int[graph.V + 1];
        int rs = 0;
        for(int i = 1; i <= graph.V; ++i) {
            if(visit[i]) continue;
            vertices = edges = 0;
            dfs(i);
            if(edges < vertices)
                rs++;
        }
        return rs;
    }

    void dfs(int u) {
        visit[u] = true;
        vertices++;
        for(Edge e : graph.adj[u]) {
            if(e.des != parent[u])
                edges++;
            if(visit[e.des])
                continue;
            parent[e.des] = u;
            dfs(e.des);
        }
    }

    class Graph {
        LinkedList<Edge>[]adj;
        int V;

        @SuppressWarnings("unchecked")
        public Graph(int v) {
            V = v;
            adj = new LinkedList[v + 1];
            for(int i = 1; i <= v; ++i)
                adj[i] = new LinkedList<>();
        }

        void addEdge(int src, int des) {
            adj[src].add(new Edge(des));
            adj[des].add(new Edge(src));
        }
    }

    class Edge {
        int des;

        public Edge(int des) {
            this.des = des;
        }
    }
}