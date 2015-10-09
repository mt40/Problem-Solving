package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class MatrixPow {
    /**
     * Matrix must be square
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = n, e = in.nextInt();
        Matrix mt = new Matrix(n, m);
        mt.readMatrix(in);

        out.println(pow(mt, e));
    }

    // exponent by squaring
    Matrix pow(Matrix base, int e) {
        int n = base.n, m = base.m;
        Matrix rs = createIdentityMatrix(n, m);
        while (e > 0) {
            if((e & 1) > 0)
                rs = mul(rs, base);
            base = mul(base, base);
            e >>= 1;
        }
        return rs;
    }

    Matrix createIdentityMatrix(int n, int m) {
        Matrix one = new Matrix(n, m);
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < m; ++j)
                one.array[i][j] = (i == j) ? 1 : 0;
        return one;
    }

    Matrix mul(Matrix a, Matrix b) {
        Matrix rs = new Matrix(a.n, b.m);
        for (int i = 0; i < a.n; ++i) {
            for (int j = 0; j < a.m; ++j) {
                for (int k = 0; k < b.m; ++k) {
                    rs.array[i][k] += a.array[i][j] * b.array[j][k];

                }
            }
        }
        return rs;
    }

    class Matrix {
        int n, m;
        int[][] array;

        public Matrix(int n, int m) {
            this.n = n;
            this.m = m;
            this.array = new int[n][m];
        }

        void readMatrix(Scanner in) {
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < m; ++j)
                    array[i][j] = in.nextInt();
        }

        @Override
        public String toString() {
            String s = "";
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j)
                    s += array[i][j] + " ";
                s += '\n';
            }
            return s;
        }
    }
}
