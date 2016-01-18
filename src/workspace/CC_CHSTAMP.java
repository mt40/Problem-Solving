package workspace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class CC_CHSTAMP {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i(), m = in.i();
        int []a = in.arr(n);

        AdjList []g = new AdjList[5 * 10000 + 1];
        for(int i = 0; i < g.length; ++i) g[i] = new AdjList();
        for(int i = 0; i < m; ++i) {
            int d = in.i(), x = in.i(), y = in.i();
            add(g, x, y);
        }

        boolean []visit = new boolean[g.length];
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < g.length; ++i) {
            if(visit[i]) continue;
            int max = dfs(g, i, 0, visit, list);
            for(int j : list)
                g[j].max = max;
            list.clear();
        }

        long ans = 0;
        for(int i : a) {
            ans += g[i].max;
        }
        out.println(ans);
    }

    int dfs(AdjList []g, int x, int max, boolean []visit, List<Integer> list) {
        int mx = Math.max(x, max);
        visit[x] = true;
        list.add(x);
        for(Node nd = g[x].head; nd != null; nd = nd.next) {
            if(visit[nd.val]) continue;
            mx = Math.max(dfs(g, nd.val, mx, visit, list), mx);
        }
        return mx;
    }

    void add(AdjList []g, int a, int b) {
        Node nd = new Node(b);
        nd.next = g[a].head;
        g[a].head = nd;

        nd = new Node(a);
        nd.next = g[b].head;
        g[b].head = nd;
    }

    class AdjList {
        Node head;
        int max = 0;
    }

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
