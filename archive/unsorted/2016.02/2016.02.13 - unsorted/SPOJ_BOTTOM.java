package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Stack;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_BOTTOM {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n; // vertices
        while((n = in.i()) > 0) {
            int m = in.i(); // edges
            g = new Graph(n);
            for(int i = 0; i < m; ++i)
                g.add(in.i(), in.i());

            scc();

            boolean []isBottom = new boolean[g.V + 1];
            Arrays.fill(isBottom, true);
            for(int i = 1; i <= g.V; ++i) {
                for(Edge e = g.al[i].head; e != null; e = e.next) {
                    int j = e.des;
                    // For edge u->v if u & v are in different scc
                    // then the whole scc containing u is not in
                    // the answer
                    if(scc_map[i] != scc_map[j])
                        isBottom[scc_map[i]] = false;
                }
            }
            for(int i = 1; i <= g.V; ++i) {
                if(isBottom[scc_map[i]])
                    out.print(i + " ");
            }
            out.println();
        }
    }

    int []scc_map;
    Graph g;
    Stack<Integer> st;
    int g_num;
    int []num, low;
    void scc() {
        st = new Stack<>();
        g_num = 1;
        num = new int[g.V + 1];
        low = new int[g.V + 1];

        scc_map = new int[g.V + 1];

        for(int i = 1; i <= g.V; ++i) {
            if(num[i] > 0) continue;
            dfs(i);
        }
    }

    void dfs(int u) {
        num[u] = g_num++;
        low[u] = num[u]; // base case
        st.add(u);
        for(Edge e = g.al[u].head; e != null; e = e.next) {
            int v = e.des;
            if(num[v] > 0) // visited
                low[u] = Math.min(num[v], low[u]);
            else {
                dfs(v);
                low[u] = Math.min(low[v], low[u]);
            }
        }

        // found scc root
        if(num[u] == low[u]) {
            while(!st.isEmpty()) {
                int x = st.pop();
                scc_map[x] = u;
                if(x == u)
                    break;
            }
        }
    }

    class Graph {
        int V;
        AdjList []al;

        public Graph(int v) {
            V = v;
            al = new AdjList[v+1];
            for(int i = 1; i <= v; ++i)
                al[i] = new AdjList();
        }

        void add(int src, int des) {
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