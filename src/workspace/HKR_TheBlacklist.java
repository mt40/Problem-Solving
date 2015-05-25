package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class HKR_TheBlacklist {
    final int INF = 100000000;
    int [][]cul;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int [][]a = new int[k][n];
        for(int i = 0; i < k; ++i)
            for(int j = 0; j < n; ++j)
                a[i][j] = in.nextInt();

        cul = new int[k][n];
        for(int i = 0; i < k; ++i) {
            for(int j = 0; j < n; ++j) {
                cul[i][j] = a[i][j];
                if(j > 0)
                    cul[i][j] += cul[i][j - 1];
            }
        }

        int lim = 1 << k;
        int [][]dp = new int[n + 1][lim];
        // base case
        for(int i = 0; i <= n; ++i)
            Arrays.fill(dp[i], INF);
        Arrays.fill(dp[0], 0);

        for(int i = 1; i <= n; ++i) {
            for(int m = 1; m < lim; ++m) { // mask
                for(int j = 0; j < k; ++j) {
                    if(isSet(m, j)) {
                        for(int mid = 1; mid <= i; ++mid) {
                            int no_j = without(m, j);
                            int cost_j = cost(j, mid - 1, i - 1);
                            int val = cost_j + dp[mid - 1][no_j];
                            dp[i][m] = Math.min(dp[i][m], val);
                        }
                    }
                }
            }
        }

//        for(int i = 1; i <= n; ++i)
//            System.out.println(Arrays.toString(dp[i]));

        int ans = INF;
        for(int i = 0; i < lim; ++i)
            ans = Math.min(dp[n][i], ans);
        out.println(ans);
    }

    int cost(int j, int l, int r) {
        if(l == 0)
            return cul[j][r];
        return cul[j][r] - cul[j][l - 1];
    }

    boolean isSet(int num, int i) {
        boolean rs = (num & (1 << i)) > 0;
        return rs;
    }

    // mask with bit i = 0
    int without(int mask, int i) {
        int rs = mask & (~(1 << i));
        return rs;
    }
}
