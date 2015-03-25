package workspace;

import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class SPOJ_3033_SOLDIER {
    int n, cash;
    ii [][]data;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        n = in.nextInt();
        cash = in.nextInt();

        data = new ii[7][n];
        int []cnt = {0, 0, 0, 0, 0, 0, 0};
        for(int i = 0; i < n; ++i) {
            int t = in.nextInt();
            data[t][cnt[t]++] = new ii(in.nextInt(), in.nextInt());
        }

        out.println(solve());
    }

    int solve() {
        int [][]dp = new int[cash + 1][6 + 1];

        for(int i = 0; i < data[1].length; ++i)
            if(data[1][i] != null)
                dp[cash - data[1][i].p][1] = data[1][i].q;

        for(int j = 2; j <= 6; ++j) {
            for(int i = 1; i <= cash; ++i) {
                if(dp[i][j - 1] > 0) {
                    for(int k = 0; k < n; ++k) {
                        if(data[j][k] == null) break;
                        int price = data[j][k].p, qlt = data[j][k].q;
                        if(i - price >= 0)
                            dp[i - price][j] = Math.min(dp[i][j - 1], qlt);
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i <= cash; ++i) {
            if(dp[i][6] > 0 && dp[i][6] < ans)
                ans = dp[i][6];
        }
        if(ans == Integer.MAX_VALUE)
            return 0;
        return ans;
    }

    class ii {
        int p, q;
        public ii(int a, int b) {this.p = a; this.q = b;}
    }
}
