package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_629C {
    int inf = Integer.MAX_VALUE;
    final int mod = 1000*1000*1000+7;
    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), m = in.i();
        char []a = in.c();

        int len = n - m;
        long [][]dp = new long[len + 1][]; // avoid memory limit
        dp[0] = new long[1];
        dp[0][0] = 1;
        for(int i = 1; i <= len; ++i) {
            dp[i] = new long[i+1];
            for(int j = 0; j <= i; ++j) {
                if(j - 1 >= 0)
                    dp[i][j] = dp[i-1][j-1]; // case '('
                if(j + 1 <= i - 1)
                    dp[i][j] = (dp[i][j] + dp[i-1][j+1]) % mod; // case ')'
            }
        }

        int open = 0, close = 0;
        for(char ai : a) {
            if(ai == ')') {
                if(open == 0)
                    close++;
                else
                    open--;
            }
            else
                open++;
        }

        //for(long []dpi : dp) out.println(Arrays.toString(dpi));
        long ans = 0;
        for(int i = 0; i <= len; ++i) {
            for(int j = close; j <= i; ++j) {
                int rem = j - close + open;
                if(0 <= rem && rem <= len - i)
                    ans = (ans + (dp[i][j] * dp[len - i][rem]) % mod) % mod;
            }
        }

        out.println(ans);
    }
}