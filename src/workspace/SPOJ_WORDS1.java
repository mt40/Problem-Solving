package workspace;

import java.util.Scanner;
import java.io.PrintWriter;
import helperClasses.ShortScanner;

public class SPOJ_WORDS1 {
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i();
        int []in_deg = new int[26], out_deg = new int[26];
        boolean [][]g = new boolean[26][26];
        boolean []vst = new boolean[26];
        int v = 0;
        for(int i = 0; i < n; ++i) {
            char []c = in.c();
            int a = c[0]-'a', b = c[c.length - 1]-'a';
            if(!vst[a]) v++; vst[a] = true;
            if(!vst[b]) v++; vst[b] = true;
            out_deg[a]++;
            in_deg[b]++;
            g[a][b] = true;
        }

        boolean ok = true;
        int start = -1, end = -1;
        for(int i = 0; i < 26; ++i) {
            if(in_deg[i] == out_deg[i]) continue;
            if(in_deg[i] - out_deg[i] == 1 && end == -1)
                end = i;
            else if(in_deg[i] - out_deg[i] == -1 && start == -1)
                start = i;
            else ok = false;
        }

        vst = new boolean[26];
        dfs(g, start, vst);
        int cnt = 0;
        for(boolean b : vst) if(b) cnt++;
        if(cnt != v) ok = false;

        if(ok) out.println("Ordering is possible.");
        else out.println("The door cannot be opened.");
    }

    void dfs(boolean [][]graph, int start, boolean []vst) {
        if(start < 0) start = 0;
        vst[start] = true;
        for(int i = 0; i < graph.length; ++i) {
            if(vst[i] || i == start || !graph[start][i]) continue;
            dfs(graph, i, vst);
        }
    }
}
