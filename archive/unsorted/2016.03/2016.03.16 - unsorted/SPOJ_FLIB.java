package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_FLIB {
    int inf = Integer.MAX_VALUE;
    int mod = 1000*1000*1000+7;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        long n = in.l();

        long [][]src = {{2,3,0}, {3,5,0}, {1,0,1}};
        long [][]begin = {{2}, {3}, {0}};
        Mat M = new Mat(src);
        Mat g = new Mat(begin);
        M = M.pow(n);
        Mat ans = M.mul(g);
        out.println(ans.a[2][0]);
    }

    class Mat {
        int rows, cols;
        long [][]a;

        public Mat(int rows, int cols) {
            this.rows = rows;
            this.cols = cols;
            a = new long[rows][cols];
            for(int i = 0; i < rows; ++i)
                for(int j = 0; j < cols; ++j)
                    if(i == j) a[i][j] = 1;
        }

        public Mat(long [][]src) {
            this(src.length, src[0].length);
            for(int i = 0; i < rows; ++i)
                System.arraycopy(src[i], 0, a[i], 0, cols);
        }

        Mat mul(Mat other) {
            Mat rs = new Mat(rows, other.cols);
            for(int i = 0; i < rows; ++i) {
                for(int j = 0; j < other.cols; ++j) {
                    long sum = 0;
                    for(int k = 0; k < other.rows; ++k) {
                        sum = sum + ((a[i][k] * other.a[k][j]) % mod);
                        if(sum >= mod) sum -= mod;
                    }
                    rs.a[i][j] = sum;
                }
            }
            return rs;
        }

        Mat pow(long e) {
            Mat rs = new Mat(rows, cols);
            Mat base = this;
            while(e > 0) {
                if((e & 1) > 0)
                    rs = rs.mul(base);
                base = base.mul(base);
                e >>= 1;
            }
            return rs;
        }
    }
}