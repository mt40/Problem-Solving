package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_TOUR {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int [][]a = new int[n+1][];
        for(int i = 1; i <= n; ++i) {
            int m = in.i();
            a[i] = in.arr(m);
        }

        Graph g = new Graph(n);
        for(int i = 1; i <= n; ++i) {
            for(int j : a[i])
                g.add(j, i);
        }

        int ans = 0;
        for(int i = 1; i <= n; ++i) {
            if(bfs(g, i) == n)
                ans++;
        }

        out.println(ans);
    }

    int bfs(Graph g, int u) {
        int cnt = 1;
        boolean []vst = new boolean[g.V+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        vst[u] = true;
        while(!q.isEmpty()) {
            int x = q.poll();
            for(Edge e = g.al[x].head; e != null; e = e.next) {
                if(vst[e.des]) continue;
                q.add(e.des);
                vst[e.des] = true;
                cnt++;
            }
        }
        return cnt;
    }

    class Graph {
        int V;
        AdjList []al;

        public Graph(int v) {
            V = v;
            al = new AdjList[v+1];
            for(int i = 1; i <= v; ++i) al[i] = new AdjList();
        }

        void add(int src, int des) {
            Edge nd = new Edge(des);
            nd.next = al[src].head;
            al[src].head = nd;
        }
    }

    class Edge {
        int des;
        Edge next;

        public Edge(int val) {
            this.des = val;
        }
    }

    class AdjList {
        Edge head;
    }
}