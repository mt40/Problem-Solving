package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_SAMER08C {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        while(true) {
            int n = in.i(), m = in.i();
            if(n * m == 0) return;

            int[][] a = in.arr(n, m);

            int[][] row = new int[n][m];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (j - 1 >= 0)
                        row[i][j] = row[i][j - 1];
                    int prev = (j - 2 >= 0) ? row[i][j - 2] : 0;
                    row[i][j] = Math.max(prev + a[i][j], row[i][j]);
                }
            }

            int[] col = new int[n];
            for (int i = 0; i < n; ++i) {
                if (i - 1 >= 0)
                    col[i] = col[i - 1];
                int prev = (i - 2 >= 0) ? col[i - 2] : 0;
                col[i] = Math.max(prev + Util.max(row[i]), col[i]);
            }

            int ans = Util.max(col);
            out.println(ans);
        }
    }
}