package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class CF_189A {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        int []dp = new int[n + 1];
        dp[0] = 0;
        for(int i = 0; i <= n; ++i) {
            if(dp[i] > 0 || i == 0) {
                if(i + a <= n)
                    dp[i + a] = Math.max(dp[i + a], dp[i] + 1);
                if(i + b <= n)
                    dp[i + b] = Math.max(dp[i + b], dp[i] + 1);
                if(i + c <= n)
                    dp[i + c] = Math.max(dp[i + c], dp[i] + 1);
            }
        }

        out.println(dp[n]);
        //out.println(Arrays.toString(dp));
    }
}
