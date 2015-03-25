package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class MatrixMultiplication {
    class Matrix {
        int [][]mat = new int[N][N];
    }

    int N;
    
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        N = in.nextInt();
        Matrix a = new Matrix();
        Matrix b = new Matrix();

        for(int i = 0; i < N; ++i)
            for(int j = 0; j < N; ++j)
                a.mat[i][j] = in.nextInt();

        for(int i = 0; i < N; ++i)
            for(int j = 0; j < N; ++j)
                b.mat[i][j] = in.nextInt();
        Matrix mul = matrixMul(a, b);
        print(mul, out);

        out.println();

        Matrix pow = matrixPow(a, 4);
        print(pow, out);
    }

    public void print(Matrix m, PrintWriter out) {
        for(int i = 0; i < N; ++i)
            out.println(Arrays.toString(m.mat[i]).replaceAll("(\\]|\\[|,)", ""));
    }

    public Matrix matrixMul(Matrix a, Matrix b) {
        Matrix ans = new Matrix();
        for(int i = 0; i < N; ++i) {
            for(int j = 0; j < N; ++j) {
                for(int k = 0; k < N; ++k)
                    ans.mat[i][j] += a.mat[i][k] * b.mat[k][j];
            }
        }
        return ans;
    }

    // Exponent by Squaring
    public Matrix matrixPow(Matrix base, int e) {
        Matrix ans = new Matrix();
        for(int i = 0; i < N; ++i)
            for(int j = 0; j < N; ++j)
                ans.mat[i][j] = (i == j) ? 1 : 0; // identity matrix

        while(e > 0) {
            if((e & 1) != 0)
                ans = matrixMul(ans, base);
            e >>= 1;
            base = matrixMul(base, base);
        }
        return ans;
    }
}
