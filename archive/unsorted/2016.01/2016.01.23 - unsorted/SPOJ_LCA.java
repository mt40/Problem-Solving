package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_LCA {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        Graph g = new Graph(n);
        for(int i = 1; i <= n; ++i) {
            int k = in.i();
            while(k-- > 0) {
                g.add(i, in.i());
            }
        }
        g.getInfo();

        int [][]anc = new int[n + 1][log(n)];
        preprocess(g, anc);

        int q = in.i();
        out.printf("Case %d:\n", testNumber);
        while(q-- > 0)
            out.println(lca(g, anc, in.i(), in.i()));
    }

    int lca(Graph g, int [][]anc, int u, int v) {
        // make u always the lower node
        if(g.lvl[u] < g.lvl[v]) {
            int tmp = u;
            u = v;
            v = tmp;
        }

        // bring u to the nearest level of v
        int log = log(g.v) - 1;
        for(int i = log; i >= 0; --i)
            if(g.lvl[u] - (1 << i) >= g.lvl[v])
                u = anc[u][i];
        if(u == v) return u; // if v is also the parent of u

        for(int i = log; i >= 0; --i) {
            if(anc[u][i] > 0 && anc[u][i] != anc[v][i]) {
                u = anc[u][i];
                v = anc[v][i];
            }
        }

        return g.par[u];
    }

    void preprocess(Graph g, int [][]anc) {
        for(int i = 1; i <= g.v; ++i)
            anc[i][0] = g.par[i];

        for(int j = 1; (1 << j) <= g.v; ++j)
            for(int i = 1; i <= g.v; ++i)
                anc[i][j] = anc[anc[i][j - 1]][j - 1];
    }

    int log(int x) {
        int rs = 0;
        while((1 << rs) <= x)
            rs++;
        return rs;
    }

    class Graph {
        int v;
        AdjList []al;
        int []lvl; // smaller level = nearer to root
        int []par; // parent

        public Graph(int v) {
            this.v = v;
            al = new AdjList[v + 1];
            for(int i = 1; i <= v; ++i) al[i] = new AdjList();
            lvl = new int[v + 1];
            par = new int[v + 1];
        }

        void getInfo() {
            boolean []vst = new boolean[v + 1];
            Queue<Integer> q = new LinkedList<>();
            q.add(1);
            vst[1] = true;
            while(!q.isEmpty()) {
                int nd = q.poll();
                for(Edge e = al[nd].head; e != null; e = e.next) {
                    if(vst[e.des]) continue;
                    vst[e.des] = true;
                    q.add(e.des);
                    par[e.des] = nd;
                    lvl[e.des] = lvl[nd] + 1;
                }
            }
        }

        void add(int src, int des) {
            addUtil(src, des);
            //addUtil(des, src);
        }

        private void addUtil(int src, int des) {
            Edge e = new Edge(des);
            e.next = al[src].head;
            al[src].head = e;
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
}