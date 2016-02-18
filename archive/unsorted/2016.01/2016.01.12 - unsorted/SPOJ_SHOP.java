package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_SHOP {
    int inf = Integer.MAX_VALUE;
    int n, m;
    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        while(true) {
            m = in.i();
            n = in.i();
            if(m * n == 0) return;
            char[][] a = new char[n][m];
            int src = 0, des = 0;
            for (int i = 0; i < n; ++i) {
                char[] c = in.c();
                for (int j = 0; j < m; ++j) {
                    a[i][j] = (c[j] == 'S' || c[j] == 'D') ? '0' : c[j];
                    if (c[j] == 'S') src = i * m + j;
                    if (c[j] == 'D') des = i * m + j;
                }
            }

            int v = n * m;
            int[][] g = new int[v][v];
            for (int i = 0; i < v; ++i) Arrays.fill(g[i], -1);
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (a[i][j] == 'X') continue;
                    int vt = id(i, j);
                    if (j > 0 && a[i][j - 1] != 'X') {
                        g[vt][vt - 1] = a[i][j] - '0';
                    }
                    if (j < m - 1 && a[i][j + 1] != 'X') {
                        g[vt][vt + 1] = a[i][j] - '0';
                    }
                    if (i > 0 && a[i - 1][j] != 'X') {
                        g[vt][vt - m] = a[i][j] - '0';
                    }
                    if (i < n - 1 && a[i + 1][j] != 'X') {
                        g[vt][vt + m] = a[i][j] - '0';
                    }
                }
            }

            out.println(Djisktra(g, v, src, des));
        }
    }

    int id(int i, int j) {
        return i * m + j;
    }

    int Djisktra(int [][]g, int n, int src, int des) {
        boolean []vst = new boolean[n];
        int []dt = new int[n];
        Arrays.fill(dt, inf);
        dt[src] = 0;
        int cur = src;
        while(cur != des) {
            vst[cur] = true;
            for(int i = 0; i < n; ++i) {
                if(vst[i]) continue;
                if(g[cur][i] >= 0)
                    dt[i] = Math.min(dt[cur] + g[cur][i], dt[i]);
            }
            cur = minArr(dt, vst);
        }
        return dt[des];
    }

    int minArr(int []a, boolean []vst) {
        int rs = -1;
        for(int i = 0; i < a.length; ++i)
            if((rs < 0 || a[i] < a[rs]) && !vst[i])
                rs = i;
        return rs;
    }
}