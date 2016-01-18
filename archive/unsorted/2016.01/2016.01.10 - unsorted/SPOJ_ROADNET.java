package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;
import helperClasses.ShortScanner;
import helperClasses.Util;

public class SPOJ_ROADNET {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i();
        int [][]g = new int[n][n];
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < n; ++j)
                g[i][j] = in.i();

        boolean [][]ans = new boolean[n][n];
        for(boolean []b : ans) Arrays.fill(b, true);
        for(int k = 0; k < n; ++k) {
            for(int i = 0; i < n; ++i) {
                for(int j = 0; j < n; ++j) {
                    if(g[i][j] == g[i][k] + g[k][j] && k != i && k != j)
                        ans[i][j] = ans[j][i] = false;
                }
            }
        }

        for(int i = 0; i < n; ++i) {
            for(int j = i + 1; j < n; ++j) {
                if(ans[i][j]) out.printf("%d %d\n", i + 1, j + 1);
            }
        }
    }
}
