package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Deque;
import java.util.LinkedList;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_GNY07D {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), m = in.i();
        int [][]a = new int[n][m];
        char []s = in.c();
        for(int i = 0, idx = 0; i < n; ++i)
            for(int j = 0; j < m; ++j)
                a[i][j] = s[idx++]-'0';

        char []map = new char[27];
        map[0] = ' ';
        for(int i = 1; i <= 26; ++i)
            map[i] = (char)('A' + i - 1);

        Deque<Integer> deque = new LinkedList<>();
        int ci = 0, cj = 0, direction = 0;
        int [][]move = {
                {0,1}, // right
                {1,0}, // down
                {0,-1}, // left
                {-1,0}, // up
        };
        for(int i = 0; i < n*m; ++i) {
            deque.add(a[ci][cj]);
            if(shouldTurn(ci, cj, m, n))
                direction = (direction + 1) % 4;
            ci += move[direction][0];
            cj += move[direction][1];
        }

        StringBuilder sb = new StringBuilder();
        while(deque.size() >= 5) {
            int x = 0;
            for(int i = 0; i < 5; ++i)
                x = (x << 1) | deque.pollFirst();
            sb.append(map[x]);
        }

        out.print(testNumber + " ");
        out.println(sb);
    }

    boolean shouldTurn(int ci, int cj, int w, int h) {
        int dr = h - 1 - ci; // distance to vertical border
        int dc = w - 1 - cj; // distance to horizontal border
        boolean top = false, left = false;
        if(ci <= h - 1 - ci) {
            dr = ci;
            top = true;
        }
        if(cj < w - 1 - cj) {
            dc = cj;
            left = true;
        }
        // special case: top-left
        if(top && left) return dr - dc == 1;
        return dr == dc;
    }
}