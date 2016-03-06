package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_FIBOSUM {
    int inf = Integer.MAX_VALUE;
    int mod = 1000*1000*1000+7;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), m = in.i();
        long l = sum(n - 1), r = sum(m);
        long ans = (r - l + mod) % mod;
        out.println(ans);
    }

    long sum(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        Mat T = new Mat(new int[][]{
                {0,1,0},
                {1,1,0},
                {1,1,1}
        });
        Mat one = new Mat(new int[][] {
                {0},{1},{1}
        });
        return mul(pow(T, n - 1), one).arr[2][0];
    }

    Mat pow(Mat base, int e) {
        Mat rs = Mat.id(base.r);
        while(e > 0) {
            if((e & 1) > 0)
                rs = mul(base, rs);
            e >>= 1;
            base = mul(base, base);
        }
        return rs;
    }

    Mat mul(Mat a, Mat b) {
        Mat rs = new Mat(a.r, b.c);
        for(int i = 0; i < a.r; ++i)
            for(int j = 0; j < b.c; ++j)
                for(int k = 0; k < a.c; ++k)
                    rs.arr[i][j] = (rs.arr[i][j] + ((a.arr[i][k] % mod) * (b.arr[k][j]) % mod) % mod) % mod;
        return rs;
    }

    static class Mat {
        int r, c;
        long [][]arr;

        public Mat(int [][]src) {
            r = src.length;
            c = (r > 0) ? src[0].length : 0;
            arr = new long[r][c];
            for(int i = 0; i < r; ++i)
                for(int j = 0; j < c; ++j)
                    arr[i][j] = src[i][j];
        }

        public Mat(int r, int c) {
            this.r = r;
            this.c = c;
            arr = new long[r][c];
        }

        static Mat id(int r) {
            Mat rs = new Mat(r, r);
            for(int i = 0; i < r; ++i)
                rs.arr[i][i] = 1;
            return rs;
        }
    }
}