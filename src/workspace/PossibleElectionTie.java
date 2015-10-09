package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class PossibleElectionTie {
    /**
     * Cho list các s?, tìm xem có th? chia các s? này thành 2 nhóm
     * mà sum c?a 2 nhóm là = nhau
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
        }
        int total = sum(a);
        if((total & 1) > 0) { // sum is odd
            out.println("No tie!");
            return;
        }
        int [][]dp = new int[n][total + 1];
        dp[0][0] = 1;
        for(int i = 0; i < n - 1; ++i) {
            for(int j = 0; j < total; ++j) {
                if(j >= a[i])
                    dp[i + 1][j] = dp[i][j - a[i]] + dp[i][j];
                else
                    dp[i + 1][j] = dp[i][j];
            }
        }

        // print
        for(int i = 0; i < n; ++i) {
            System.out.println(Arrays.toString(dp[i]));
        }

        out.println(dp[n - 1][total >> 1]);
    }

    int sum(int []a) {
        int rs = 0;
        for(int x : a)
            rs += x;
        return rs;
    }
}
