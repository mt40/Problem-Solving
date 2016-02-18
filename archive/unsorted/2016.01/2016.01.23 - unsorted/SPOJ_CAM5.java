package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_CAM5 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), e = in.i();
        Graph g = new Graph(n);
        while(e-- > 0)
            g.add(in.i(), in.i());

        out.println(g.cc());
    }

    class Graph {
        int v;
        AdjList []al;

        public Graph(int v) {
            this.v = v;
            al = new AdjList[v + 1];
            for(int i = 0; i < v; ++i) al[i] = new AdjList();
        }

        int cc() {
            boolean []vst = new boolean[v];
            int ans = 0;
            for(int i = 0; i < v; ++i) {
                if(vst[i]) continue;
                dfs(i, vst);
                ans++;
            }
            return ans;
        }

        private void dfs(int nd, boolean []vst) {
            for(Edge e = al[nd].head; e != null; e = e.next) {
                if(vst[e.des]) continue;
                vst[e.des] = true;
                dfs(e.des, vst);
            }
        }

        void add(int src, int des) {
            addUtil(src, des);
            addUtil(des, src);
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