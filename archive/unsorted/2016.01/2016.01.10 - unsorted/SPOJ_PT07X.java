package workspace;

import java.util.Scanner;
import java.io.PrintWriter;
import helperClasses.ShortScanner;
import helperClasses.Util;

public class SPOJ_PT07X {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i();
        Graph g = new Graph(n);
        for(int i = 0; i < n - 1; ++i)
            addEdge(g, in.i(), in.i());

        int [][]dp = new int[n+1][2];
        cal(g, dp, new boolean[n+1], 1); // take 1 as root
        out.println(Math.min(dp[1][0], dp[1][1]));
    }

    void cal(Graph g, int [][]dp, boolean []vst, int v) {
        vst[v] = true;
        dp[v][1] = 1;
        for(Edge e = g.arr[v].head; e != null; e = e.next) {
            if(!vst[e.dest]) {
                cal(g, dp, vst, e.dest);
                dp[v][0] += dp[e.dest][1];
                dp[v][1] += Math.min(dp[e.dest][0], dp[e.dest][1]);
            }
        }
    }

    void addEdge(Graph g, int src, int dest) {
        Edge e = new Edge(dest);
        e.next = g.arr[src].head;
        g.arr[src].head = e;

        e = new Edge(src);
        e.next = g.arr[dest].head;
        g.arr[dest].head = e;
    }

    class Graph {
        int v;
        AdjList []arr;

        public Graph(int v) {
            this.v = v;
            arr = new AdjList[v+1];
            for(int i = 1; i <= v; ++i) arr[i] = new AdjList();
        }
    }

    class AdjList {
        Edge head;
    }

    class Edge {
        int dest;
        Edge next;

        public Edge(int dest) {
            this.dest = dest;
        }
    }
}
