package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_TAXI {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        p = in.i();
        t = in.i();
        int s = in.i(), c = in.i();
        Pair []people = new Pair[p], taxis = new Pair[t];
        for(int i = 0; i < p; ++i)
            people[i] = new Pair(in.i(), in.i());
        for(int i = 0; i < t; ++i)
            taxis[i] = new Pair(in.i(), in.i());

        g = new Graph(p + t);
        for(int i = 1; i <= t; ++i) {
            for(int j = 1; j <= p; ++j) {
                double time = 1.0*dist(taxis[i-1], people[j-1]);
                if(time < c || dEqual(time, c)) {
                    g.add(i, j + t);
                }
            }
        }

        int ans = bpm();
        out.println(ans);
    }

    Graph g;
    int []match; // matching person->taxi
    boolean []vst;
    int t, p;
    int bpm() {
        int max = 0;
        match = new int[g.V+1];
        Arrays.fill(match, -1);

        for(int u = 1; u <= t; ++u) {
            vst = new boolean[g.V+1];
            if(dfs(u))
                max++;
        }
        return max;
    }

    boolean dfs(int u) {
        // try every person
        for(Edge e = g.al[u].head; e != null; e = e.next) {
            int v = e.des;
            if(vst[v] || v <= t) continue;
            vst[v] = true;
            if(match[v] < 0 || dfs(match[v])) {
                match[v] = u;
                return true;
            }
        }
        return false;
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

    long dist(Pair a, Pair b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    boolean dEqual(double a, double b) {
        double e = 1e-7;
        return Math.abs(a - b) < e;
    }

    class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
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