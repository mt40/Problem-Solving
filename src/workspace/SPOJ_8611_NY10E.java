package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class SPOJ_8611_NY10E {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int p = in.nextInt();
        int []a = new int[p];
        for(int i = 0; i < p; ++i) {
            int tmp = in.nextInt();
            a[i] = in.nextInt();
        }

        long [][]dp = new long[10][65];
        for(int i = 0; i < 10; ++i)
            dp[i][1] = 1;

        for(int len = 2; len <= 64; ++len) {
            for(int i = 0; i <= 9; ++i) {
                for(int k = i; k < 10; ++k)
                    dp[i][len] += dp[k][len - 1];
            }
        }

        for(int i = 0; i < p; ++i) {
            int len = a[i];
            long ans = 0;
            for (int j = 0; j < 10; ++j)
                ans += dp[j][len];
            out.printf("%d %d\n", i + 1, ans);
        }
    }
}
