package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_QUEST4 {
    int inf = Integer.MAX_VALUE;

    /**
     * I tried 2 approaches: DP and bipartite matching but failed
     * Can't figure out where is the bug...
     * ref: http://www.geeksforgeeks.org/maximum-bipartite-matching/
     */
    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        g = new Graph(120+120);
        gg = new boolean[120][120];
        for(int i = 0; i < n; ++i) {
            int r = in.i(), c = in.i();
            g.add(r, 120 + c);
            gg[r][c] = true;
        }

        dp = new long[g.V][2];
        vst = new boolean[g.V];
        int ans = 0;
//        for(int i = 0; i < g.V; ++i) {
//            if(!vst[i]) {
//                cal(i);
//                ans += Math.min(dp[i][0], dp[i][1]);
//            }
//        }
        ans = maxBPM();

        out.println(ans);
    }

    boolean [][]gg;
    long [][]dp;
    Graph g;
    boolean []vst;
    void cal(int v) {
        vst[v] = true;
        dp[v][1] = 1; // if we choose v
        for (Edge e = g.al[v].head; e != null; e = e.next) {
            if (!vst[e.des]) {
                cal(e.des);
                dp[v][0] += dp[e.des][1];
                dp[v][1] += Math.min(dp[e.des][0], dp[e.des][1]);
            }
        }
    }

    /* Bipartite matching approach */
    int []match;
    boolean bpm(int u) {
        for (int v = 0; v < 120; ++v) {
            if (!vst[v] && gg[u][v]) {
                vst[v] = true;
                if (match[v] < 0 || bpm(v)) {
                    match[v] = u;
                    return true;
                }
            }
        }
        return false;
    }

    int maxBPM() {
        match = new int[120];
        Arrays.fill(match, -1);

        int rs = 0;
        for(int u = 0; u < 120; ++u) {
            vst = new boolean[120];
            if(bpm(u))
                rs++;
        }
        return rs;
    }

    class Graph {
        int V;
        AdjList []al;

        public Graph(int v) {
            V = v;
            al = new AdjList[v];
            for(int i = 0; i < v; ++i)
                al[i] = new AdjList();
        }

        void add(int src, int des) {
            addEdge(src, des);
            addEdge(des, src);
        }

        private void addEdge(int src, int des) {
            Edge e = new Edge(des);
            e.next = al[src].head;
            al[src].head = e;
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