package workspace;

import java.util.*;
import java.io.PrintWriter;

public class CF_246D {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i(), m = in.i();
        int []c = in.arr(n);
        Graph g = new Graph(n);
        for(int i = 0; i < m; ++i) {
            int src = in.i(), dest = in.i();
            addEdge(g, src, dest);
        }
        List<HashSet<Integer>> rs = bfs(g, c);
        int ans = c[0], mx = rs.get(c[0]).size();
        for(int i = 1; i < n; ++i) {
            int size = rs.get(c[i]).size();
            if(size > mx || (size == mx && c[i] < ans)) {
                ans = c[i];
                mx = size;
            }
        }
        out.println(ans);
    }

    List<HashSet<Integer>> bfs(Graph g, int []color) {
        List<HashSet<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= 100000; ++i) list.add(new HashSet<Integer>());

        boolean []visit = new boolean[g.v + 1];
        Queue<Integer> q = new LinkedList<>();
        for(int v = 1; v <= g.v; ++v) { // for disconnected graph
            if(visit[v]) continue;
            q.add(v);
            visit[v] = true;
            while (q.size() > 0) {
                int i = q.poll();
                //System.out.printf("%d:%d ", i, color[i-1]);
                Edge e = g.arr[i].head;
                int c = color[i - 1];
                while (e != null) {
                    if (!visit[e.dest])
                        q.add(e.dest);
                    if (color[e.dest - 1] != c) list.get(c).add(color[e.dest - 1]);
                    visit[e.dest] = true;
                    e = e.next;
                }
            }
        }
        //System.out.println();
        return list;
    }

    void addEdge(Graph g, int src, int dest) {
        Edge e = new Edge(dest);
        e.next = g.arr[src].head;
        g.arr[src].head = e;

        e = new Edge(src);
        e.next = g.arr[dest].head;
        g.arr[dest].head = e;
    }

    class Graph {
        AdjList []arr;
        int v;

        public Graph(int v) {
            this.v = v;
            arr = new AdjList[v + 1];
            for(int i = 1; i <= v; ++i) arr[i] = new AdjList();
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
