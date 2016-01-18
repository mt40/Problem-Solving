package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_TOE1 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = 3;
        char [][]a = new char[n][n];
        for(int i = 0; i < n; ++i) {
            char []c = in.c();
            System.arraycopy(c, 0, a[i], 0, n);
        }

        int o = 0, x = 0;
        for(int i = 0; i < n; ++i) {
            for(char c : a[i]) {
                if(c == 'X') x++;
                if(c == 'O') o++;
            }
        }

        boolean ok = true;
        if(x - o < 0 || x - o > 1) ok = false;
        int o_win = check(a, 'O'), x_win = check(a, 'X');
        if(x_win > 2) ok = false;
        if(o_win > 1) ok = false;
        if(o_win == 1 && x > o) ok = false;
        if(x_win == 1 && x <= o) ok = false;

        out.println(ok ? "yes" : "no");
    }

    int check(char [][]a, char xo) {
        int win = 0;
        for(int i = 0; i < 3; ++i)
            if(a[i][0] == a[i][1] && a[i][1] == a[i][2] && a[i][2] == xo)
                win++;
        for(int i = 0; i < 3; ++i)
            if(a[0][i] == a[1][i] && a[1][i] == a[2][i] && a[2][i] == xo)
                win++;
        if(a[0][0] == a[1][1] && a[1][1] == a[2][2] && a[2][2] == xo)
            win++;
        if(a[0][2] == a[1][1] && a[1][1] == a[2][0] && a[2][0] == xo)
            win++;
        return win;
    }
}