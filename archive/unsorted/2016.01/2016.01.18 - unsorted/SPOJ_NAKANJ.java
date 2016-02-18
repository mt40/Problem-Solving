package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_NAKANJ {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        char []a = in.c(), b = in.c();
        int x1 = a[0]-'a'+1, y1 = a[1]-'0';
        x2 = b[0]-'a'+1;
        y2 = b[1]-'0';
        ops = 0;
        ans = 64;
        dp = new int[9][9];
        for(int []dpi : dp) Arrays.fill(dpi, 64);
        if(x1 == x2 && y1 == y2)
            ans = 0;
        else
            cal(x1, y1, 0);
        out.println(ans);
        //System.out.printf("%d operations\n", ops);
    }

    int ans = 64, x2, y2, ops = 0;
    int [][]dp;
    void cal(int x, int y, int moves) {
        ops++;
        if(x == x2 && y == y2) {
            ans = Math.min(moves, ans);
            return;
        }
        dp[x][y] = moves;

        if(x - 2 > 0 && y + 1 < 9 && moves + 1 < dp[x - 2][y + 1])
            cal(x - 2, y + 1, moves + 1);

        if(x - 1 > 0 && y + 2 < 9 && moves + 1 < dp[x - 1][y + 2])
            cal(x - 1, y + 2, moves + 1);

        if(x + 1 < 9 && y + 2 < 9 && moves + 1 < dp[x + 1][y + 2])
            cal(x + 1, y + 2, moves + 1);

        if(x + 2 < 9 && y + 1 < 9 && moves + 1 < dp[x + 2][y + 1])
            cal(x + 2, y + 1, moves + 1);

        if(x + 2 < 9 && y - 1 > 0 && moves + 1 < dp[x + 2][y - 1])
            cal(x + 2, y - 1, moves + 1);

        if(x + 1 < 9 && y - 2 > 0 && moves + 1 < dp[x + 1][y - 2])
            cal(x + 1, y - 2, moves + 1);

        if(x - 1 > 0 && y - 2 > 0 && moves + 1 < dp[x - 1][y - 2])
            cal(x - 1, y - 2, moves + 1);

        if(x - 2 > 0 && y - 1 > 0 && moves + 1 < dp[x - 2][y - 1])
            cal(x - 2, y - 1, moves + 1);
    }
}