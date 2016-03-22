package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeSet;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_GCPC11J {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n;
        try{n = in.i();}catch (Exception e) {return;}
        graph = new Graph(n);
        for(int i = 0; i < n - 1; ++i)
            graph.add(in.i(), in.i());

        visit = new boolean[n];
        ttl = new int[n];

        inspect(0, 0);

        int far = Util.maxIndex(ttl);
        Arrays.fill(visit, false);
        Arrays.fill(ttl, 0);

        inspect(far, 0);
        int diameter = Util.max(ttl);
        int ans = (diameter + 1) / 2;
        out.println(ans);
    }

    Graph graph;
    boolean []visit;
    int []ttl;

    void inspect(int u, int dist) {
        visit[u] = true;
        ttl[u] = dist;

        for(Edge e = graph.al[u].head; e != null; e = e.next) {
            int v = e.des;
            if(visit[v]) continue;
            inspect(v, dist + 1);
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

        void add(int src, int des) {
            Edge e = new Edge(des);
            e.next = al[src].head;
            al[src].head = e;

            e = new Edge(src);
            e.next = al[des].head;
            al[des].head = e;
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