package workspace;


import java.util.*;
import java.io.PrintWriter;

public class CF_329B {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i(), m = in.i();
        char [][]g = new char[n][m];
        for(int i = 0; i < n; ++i) g[i] = in.c();

        int ex = 0, ey = 0;
        L1: for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                if(g[i][j] == 'E') {
                    ex = i; ey = j;
                    break L1;
                }
            }
        }

        List<Pair> opp = new ArrayList<>(); // distance of opponents to exit
        int me = bfs(g, opp, n, m, new Node(ex, ey)); // distance of me to exit
        int ans = 0;
        for(Pair p : opp) {
            if(p.d <= me) ans += p.cnt;
        }

        out.println(ans);
    }

    int bfs(char [][]g, List<Pair> opp, int r, int c, Node exit) {
        Queue<Node> q = new LinkedList<>();
        boolean [][]visit = new boolean[r][c];
        int player = inf;
        q.add(exit);
        visit[exit.x][exit.y] = true;
        while(q.size() > 0) {
            Node nd = q.poll();
            char cell = g[nd.x][nd.y];
            if(cell == 'S')
                player = nd.d;
            else if(Character.isDigit(cell) && cell - '0' > 0)
                opp.add(new Pair(nd.d, cell-'0'));
            for(Node nb : neighbors(g, nd.x, nd.y)) {
                if(!visit[nb.x][nb.y]) {
                    q.add(nb);
                    visit[nb.x][nb.y] = true;
                    nb.d = nd.d + 1;
                }
            }
        }
        return player;
    }

    List<Node> neighbors(char [][]g, int i, int j) {
        List<Node> rs = new ArrayList<>();
        if(valid(g, i - 1, j)) rs.add(new Node(i - 1, j));
        if(valid(g, i, j - 1)) rs.add(new Node(i, j - 1));
        if(valid(g, i + 1, j)) rs.add(new Node(i + 1, j));
        if(valid(g, i, j + 1)) rs.add(new Node(i, j + 1));
        return rs;
    }

    boolean valid(char [][]g, int i, int j) {
        return i >= 0 && i < g.length && j >= 0 && j < g[0].length && g[i][j] != 'T';
    }

    class Node {
        int x, y, d;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class Pair {
        int d, cnt;

        public Pair(int d, int cnt) {
            this.d = d;
            this.cnt = cnt;
        }
    }
}
