package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class SPOJ_ASSIGN {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int [][]like = new int[n][n];
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < n; ++j)
                like[i][j] = in.nextInt();

        int N_MAX = 1 << n;
        int [][]dp = new int[n][N_MAX];


    }
}
