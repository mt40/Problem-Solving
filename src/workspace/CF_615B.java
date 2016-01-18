package workspace;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.PrintWriter;
import helperClasses.ShortScanner;

public class CF_615B {
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i(), m = in.i();
        Graph g = new Graph(n);
        int []deg = new int[n];
        for(int i = 0; i < m; ++i) {
            int a = in.i() - 1, b = in.i() - 1;
            deg[a]++; deg[b]++;
            addEdge(g, a, b);
        }

        out.println(cal(g, deg));
    }

    long cal(Graph g, int []deg) {
        int []dp = new int[g.v];
        for(int i = 0; i < g.v; ++i) dp[i] = 1;
        for(int i = 0; i < g.v; ++i) {
            for(Edge e = g.arr[i].head; e != null; e = e.next) {
                if(e.dest > i) {
                    dp[e.dest] = Math.max(dp[i] + 1, dp[e.dest]);
                }
            }
        }

        long ans = 0;
        for(int i = 0; i < g.v; ++i) {
            ans = Math.max(1L * dp[i] * deg[i], ans);
        }
        return ans;
    }

    void addEdge(Graph g, int src, int dest) {
        Edge e = new Edge(dest);
        e.next = g.arr[src].head;
        g.arr[src].head = e;

        e = new Edge(src);
        e.next = g.arr[dest].head;
        g.arr[dest].head = e;
    }

    class Edge {
        int dest;
        Edge next;

        public Edge(int dest) {
            this.dest = dest;
        }
    }

    class AdjList {
        Edge head;
    }

    class Graph {
        int v;
        AdjList []arr;

        public Graph(int v) {
            this.v = v;
            arr = new AdjList[v];
            for(int i = 0; i < v; ++i) arr[i] = new AdjList();
        }
    }
}
