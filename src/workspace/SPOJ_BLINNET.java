package workspace;

import helperClasses.FastScanner;
import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;

import helperClasses.ShortScanner;
import helperClasses.Util;

public class SPOJ_BLINNET {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        Graph g = new Graph(n);
        for(int i = 1; i <= n; ++i) {
            String s = in.s();
            int m = in.i();
            while(m-- > 0)
                addEdge(g, i, in.i(), in.i());
        }

        out.println(Prim(g));
    }

    long Prim(Graph g) {
        long cost = 0;
        int cnt = 0;
        boolean []mst = new boolean[g.v + 1];
        PriorityQueue<Pair> heap = new PriorityQueue<>();
        heap.add(new Pair(1, 0));
        while(!heap.isEmpty()) {
            Pair p = heap.poll();
            while(mst[p.v]) p = heap.poll();
            mst[p.v] = true; // add to MST
            cost += p.key;
            cnt++;
            if(cnt == g.v) break; // enough!
            for(Edge e = g.al[p.v].head; e != null; e = e.next) {
                if(!mst[e.dest]) {
                    heap.add(new Pair(e.dest, e.wt));
                }
            }
        }
        return cost;
    }

    class Pair implements Comparable<Pair> {
        int v, key;

        public Pair(int v, int key) {
            this.v = v;
            this.key = key;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(key, o.key);
        }
    }

    void addEdge(Graph g, int src, int dest, int w) {
        Edge e = new Edge(dest, w);
        e.next = g.al[src].head;
        g.al[src].head = e;
    }

    class Graph {
        int v;
        AdjList[] al;

        public Graph(int v) {
            this.v = v;
            al = new AdjList[v + 1];
            for(int i = 1; i <= v; ++i) al[i] = new AdjList();
        }
    }

    class AdjList {
        Edge head;
    }

    class Edge {
        int dest, wt;
        Edge next;

        public Edge(int dest, int weight) {
            this.dest = dest;
            this.wt = weight;
        }
    }
}
