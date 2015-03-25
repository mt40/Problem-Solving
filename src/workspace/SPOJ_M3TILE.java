package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class SPOJ_M3TILE {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = 30;
        long []dp = new long[n + 1];
        dp[0] = 1; dp[1] = 0; dp[2] = 3;

/**
 * Ý tưởng:
 * dp[i] = cách xếp của hình 3xi
 * p[i] = cách xếp hình 3xi mà bị mất 1 miếng 1x2
 * TH1:
 *      ==
 *      |   dp[i] = p[i - 1]
 * TH2
 *      |
 *      ==  như trên
 * TH3:
 *      ||  (tức cách xếp hoàn hảo cho 3x2)
 *      ==  dp[i] = dp[i - 2]
 * Total: dp[i] = dp[i - 2] + 2 * p[i] (1)
 * Xét p[i]:
 * TH1:
 *      ==  lắp thêm    . thì còn lại dp[i - 2]
 *      |               |
 * TH2:
 *      ==  lắp thêm    .   thì phải lắp thêm   == v còn lại p(i - 2)
 *      |   (2 1x2)     ==  1x2                 =
 *                      ==                      =
 * Total: p[i-1] = dp[i-2) + p[i - 3)
 * ==> dp[i] = 3 * dp[i - 2] + 2 * p[i-3]
 * Thay (1) (với i = i - 2) vào thì dc:
 * ==> dp[i] = 4 * dp[i - 2] - dp[i - 4]
 */
        for(int i = 3; i <= n; ++i) {
            if((i & 1) == 0) {
                dp[i] = dp[i - 2] * 4 - dp[i - 4];
            }
        }

        while(true) {
            int x = in.nextInt();
            if (x < 0) return;

            out.println(dp[x]);
        }
    }
}
