package workspace;

import java.util.Scanner;
import java.io.PrintWriter;
import helperClasses.ShortScanner;
import helperClasses.Util;

public class SPOJ_CHICAGO {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n;
        while((n = in.i()) > 0) {
            int m = in.i();
            double [][]g = new double[n + 1][n + 1];
            for(int i = 0; i < m; ++i) {
                int a = in.i(), b = in.i();
                g[a][b] = g[b][a] = in.i() / 100.0;
            }

            for(int k = 1; k <= n; ++k) {
                for(int i = 1; i <= n; ++i) {
                    for(int j = 1; j <= n; ++j) {
                        g[i][j] = Math.max(g[i][k] * g[k][j], g[i][j]);
                    }
                }
            }

            out.printf("%.6f percent\n", round(g[1][n] * 100));
        }
    }

    double round(double d) {
        return Math.round(d * 1000000.0) / 1000000.0;
    }
}
