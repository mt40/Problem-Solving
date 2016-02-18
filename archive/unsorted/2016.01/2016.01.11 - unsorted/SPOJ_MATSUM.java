package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_MATSUM {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int[][] a = new int[n][n];
        Bit2d bit = new Bit2d(n);
        String s;
        while (!(s = in.s()).equals("END")) {
            if (s.equals("SET")) {
                int x = in.i(), y = in.i(), val = in.i();
                int dif = val - a[x][y];
                a[x][y] = val;
                bit.update(x, y, dif);
            }
            else if (s.equals("SUM")) {
                int x1 = in.i(), y1 = in.i(), x2 = in.i(), y2 = in.i();
                long s1 = bit.sum(x2, y2);
                long s2 = bit.sum(x1 - 1, y2) + bit.sum(x2, y1 - 1);
                long s3 = bit.sum(x1 - 1, y1 - 1);
                out.println(s1 - s2 + s3);
            }
        }
    }

    class Bit2d {
        int size;
        long[][] mat;

        public Bit2d(int size) {
            this.size = size + 1;
            mat = new long[size + 1][size + 1];
        }

        void update(int x, int y, int val) {
            x++;
            y++;
            while (x < size) {
                int j = y;
                while (j < size) {
                    mat[x][j] += val;
                    j += j & (-j);
                }
                x += x & (-x);
            }
        }

        long sum(int x, int y) {
            if (x < 0 || y < 0) return 0;
            x++;
            y++;
            long ans = 0;
            while (x > 0) {
                int j = y;
                while (j > 0) {
                    ans += mat[x][j];
                    j -= j & (-j);
                }
                x -= x & (-x);
            }
            return ans;
        }

    }
}