package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.math.BigInteger;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_RABBIT1 {
    int inf = Integer.MAX_VALUE;

    final long [][]id = {{1,0},{0,1}};
    int mod = 1 << 20;
    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        long n = in.i();
        int m = in.i();
        mod = 1 << m;
        long ans = Fib(n);
        out.println(ans);
    }

    long Fib(long i) {
        if(i == 0 || i == 1) return 1;
        long [][]mat = {{0,1},{1,1}};
        long [][]f1 = {{1},{1}};
        long [][]fi = matMul(modPow(mat, i - 1), f1);
        return fi[1][0];
    }

    long [][] modPow(long [][]base, long e) {
        long [][]rs = id;
        while(e > 0) {
            if((e & 1) > 0)
                rs = matMul(rs, base);
            base = matMul(base, base);
            e >>= 1;
        }
        return rs;
    }

    long [][] matMul(long [][]a, long [][]b) {
        int r = a.length, c = b[0].length, ca = a[0].length;
        long [][]rs = new long[r][c];
        for(int i = 0; i < r; ++i)
            for(int j = 0; j < c; ++j)
                for(int k = 0; k < ca; ++k)
                    rs[i][j] = (rs[i][j] + (a[i][k]*b[k][j]) % mod) % mod;
        return rs;
    }
}