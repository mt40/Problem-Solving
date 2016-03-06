package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.*;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_SAMER08A {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n;
        while((n = in.i()) > 0) {
            int m = in.i();
            int src = in.i(), des = in.i();
            Graph g = new Graph(n);
            for(int i = 0; i < m; ++i)
                g.add(in.i(), in.i(), in.i());

            cal(g, src, des, -1);
            for(Edge e : set) { // remove these edges
                Edge prev = g.al[e.src].head;
                for(Edge ee = prev; ee != null; ee = ee.next) {
                    if (e.equals(ee)) {
                        if (prev == g.al[e.src].head)
                            g.al[e.src].head = ee.next;
                        else
                            prev.next = ee.next;
                    }
                    prev = ee;
                }
            }
            int ans = cal(g, src, des, 1);
            out.println(ans);
        }
    }

    HashSet<Edge> set;
    // Base on Dijkstra K shortest paths algorithm
    int cal(Graph g, int src, int des, int K) {
        PriorityQueue<Path> heap = new PriorityQueue<>(cprt);
        set = new HashSet<>();
        int []traffic = new int[g.V];
        heap.add(new Path(new Edge(src, src, 0)));
        int shortestDis = -1;

        while(!heap.isEmpty()) {
            Path minPath = heap.poll();
            int u = minPath.des;
            traffic[u]++;

            if(u == des) {
                if(shortestDis < 0) {
                    shortestDis = minPath.w;
                    addEdgeToSet(set, minPath);
                    if(K == 1)
                        return shortestDis;
                }
                else if (minPath.w == shortestDis)
                    addEdgeToSet(set, minPath);
                else if (minPath.w > shortestDis)
                    return shortestDis;
            }

            if(traffic[u] >= g.V) continue; // running in circle

            for(Edge e = g.al[u].head; e != null; e = e.next)
                heap.add(new Path(minPath, e));
        }
        return shortestDis;
    }

    boolean check(HashSet<Edge> set, Path p) {
        for(Edge e : p.edges)
            if(set.contains(e) && !isDummyEdge(e))
                return false;
        return true;
    }

    void addEdgeToSet(HashSet<Edge> set, Path p) {
        for(Edge e : p.edges)
            if(!isDummyEdge(e))
                set.add(e);
    }

    boolean isDummyEdge(Edge e) {
        return e.src == 0 && e.des == 0;
    }

    Comparator<Path> cprt = (o1, o2) -> Integer.compare(o1.w, o2.w);

    class Path {
        List<Edge> edges = new LinkedList<>();
        int w, des;

        Path (Edge e) {
            edges.add(e);
            w = e.w;
            des = e.des;
        }

        Path (Path p, Edge e) {
            for(Edge pe : p.edges)
                edges.add(pe);
            edges.add(e);
            w = p.w + e.w;
            des = e.des;
        }
    }

    class Graph {
        int V;
        AdjList []al;

        public Graph(int v) {
            V = v;
            al = new AdjList[v];
            for(int i = 0; i < v; ++i) al[i] = new AdjList();
        }

        void add(int src, int des, int w) {
            Edge e = new Edge(src, des, w);
            e.next = al[src].head;
            al[src].head = e;
        }
    }

    class Edge {
        int w, des, src;

        public Edge(int src, int des, int w) {
            this.w = w;
            this.des = des;
            this.src = src;
        }

        Edge next;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Edge edge = (Edge) o;

            if (w != edge.w) return false;
            if (des != edge.des) return false;
            return src == edge.src;

        }

        @Override
        public int hashCode() {
            int result = w;
            result = 31 * result + des;
            result = 31 * result + src;
            return result;
        }
    }

    class AdjList {
        Edge head;
    }
}