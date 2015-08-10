package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_229A {
    int INF = 99999999;
    int n, m;
    int [][]pos;
    char [][]a;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        a = new char[n][m];
        pos = new int[n][2]; // position of the first '1' from the left and from the right
        for (int i = 0; i < n; ++i) {
            String s = in.next();
            a[i] = s.toCharArray();
            pos[i][0] = Math.max(s.indexOf('1'), 0);
            pos[i][1] = s.lastIndexOf('1');
            if(pos[i][1] == -1)
                pos[i][1] = m - 1;
        }

        /**
         * table[i][j] = distance to the nearest 1 in row i
         */
        int[][] table = new int[n][m];
        for (int i = 0; i < n; ++i)
            Arrays.fill(table[i], INF);

        /*
        Vi du co truong hop:
        00111111
        10000000
        10000000
        10000000
        10000000
        10000000
        ^
        |
        vi du cot dau tien la cot dang xet
        nhu vay thi dap an tot nhat la 1
        nhung ma ket qua cua ong la 2 :D
        (tui doan la chuong trinh ong code se chay ra 2 :) )

         */

        for (int i = 0; i < n; ++i) {
            int one = INF;
            // go from left to right
            for (int j = 0; j < m; ++j) {
                one = update(table, i, (j + pos[i][0]) % m, one);
            }

            one = INF;
            // go from right to left
            for (int j = m - 1; j >= 0; --j) {
                one = update(table, i, (j + pos[i][1] + 1) % m, one);
            }
        }

        long ans = INF;
        // try each column
        for (int j = 0; j < m; ++j) {
            long moves = 0;
            for (int i = 0; i < n; ++i) {
                moves += table[i][j];
            }
            ans = Math.min(moves, ans);
        }

        if (ans == INF)
            out.println(-1);
        else
            out.println(ans);
    }

    int update(int[][] table, int i, int j, int one) {
        if (a[i][j] == '1') {
            one = j;
            table[i][j] = 0;
        } else if (one < INF) {
            int dif = Math.abs(j - one);
            table[i][j] = Math.min(Math.min(dif, m - dif), table[i][j]);
        }
        return one;
    }
}
