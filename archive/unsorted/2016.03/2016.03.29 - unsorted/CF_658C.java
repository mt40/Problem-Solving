package workspace;

import helperClasses.InputReader;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_658C {
    int inf = Integer.MAX_VALUE;
    PrintWriter out;
    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        this.out = out;
        int n = in.i(), diameter = in.i(), height = in.i();

        List<Edge> results = cal(n, diameter, height);

        if(results == null)
            out.println(-1);
        else {
            for(Edge e : results)
                out.printf("%d %d\n", e.u, e.v);
        }
    }

    List<Edge> cal(int n, int diameter, int height) {
        List<Edge> edges = new ArrayList<>();
        int u = 1, v = 2;
        for(int i = 0; i < height; ++i) {
            edges.add(new Edge(u, v));
            u = v;
            v++;
        }
        if(u > n) return null; // not enough nodes

        int curD = height, iHeight = 0;
        if(curD > diameter) return null; // too many nodes

        v = u + 1;
        u = 1;
        if (diameter == height && diameter > 1)
            u = 2;
        int iD = curD;
        for (; iD < diameter; ++iD, ++iHeight) {
            edges.add(new Edge(u, v));
            u = v;
            v++;
        }
        if (u > n || iHeight > height) return null; // not enough

        u = 1;
        if(diameter == height && diameter > 1) {
            u = 2;
            height--;
        }
        while(v <= n) {
            edges.add(new Edge(u, v++));
            if(diameter < height + 1)
                return null; // not enough height
        }
        return edges;
    }

    class Edge {
        int u, v;

        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }
}