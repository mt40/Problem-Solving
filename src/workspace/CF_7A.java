package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_7A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = 8;
        char [][]a = new char[n][n];
        for(int i = 0; i < n; i++) {
            String s = in.next();
            a[i] = s.toCharArray();
        }

        int ans = 0;
        boolean [][]check = new boolean[n][n];
        // consider all columns first
        for(int j = 0; j < n; ++j) {
            if(a[0][j] == 'B') {
                boolean draw = true;
                for(int i = 1; i < n; ++i) {
                    if(a[i][j] == 'W')
                        draw = false;
                }
                if(draw) {
                    // mark this column already drawn
                    for(int i = 0; i < n; ++i) {
                        check[i][j] = true;
                    }
                    ans++;
                }
            }
        }

        // consider all rows
        for(int i = 0; i < n; ++i) {
            boolean draw = false;
            for(int j = 0; j < n; ++j) {
                if(a[i][j] == 'B' && check[i][j] == false) {
                    draw = true;
                }
            }
            if(draw)
                ans++;
        }

        out.println(ans);
    }
}
