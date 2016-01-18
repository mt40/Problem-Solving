package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_320B {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] readArr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i(), id = 1;
        boolean [][]graph = new boolean[n + 1][n + 1];
        Node []nodes = new Node[n + 1];
        for(int i = 0; i < n; ++i) {
            int t = in.i(), x = in.i(), y = in.i();
            if(t == 1)
                add(graph, nodes, new Node(x, y), id++);
            else
                out.println(find(graph, new boolean[n+1], x, y) ? "YES" : "NO");
        }
    }

    boolean find(boolean [][]graph, boolean []visit, int x, int y) {
        boolean rs = false;
        for(int i = 1; i < graph.length; ++i) {
            if(graph[x][i] && !visit[i]) {
                visit[i] = true;
                if(i == y) return true;
                rs = rs | find(graph, visit, i, y);
            }
        }
        return rs;
    }

    void add(boolean [][]graph, Node []nodes, Node nd, int j) {
        nodes[j] = nd;
        for(int i = 1; i < nodes.length; ++i) {
            if(nodes[i] == null) continue;
            Node x = nodes[i];
            if(mid(nd.a, x.a, nd.b) || mid(nd.a, x.b, nd.b))
                graph[i][j] = true;
            if(mid(x.a, nd.a, x.b) || mid(x.a, nd.b, x.b))
                graph[j][i] = true;
        }
    }

    boolean mid(int a, int b, int c) {
        return a < b && b < c;
    }

    class Node {
        int a, b;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
