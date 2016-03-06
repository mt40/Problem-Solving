package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_TRAFFICN {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), m = in.i(), k = in.i(), src = in.i(), des = in.i();
        Graph g = new Graph(n);
        for(int i = 0; i < m; ++i)
            g.add(in.i(), in.i(), in.i());

        int ans = inf;
        for(int i = 0; i < k; ++i) {
            int u = in.i(), v = in.i(), w = in.i();
            g.add(u, v, w);
            if(u != v)
                g.add(v, u, w);

            ans = Math.min(Dijkstra(g, src, des), ans);

            g.remove(u, v, w);
            if(u != v)
                g.remove(v, u, w);
        }

        out.println((ans == inf) ? -1 : ans);
    }

    int Dijkstra(Graph g, int src, int des) {
        boolean []vst = new boolean[g.V + 1];
        PriorityQueue<Edge> heap = new PriorityQueue<>(cprt);
        heap.add(new Edge(src, 0));

        while(!heap.isEmpty()) {
            Edge min = heap.poll();
            int u = min.des;
            if(u == des)
                return min.w;
            vst[u] = true;
            for(Edge e = g.al[u].head; e != null; e = e.next) {
                if(vst[e.des]) continue;
                heap.add(new Edge(e.des, min.w + e.w));
            }
        }
        return inf; // no path found
    }

    Comparator<Edge> cprt = (o1, o2) -> Integer.compare(o1.w, o2.w);

    class Graph {
        int V;
        AdjList []al;

        public Graph(int v) {
            V = v;
            al = new AdjList[v + 1];
            for(int i = 1; i <= v; ++i) al[i] = new AdjList();
        }

        void add(int src, int des, int w) {
            Edge e = new Edge(des, w);
            e.next = al[src].head;
            al[src].head = e;
        }

        void remove(int src, int des, int w) {
            Edge prev = al[src].head;
            if(prev.des == des && prev.w == w)
                al[src].head = prev.next;
            else {
                for(Edge e = prev.next; e != null; e = e.next) {
                    if(e.des == des && e.w == w) {
                        prev.next = e.next;
                        return;
                    }
                    prev = e;
                }
            }
        }
    }

    class Edge {
        int des, w;
        Edge next;

        public Edge(int des, int w) {
            this.des = des;
            this.w = w;
        }
    }

    class AdjList {
        Edge head;
    }
}