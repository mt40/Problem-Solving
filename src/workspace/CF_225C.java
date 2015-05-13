package workspace;

import helperClasses.InputReader;

import java.io.PrintWriter;
import java.util.Arrays;

public class CF_225C {
    final int INF = Integer.MAX_VALUE;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();

        char[][] a = new char[n + 1][m + 1];
        for (int i = 1; i <= n; ++i) {
            char[] cc = in.next().toCharArray();
            for (int j = 0; j < m; ++j)
                a[i][j + 1] = cc[j];
        }

        int[] whites = new int[m + 1];
        int[] blacks = new int[m + 1];
        for (int j = 1; j <= m; ++j) {
            for (int i = 1; i <= n; ++i)
                whites[j] += a[i][j] == '.' ? 1 : 0;
            whites[j] += whites[j - 1];
            blacks[j] = n * j - whites[j];
        }

        /**
         * dp[i, j] = số pixel nhỏ nhất phải sơn lại từ 0 -> j và
         * màu của cột cuối cùng là i (0=white, 1=black)
         * Vậy ta có thể tô 1 lúc k cột cùng 1 màu (x <= k <= y)
         * và trước đó phải tô màu khác
         */
        int[][] dp = new int[2][m + 1];
        Arrays.fill(dp[0], INF);
        Arrays.fill(dp[1], INF);
        dp[0][0] = dp[1][0] = 0;

        for (int j = 1; j <= m; ++j) {
            for (int k = x; k <= y && j - k >= 0; ++k) {
                if (dp[1][j - k] < INF)
                    dp[0][j] = Math.min(dp[1][j - k] + count(blacks, j - k + 1, j), dp[0][j]);
                if (dp[0][j - k] < INF)
                    dp[1][j] = Math.min(dp[0][j - k] + count(whites, j - k + 1, j), dp[1][j]);
            }
        }

        out.println(Math.min(dp[0][m], dp[1][m]));

//        System.out.println("white: " + Arrays.toString(dp[0]));
//        System.out.println("black: " + Arrays.toString(dp[1]));
    }

    int count(int[] arr, int l, int r) {
        return arr[r] - arr[l - 1];
    }

}
