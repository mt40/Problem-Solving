package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class MatrixMul2 {
    /**
     * Revisit the matrix multiplication algorithm
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n1 = in.nextInt(), m1 = in.nextInt();
        int n2 = in.nextInt(), m2 = in.nextInt();

        Matrix mt1 = new Matrix(n1, m1), mt2 = new Matrix(n2, m2);
        mt1.readMatrix(in);
        mt2.readMatrix(in);

        out.print(mul(mt1, mt2));
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
