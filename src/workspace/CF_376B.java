package workspace;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_376B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m =  in.nextInt();
        int [][]debts = new int[n + 1][n + 1];

        for(int i = 0; i < m; ++i) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            debts[a][b] = c;
        }

        /**
         * ý t??ng:
         * a --20--> b --10--> c : a n? b 20, b n? c 20 => a n? c 10 (a tr? dùm b)
         * a --10--> b --20--> c : a n? b 10, b n? c 20 => b n? c 10 (b l?y ti?n c?a a r?i m?i tra3 cho c)
         */

        for(int i = 1; i <= n; ++i) {
            for(int j = 1; j <= n; ++j) {
                if(debts[i][j] > 0) {
                    for(int k = 1; k <= n; ++k) {
                        if(debts[j][k] > 0) {
                            int delta = Math.min(debts[i][j], debts[j][k]);
                            debts[i][j] -= delta;
                            debts[j][k] -= delta;
                            debts[i][k] += delta;
                        }
                    }
                }
            }
        }

        int ans = 0;
        for(int i = 1; i <= n; ++i) {
            //System.out.println(Arrays.toString(debts[i]));
            for(int j = 1; j <= n; ++j) {
                ans += (i != j) ? debts[i][j] : 0;
            }
        }

        out.println(ans);
    }
}
