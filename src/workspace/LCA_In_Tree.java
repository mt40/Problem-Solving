package workspace;

import helperClasses.FastScanner;
import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import helperClasses.ShortScanner;
import helperClasses.Util;

public class LCA_In_Tree {
    int inf = Integer.MAX_VALUE;

    /**
     * Tree is an undirected acyclic graph
     * This is DP approach runs in O(nlogn) (preprocess), O(logn) (query)
     * ref: https://www.topcoder.com/community/data-science/data-science-tutorials/range-minimum-query-and-lowest-common-ancestor/#Another%20easy%20solution%20in%20O(N%20logN,%20O(logN)
     * There is another solution runs in <O(N), O(sqrtN)> and is easier to implement
     */
    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), m = n - 1; // number of vertices and edges
        int q = in.i(); // query
        Graph g = new Graph(n);
        for(int i = 0; i < m; ++i) {
            int a = in.i(), b = in.i();
            g.add(a, b);
        }
        g.scan();

        //System.out.println(Arrays.toString(g.p));
        //System.out.println(Arrays.toString(g.lvl));

        int [][]anc = new int[n + 1][log(n)];
        preprocess(g, anc);

        //System.out.println();
        //for(int []i : anc) System.out.println(Arrays.toString(i));

        while(q-- > 0) {
            int x = in.i(), y = in.i();
            out.println(lca(g, anc, x, y));
        }
    }

    /**
     * Find Lowest Common Ancestor of 2 nodes x & y
     */
    int lca(Graph g, int [][]anc, int x, int y) {
        // make sure x is always the lower node (easier to code)
        if(g.lvl[x] < g.lvl[y]) { int tmp = y; y = x; x = tmp; }

        int log = log(g.v) - 1;
        // bring x up to the nearest level below y (or same level of y)
        for(int i = log; i >= 0; --i) {
            if(g.lvl[x] - (1 << i) >= g.lvl[y])
                x = anc[x][i];
        }
        if(x == y) return x;

        // compute LCA
        for(int i = log; i >= 0; --i) {
            if(anc[x][i] > 0 && anc[x][i] != anc[y][i]) {
                x = anc[x][i];
                y = anc[y][i];
            }
        }
        return g.p[x];
    }

    /**
     * Pre-process
     * @param anc ancestor
     */
    void preprocess(Graph g, int [][]anc) {
        int n = g.v;
        // the 1st ancestor is its direct parent
        for(int i = 1; i <= n; ++i)
            anc[i][0] = g.p[i];

        // construct the ancestor array
        for(int j = 1; (1 << j) <= n; ++j) {
            for(int i = 1; i <= n; ++i) {
                if(anc[i][j - 1] > 0) // i is not root
                    anc[i][j] = anc[anc[i][j - 1]][j - 1];
            }
        }
    }

    int log(int n) {
        int rs = 0;
        for(; (1 << rs) <= n; rs++);
        return rs;
    }

    class Graph {
        int v;
        AdjList []al;
        int []p, lvl; // parent, level

        public Graph(int v) {
            this.v = v;
            al = new AdjList[v + 1];
            p = new int[v + 1];
            lvl = new int[v + 1];
            for(int i = 1; i <= v; ++i) al[i] = new AdjList();
        }

        void add(int src, int des) {
            Edge e = new Edge(des);
            e.next = al[src].head;
            al[src].head = e;

            e = new Edge(src);
            e.next = al[des].head;
            al[des].head = e;
        }

        // scan to update parent array (use BFS)
        void scan() {
            boolean []vst = new boolean[v+1];
            Queue<Integer> q = new LinkedList<>();
            q.add(1); vst[1] = true;
            while(!q.isEmpty()) {
                int cur = q.poll();
                for(Edge e = al[cur].head; e != null; e = e.next) {
                    if(vst[e.dest]) continue;
                    q.add(e.dest);
                    p[e.dest] = cur;
                    lvl[e.dest] = lvl[cur] + 1;
                    vst[e.dest] = true;
                }
            }
        }
    }

    class AdjList {
        Edge head;
    }

    class Edge {
        int dest;
        Edge next;

        public Edge(int dest) {
            this.dest = dest;
        }
    }
}
