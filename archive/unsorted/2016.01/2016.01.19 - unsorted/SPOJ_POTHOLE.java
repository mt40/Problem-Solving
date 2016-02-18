package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_POTHOLE {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        Graph g = new Graph(n);
        for(int i = 1; i <= n - 1; ++i) {
            int k = in.i();
            while(k-- > 0) {
                int des = in.i();
                g.add(i, des, (i == 1 || des == n) ? 1 : 100000);
            }
        }

        out.println(g.maxFlow());
    }

    class Graph {
        int v;
        AdjList []al;
        int [][]cap;

        public Graph(int v) {
            this.v = v;
            al = new AdjList[v+1];
            cap = new int[v+1][v+1];
            for(int i = 1; i <= v; ++i) al[i] = new AdjList();
        }

        int maxFlow() {
            int rs = 0;
            while(true) {
                int path_cap = findPath();
                if(path_cap == 0) break;
                rs += path_cap;
            }
            return rs;
        }

        int findPath() {
            boolean []vst = new boolean[v+1];
            int []from = new int[v + 1];
            Queue<Integer> q = new LinkedList<>();
            q.add(1);
            vst[1] = true;
            WHILE:
            while(!q.isEmpty()) {
                int nd = q.poll();
                for(Edge e = al[nd].head; e != null; e = e.next) {
                    if(vst[e.des] || cap[nd][e.des] == 0) continue;
                    q.add(e.des);
                    vst[e.des] = true;
                    from[e.des] = nd;
                    if(e.des == v) break WHILE; // reached destination
                }
            }

            int nd = v, rs = inf;
            while(from[nd] > 0) {
                int prev = from[nd];
                rs = Math.min(cap[prev][nd], rs);
                nd = prev;
            }

            nd = v;
            while(from[nd] > 0) {
                int prev = from[nd];
                cap[prev][nd] -= rs;
                cap[nd][prev] += rs;
                nd = prev;
            }

            return (rs == inf) ? 0 : rs;
        }

        void add(int src, int des, int cap) {
            Edge e = new Edge(des, cap);
            e.next = al[src].head;
            al[src].head = e;

            // pseudo back edge
            e = new Edge(src, 0);
            e.next = al[des].head;
            al[des].head = e;

            this.cap[src][des] = cap;
        }

        class Edge {
            int des, cap;
            Edge next;

            public Edge(int des, int cap) {
                this.des = des;
                this.cap = cap;
            }
        }

        class AdjList {
            Edge head;
        }
    }
}