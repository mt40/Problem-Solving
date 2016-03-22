package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_PARTIT {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int m = in.i(), n = in.i(), k = in.i();

        dp = new long[n+1][m+1][m+1];
        for(int i = 1; i <= m; ++i)
            dp[1][i][i] = 1;
        for(int len = 2; len <= n; ++len) {
            for(int i = 1; i <= m; ++i) {
                for(int sum = i; sum <= m; ++sum) {
                    for(int j = i; j <= m && sum - i >= j; ++j) {
                        dp[len][i][sum] += dp[len-1][j][sum-i];
                    }
                }
            }
        }

        ans = new ArrayList<>();
        boolean rs = false;
        for(int i = 1; i <= m && !rs; ++i) {
            rs = cal(n, i, m, k);
            k -= dp[n][i][m];
        }

        for(int i = ans.size() - 1; i >= 0; --i)
            out.print(ans.get(i) + " ");
        out.println();
    }

    List<Integer> ans;
    long [][][]dp;
    boolean cal(int len, int start, int curM, int k) {
        if(dp[len][start][curM] == 0)
            return false; // not possible
        else if(len == 1) {
            ans.add(start);
            return true;
        }
        for(int i = start; i <= curM; ++i) {
            if(dp[len-1][i][curM - start] >= k) {
                boolean rs = cal(len - 1, i, curM - start, k);
                if (rs) {
                    ans.add(start);
                    return true;
                }
            }
            k -= dp[len - 1][i][curM - start];
        }
        return false;
    }
}