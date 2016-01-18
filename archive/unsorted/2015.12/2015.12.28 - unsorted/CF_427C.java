package workspace;

import java.util.*;
import java.io.PrintWriter;

public class CF_427C {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;
    int mod = 1000000007;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i();
        int []cost = new int[n+1];
        for(int i = 1; i <= n; ++i) cost[i] = in.i();
        int m = in.i();
        Graph g = new Graph(n);
        while(m-- > 0) {
            addEdge(g, in.i(), in.i());
        }

        long []ans = scc(g, cost);
        out.printf("%d %d\n", ans[0], ans[1]);
    }

    long[] scc(Graph g, int []cost) {
        long ans = 1, total = 0;
        List<Integer> rs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean []visit = new boolean[g.v+1];
        for(int i = 1; i <= g.v; ++i)
            if(!visit[i])
                dfs(g, q, visit, i);
        Arrays.fill(visit, false);
        while(q.size() > 0) {
            int nd = q.poll();
            if(visit[nd]) continue;
            List<Integer> cc = new ArrayList<>();
            int min = traverse(g, visit, cost, nd, cc);
            int cnt = 0;
            for(int tmp : cc)
                if(cost[tmp] == min) cnt++;
            rs.add(cnt);
            total += min;
        }
        for(int i : rs) {
            ans = (ans%mod * i%mod)%mod ;
        }
        return new long[]{total, ans};
    }

    int traverse(Graph g, boolean []visit, int []cost, int nd, List<Integer> cc) {
        int min = cost[nd];
        cc.add(nd);
        visit[nd] = true;
        Edge e = g.arr[nd].head;
        while(e != null) {
            if(!visit[e.dest])
                min = Math.min(traverse(g, visit, cost, e.dest, cc), min);
            e = e.next;
        }
        return min;
    }

    void dfs(Graph g, Queue q, boolean []visit, int nd) {
        visit[nd] = true;
        Edge e = g.arr[nd].head;
        while(e != null) {
            if(!visit[e.dest]) {
                dfs(g, q, visit, e.dest);
            }
            e = e.next;
        }
        q.add(nd);
    }

    void addEdge(Graph g, int src, int dest) {
        Edge e = new Edge();
        e.dest = dest;
        e.next = g.arr[src].head;
        g.arr[src].head = e;
    }

    class Graph {
        int v;
        AdjList []arr;

        public Graph(int v) {
            this.v = v;
            arr = new AdjList[v + 1];
            for(int i = 1; i <= v; ++i) arr[i] = new AdjList();
        }
    }

    class Edge {
        int dest;
        Edge next;
    }

    class AdjList {
        Edge head;
    }
}
