package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_580C {
    Graph graph;
    boolean []cats;
    int n, m;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        graph = new Graph(n);
        cats = new boolean[n + 1];
        for(int i = 1; i <= n; ++i)
            cats[i] = (in.nextInt() == 0)? false : true;
        for(int i = 0; i < n - 1; ++i) {
            int src = in.nextInt(), dest = in.nextInt();
            addEdge(src, dest);
        }

        boolean []visit = new boolean[n + 1];
        visit[1] = true;
        out.println(dfs(1, (cats[1])? 1 : 0, visit));
    }

    int dfs(int node, int cats, boolean []visited) {
        Edge p = graph.array[node].head;
        if(p.next == null && visited[p.dest] && cats <= m)
            return 1;
        if(cats > m) // no need to go further on this path
            return 0;
        Edge e = graph.array[node].head;
        int ans = 0;
        while(e != null) {
            if(!visited[e.dest]) {
                visited[e.dest] = true;
                if (e.hasCat) {
                    ans += dfs(e.dest, cats + 1, visited);
                } else {
                    ans += dfs(e.dest, 0, visited);
                }
            }
            e = e.next;
        }
        return ans;
    }

    void addEdge(int src, int dest) {
        Edge newEdge = new Edge(dest, cats[dest]);
        newEdge.next = graph.array[src].head;
        graph.array[src].head = newEdge;

        newEdge = new Edge(src, cats[src]);
        newEdge.next = graph.array[dest].head;
        graph.array[dest].head = newEdge;
    }

    class Graph {
        int V;
        AdjList []array;

        public Graph(int v) {
            V = v;
            array = new AdjList[v + 1]; // root is 1
            for(int i = 1; i <= v; ++i)
                array[i] = new AdjList();
        }
    }

    class Edge {
        int dest;
        boolean hasCat;
        Edge next;

        public Edge(int dest, boolean hasCat) {
            this.dest = dest;
            this.hasCat = hasCat;
        }
    }

    class AdjList {
        Edge head;
    }
}
