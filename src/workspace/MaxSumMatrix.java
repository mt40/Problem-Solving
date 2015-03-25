package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class MaxSumMatrix {
    int N, M, maxPosX, maxPosY;
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

//        for(int i = 0; i < N; ++i) {
//            for(int j = 0; j < M; ++j) {
//                out.print(sumMatrix[i][j] + " ");
//            }
//            out.println("");
//        }
        int ans = sumMatrix[maxPosX][maxPosY], mark = -1; // Greedy

        for(int j = maxPosY - 1; j >= 0; --j) {
            if(sumMatrix[maxPosX][j] < 0) {
                ans -= sumMatrix[maxPosX][j]; // remove the left negative sum
                mark = j;
                break;
            }
        }
        for(int i = maxPosX - 1; i >= 0; --i) {
            if(sumMatrix[i][maxPosY] < 0) {
                ans -= sumMatrix[i][maxPosY]; // remove the upper negative sum
                if(mark >= 0)
                    ans += sumMatrix[i][mark];
                break;
            }
        }

        out.println(ans);
    }

    public int[][] genSumMatrix() {
        int [][] sumMatrix = new int[N + 3][M + 3];
        //copy
        for(int i = 0; i < N; ++i)
            for(int j = 0; j < M; ++j)
                sumMatrix[i][j] = arr[i][j];

        for(int i = 0; i < N; ++i) {
            for(int j = 0; j < M; ++j) {
                if(i > 0) sumMatrix[i][j] += sumMatrix[i - 1][j]; // upper matrix
                if(j > 0) sumMatrix[i][j] += sumMatrix[i][j - 1]; // left matrix
                if(i > 0 && j > 0) sumMatrix[i][j] -= sumMatrix[i - 1][j - 1]; // remove double count

                if(sumMatrix[i][j] > sumMatrix[maxPosX][maxPosY]) { // save this to perform Greedy
                    maxPosX = i;
                    maxPosY = j;
                }
            }
        }
        return sumMatrix;
    }
}
