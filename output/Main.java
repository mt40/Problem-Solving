import java.util.Scanner;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author mthai
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		MaxSumMatrix solver = new MaxSumMatrix();
		solver.solve(1, in, out);
		out.close();
	}
}

class MaxSumMatrix {
    int N, M;
    int [][]arr;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        N = in.nextInt(); M = in.nextInt();
        arr = new int[N + 3][M + 3];
        for(int i = 0; i < N; ++i) {
            for(int j = 0; j < M; ++j) {
                arr[i][j] = in.nextInt();
            }
        }
        
        int [][]sumMatrix = genSumMatrix();
        
        for(int i = 0; i < N; ++i) {
            for(int j = 0; j < M; ++j) {
                out.print(sumMatrix[i][j] + " ");
            }
            out.println("");
        }
    }

    public int[][] genSumMatrix() {
        int [][] sumMatrix = new int[N + 3][M + 3];
        for(int i = 0; i < N; ++i) {
            for(int j = 0; j < M; ++j) {
                if(i > 0) sumMatrix[i][j] += sumMatrix[i - 1][j]; // upper matrix
                if(j > 0) sumMatrix[i][j] += sumMatrix[i][j - 1]; // left matrix
                if(i > 0 && j > 0) sumMatrix[i][j] -= sumMatrix[i - 1][j - 1]; // remove double count
            }
        }
        
        return sumMatrix;
    }
}

