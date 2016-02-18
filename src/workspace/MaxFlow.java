package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

import helperClasses.FastScanner;
import helperClasses.Util;

public class MaxFlow {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int v = in.i(), e = in.i();
        Graph g = new Graph(v);
        while(e-- > 0) {
            int src = in.i(), des = in.i(), cap = in.i();
            g.add(src, des, cap);
        }

        out.println(g.maxFlow());
    }

    class Graph {
        int v;
        AdjList []al;

        public Graph(int v) {
            this.v = v;
            al = new AdjList[v+1];
            for(int i = 1; i <= v; ++i) al[i] = new AdjList();
        }

        /**
         * Compute maximum flow from node 1 (source) to node v (sink)
         */
        int maxFlow() {
            int rs = 0;
            /* 'capacity' store the residue graph */
            int [][]capacity = new int[v+1][v+1];
            for(int i = 1; i <= v; ++i)
                for(Edge e = al[i].head; e != null; e = e.next)
                    capacity[i][e.des] = e.cap;

            while(true) {
                /* while we can find a path in the residue graph
                between node 1 (source) and v (sink) */
                int path_cap = findPath(capacity);
                if(path_cap == 0) break;
                rs += path_cap;
            }
            return rs;
        }

        private int findPath(int [][]capacity) {
            Queue<Integer> q = new LinkedList<>();
            boolean []vst = new boolean[v + 1];
            int []from = new int[v + 1]; // previous node
            q.add(1);
            vst[1] = true;

            WHILE:
            while(!q.isEmpty()) {
                int nd = q.poll();
                for(Edge e = al[nd].head; e != null; e = e.next) {
                    if(vst[e.des] || capacity[nd][e.des] == 0) continue;
                    q.add(e.des);
                    vst[e.des] = true;
                    from[e.des] = nd;
                    if(e.des == v) break WHILE;
                }
            }

            /* compute the path capacity
            (i.e the min capacity among the edges) */
            int nd = v, path_cap = inf;
            while(from[nd] > 0) {
                int prev = from[nd];
                path_cap = Math.min(capacity[prev][nd], path_cap);
                nd = prev;
            }

            /* update the residue graph */
            nd = v;
            while(from[nd] > 0) {
                int prev = from[nd];
                capacity[prev][nd] -= path_cap;
                capacity[nd][prev] += path_cap;
                nd = prev;
            }

            if(path_cap == inf) return 0; // no path is found
            return path_cap;
        }

        void add(int src, int des, int v) {
            Edge e = new Edge(des, v);
            e.next = al[src].head;
            al[src].head = e;

            // pseudo back-edge with capacity 0
            // in the real graph, this edge does not exist
            e = new Edge(src, 0);
            e.next = al[des].head;
            al[des].head = e;
        }

        class Edge {
            int des, cap; // capacity
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