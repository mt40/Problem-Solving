package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.*;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_INCARDS {
    long inf = Long.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), m = in.i();
        Graph g = new Graph(n);
        for(int i = 0; i < m; ++i)
            g.add(in.i(), in.i(), in.i());

        long ans = cal(g);
        out.println(ans);
    }

    long cal(Graph g) {
        PriorityQueue<Path> heap = new PriorityQueue<>(cprt);
        long []toDes = new long[g.V + 1];
        long []toSrc = new long[g.V + 1];
        Arrays.fill(toSrc, inf);
        Arrays.fill(toDes, inf);
        boolean []vst = new boolean[g.V + 1];
        heap.add(new Path(1, 0));
        vst[1] = true;

        // chieu di
        while(!heap.isEmpty()) {
            Path p = heap.poll();
            int u = p.des;
            toDes[u] = p.w;
            for(Edge e = g.al[u].head; e != null; e = e.next) {
                if(e.des == 1)
                    toSrc[u] = Math.min(e.w, toSrc[u]);
                if(vst[e.des]) continue;
                vst[e.des] = true;
                heap.add(new Path(p, e));
            }
        }

        // chieu ve
        Arrays.fill(vst, 2, g.V + 1, false); // reset
        heap.add(new Path(1, 0));
        while(!heap.isEmpty()) {
            Path p = heap.poll();
            int u = p.des;
            for(Edge e = g.al[u].head; e != null; e = e.next) {
                if(toSrc[e.des] != inf)
                    toSrc[u] = Math.min(e.w + toSrc[e.des], toSrc[u]);
                if(vst[e.des]) continue;
                vst[e.des] = true;
                heap.add(new Path(p, e));
            }
        }

        long total = 0;
        for(int i = 2; i <= g.V; ++i)
            total += toDes[i] + toSrc[i];
        return total;
    }

    Comparator<Path> cprt = (o1,o2) -> Long.compare(o1.w, o2.w);

    class Path {
        long w;
        int des;
        List<Integer> nodes = new ArrayList<>();

        Path(int des, long w) {
            nodes.add(des);
            this.w = w;
            this.des = des;
        }

        Path(Path p, Edge e) {
            for(int i : p.nodes) nodes.add(i);
            nodes.add(e.des);
            w = p.w + e.w;
            des = e.des;
        }
    }

    class Graph {
        int V;
        AdjList []al;

        public Graph(int v) {
            V = v;
            al = new AdjList[v+1];
            for(int i = 1; i <= v; ++i) al[i] = new AdjList();
        }

        void add(int src, int des, int w) {
            Edge e = new Edge(des, w);
            e.next = al[src].head;
            al[src].head = e;
        }
    }

    class Edge {
        int des, w;
        Edge next;

        Edge(int des, int w) {
            this.des = des;
            this.w = w;
        }
    }

    class AdjList {
        Edge head;
    }
}