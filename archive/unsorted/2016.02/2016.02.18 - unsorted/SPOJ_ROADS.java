package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_ROADS {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int k = in.i(), n = in.i(), r = in.i();
        Graph g = new Graph(n);
        for(int i = 0; i < r; ++i)
            g.add(in.i(), in.i(), in.i(), in.i());

        int ans = shortestPaths(g, 1, n, k, r);
        out.println(ans);
    }

    // Find shortest paths until we have a path that has total cost <= K
    int shortestPaths(Graph g, int src, int des, int K, int r) {
        PriorityQueue<Path> heap = new PriorityQueue<>((o1,o2)->Integer.compare(o1.len, o2.len));
        int []pathCount = new int[g.V + 1];
        heap.add(new Path(src)); // base case: a path from src->src
        while(!heap.isEmpty()) {
            Path min = heap.poll();
            int u = min.des;
            pathCount[u]++;
            if(u == des && min.cost <= K)
                return min.len;

            if(pathCount[u] <= r && min.cost <= K) {
                for (Edge e = g.al[u].head; e != null; e = e.next) {
                    Path p = min.add(e);
                    heap.add(p);
                }
            }
        }
        return -1;
    }

    class Graph {
        int V;
        AdjList []al;

        public Graph(int v) {
            V = v;
            al = new AdjList[v + 1];
            for(int i = 1; i <= v; ++i) al[i] = new AdjList();
        }

        void add(int src, int des, int len, int cost) {
            Edge e = new Edge(des, len, cost);
            e.next = al[src].head;
            al[src].head = e;
        }
    }

    class Path {
        int len = 0, cost = 0, des;

        public Path(int des) {
            this.des = des;
        }

        Path add(Edge e) {
            Path p = new Path(e.des);
            p.len = len + e.len;
            p.cost = cost + e.cost;
            return p;
        }
    }

    class Edge {
        int des, len, cost;
        Edge next;

        public Edge(int des, int len, int cost) {
            this.des = des;
            this.len = len;
            this.cost = cost;
        }
    }

    class AdjList {
        Edge head;
    }
}