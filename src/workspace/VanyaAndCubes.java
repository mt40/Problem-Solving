package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class VanyaAndCubes {
    public int N;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        N = in.nextInt();

        out.println(dp());
    }

    public int dp() {
        int []memo = new int[N];
        memo[0] = 1;
        for(int i = 1; i < N; ++i) {
            int total = ((i + 1) * ((i + 1) + 1)) / 2;
            memo[i] += total + memo[i - 1];
            if(memo[i] > N) {
                return i;
            }
        }
        return 1;
    }
}
