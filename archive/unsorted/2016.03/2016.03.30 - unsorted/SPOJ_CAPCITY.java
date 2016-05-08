package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.*;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_CAPCITY {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), m = in.i();
        Graph graph = new Graph(n);
        for (int i = 0; i < m; ++i) {
            int u = in.i(), v = in.i();
            if (u != v)
                graph.addEdge(v, u); // reverse the graph
        }

        graph.findSCCs();

        // build a new graph with SCCs as vertices
        Graph newGraph = makeSCCGraph(graph);
        newGraph.inspect();

        int zeroInDeg = 0, zeroIdx = -1;
        for (int i = 1; i <= newGraph.V; ++i) {
            if (newGraph.indegree[i] == 0) {
                zeroInDeg++;
                zeroIdx = i;
            }
        }
        if (zeroInDeg != 1)
            out.println(0);
        else {
            SCC comp = graph.sccs.get(zeroIdx - 1);
            out.println(comp.members.size());
            for (int u : comp.members)
                out.print(u + " ");

            out.println();
        }
    }

    Graph makeSCCGraph(Graph graph) {
        int[] mark = new int[graph.V + 1];
        for (int i = 0; i < graph.sccs.size(); ++i) {
            SCC comp = graph.sccs.get(i);
            for (int u : comp.members)
                mark[u] = i + 1;
        }
        Graph newGraph = new Graph(graph.sccs.size());
        for(int u = 1; u <= graph.V; ++u) {
            for(Edge e : graph.adj[u]) {
                if(mark[u] != mark[e.des])
                    newGraph.addEdge(mark[u], mark[e.des]);
            }
        }
        return newGraph;
    }

    class Graph {
        List<Edge> []adj;
        int V;
        int []indegree;
        List<SCC> sccs = new ArrayList<>();

        @SuppressWarnings("unchecked")
        Graph(int n) {
            this.V = n;
            adj = new LinkedList[n + 1];
            for(int i = 1; i <= n; ++i)
                adj[i] = new LinkedList<>();
        }

        void addEdge(int src, int des) {
            adj[src].add(new Edge(des));
        }

        void inspect() {
            indegree = new int[V + 1];
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visit = new boolean[V + 1];
            for(int i = 1; i <= V; ++i) {
                if(visit[i]) continue;
                queue.add(i);
                visit[i] = true;
                while (!queue.isEmpty()) {
                    int u = queue.poll();
                    for (Edge e : adj[u]) {
                        indegree[e.des]++;
                        if (visit[e.des]) continue;
                        visit[e.des] = true;
                        queue.add(e.des);
                    }
                }
            }
        }

        int []disc, low;
        boolean []inStack;
        Stack<Integer> stack;
        int clock;
        void findSCCs() {
            disc = new int[V + 1];
            low = new int[V + 1];
            inStack = new boolean[V + 1];
            stack = new Stack<>();

            for(int i = 1; i <= V; ++i)
                if(disc[i] == 0)
                    findSCCs(i);
        }

        void findSCCs(int u) {
            stack.add(u);
            inStack[u] = true;
            disc[u] = low[u] = ++clock;
            for(Edge e : adj[u]) {
                int v = e.des;

                if(disc[v] == 0) { // not visited
                    findSCCs(v);
                    low[u] = Math.min(low[v], low[u]);
                }
                else if(inStack[v])
                    low[u] = Math.min(disc[v], low[u]);
            }
            if(disc[u] == low[u]) {
                SCC comp = new SCC(u);
                int x;
                do {
                    x = stack.pop();
                    comp.add(x);
                    inStack[x] = false;
                }
                while(x != u);
                sccs.add(comp);
            }
        }
    }

    class SCC {
        int root;
        TreeSet<Integer> members = new TreeSet<>();

        public SCC(int root) {
            this.root = root;
        }

        void add(int u) {
            members.add(u);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SCC scc = (SCC) o;
            return root == scc.root;

        }

        @Override
        public int hashCode() {
            return root;
        }
    }

    class Edge {
        int des;

        public Edge(int des) {
            this.des = des;
        }
    }
}