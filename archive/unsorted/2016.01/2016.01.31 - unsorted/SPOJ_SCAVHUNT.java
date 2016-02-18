package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.*;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_SCAVHUNT {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        HashMap<String, Integer> map = new HashMap<>();
        String []ori = new String[n];
        BitSet bs = new BitSet(n);
        bs.set(0, n + 1);
        Graph g = new Graph(n);

        for(int i = 0; i < n - 1; ++i) {
            String a = in.s(), b = in.s();
            int ai = addStr(map, a);
            int bi = addStr(map, b);
            ori[ai] = a;
            ori[bi] = b;

            g.add(ai, bi);
            bs.set(bi, false);
        }

        int root = bs.nextSetBit(0);
        g.topo(root);

        out.printf("Scenario #%d:\n", testNumber);
        for(int v : g.topoRs)
            out.println(ori[v]);
        out.println();
    }

    int addStr(HashMap<String, Integer> map, String s) {
        int a_i = map.size();
        if(map.containsKey(s))
            a_i = map.get(s);
        else
            map.put(s, a_i);
        return a_i;
    }

    class Graph {
        int v;
        AdjList []al;

        public Graph(int v) {
            this.v = v;
            al = new AdjList[v];
            for(int i = 0; i < v; ++i) al[i] = new AdjList();
            vst = new boolean[v];
        }

        public void add(int src, int des) {
            Edge e = new Edge(des);
            e.next = al[src].head;
            al[src].head = e;
        }

        boolean []vst;
        Deque<Integer> topoRs = new LinkedList<>();
        void topo(int i) {
            vst[i] = true;
            for(Edge e = al[i].head; e != null; e = e.next) {
                if(vst[e.des]) continue;
                topo(e.des);
            }
            topoRs.addFirst(i);
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