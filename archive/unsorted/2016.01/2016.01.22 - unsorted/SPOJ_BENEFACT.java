package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_BENEFACT {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        Graph g = new Graph(n);
        for(int i = 0; i < n-1; ++i)
            g.add(in.i(), in.i(), in.i());

        out.println(g.longestPath());
    }

    class Graph {
        int v;
        AdjList []al;

        public Graph(int v) {
            this.v = v;
            al = new AdjList[v + 1];
            for(int i = 1; i <= v; ++i) al[i] = new AdjList();

            vst = new boolean[v + 1];
        }

        boolean []vst;

        int longestPath() {
            return dfs(1).sub_rs;
        }

        Result dfs(int nd) {
            vst[nd] = true;
            int mx1 = 0, mx2 = 0, mx_sub = 0;
            for(Edge e = al[nd].head; e != null; e = e.next) {
                if(vst[e.des]) continue;
                Result rs = dfs(e.des);
                if(rs.mx_path + e.len > mx1) {
                    int tmp = mx1;
                    mx1 = rs.mx_path + e.len;
                    mx2 = Math.max(tmp, mx2);
                }
                else if(rs.mx_path + e.len > mx2) mx2 = rs.mx_path + e.len;
                mx_sub = Math.max(rs.sub_rs, mx_sub);
            }

            return new Result(Math.max(mx1, mx2), Math.max(mx1 + mx2, mx_sub));
        }

        void add(int src, int des, int len) {
            addUtil(src, des, len);
            addUtil(des, src, len);
        }

        void addUtil(int src, int des, int len) {
            Edge e = new Edge(des, len);
            e.next = al[src].head;
            al[src].head = e;
        }

        class Edge {
            int des, len;
            Edge next;

            public Edge(int des, int len) {
                this.des = des;
                this.len = len;
            }
        }

        class AdjList {
            Edge head;
        }
    }

    class Result {
        int mx_path, sub_rs;

        public Result(int mx_path, int sub_rs) {
            this.mx_path = mx_path;
            this.sub_rs = sub_rs;
        }
    }
}