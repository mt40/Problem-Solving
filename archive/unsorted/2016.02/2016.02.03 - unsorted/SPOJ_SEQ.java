package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_SEQ {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int k = in.i();
        int []b = in.arr(k), c = in.arr(k);
        int n = in.i();
        int mod = 1000*1000*1000;

        if(n <= k)
            out.println(b[n - 1]);
        else {
            Mat base = Mat.get(k, k, c);
            Mat rs = modPow(base, n - k, mod);
            rs = rs.mul(Mat.getF(k, b), mod);
            long ans = rs.ar[rs.r - 1][0];

            out.println(ans);
        }
    }

    Mat modPow(Mat base, int e, int mod) {
        int n = base.r, m = base.c;
        Mat rs = Mat.identity(n, m);
        while(e > 0) {
            if((e & 1) > 0)
                rs = rs.mul(base, mod);
            base = base.mul(base, mod);
            e >>= 1;
        }

        return rs;
    }

    static class Mat {
        int r, c;
        long [][]ar;

        public Mat(int r, int c) {
            this.r = r;
            this.c = c;
            ar = new long[r][c];
        }

        static Mat get(int n, int m, int []c) {
            Mat rs = new Mat(n, m);
            for(int i = 0; i < m; ++i)
                rs.ar[n - 1][i] = c[m - i - 1];
            for(int i = n - 2, j = 1; i >= 0; --i, ++j)
                rs.ar[i][m - j] = 1;
            return rs;
        }

        static Mat getF(int n, int []b) {
            Mat rs = new Mat(n, 1);
            for(int i = 0; i < n; ++i)
                rs.ar[i][0] = b[i];
            return rs;
        }

        Mat mul(Mat mat, int mod) {
            assert(this.c == mat.r);

            Mat rs = new Mat(this.r, mat.c);
            for(int i = 0; i < r; ++i)
                for(int j = 0; j < mat.c; ++j)
                    for(int k = 0; k < c; ++k)
                        rs.ar[i][j] = (rs.ar[i][j] +
                                (ar[i][k] * mat.ar[k][j]) % mod) % mod;
            return rs;
        }

        static Mat identity(int n, int m) {
            Mat rs = new Mat(n, m);
            for(int i = 0, j = 0; i < n; ++i, ++j)
                rs.ar[i][j] = 1;
            return rs;
        }
    }
}