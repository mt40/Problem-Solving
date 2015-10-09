package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class SubsetSumToK {
    /**
     * Check if their is subset whose sum equals to K
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), k = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        boolean []dp = new boolean[sum(a) + 1];
        dp[0] = true;
        for(int i = 0; i < n; ++i) {
            for(int j = dp.length - 1; j >= 0; --j)
                if(dp[j])
                    dp[j + a[i]] = true;
        }

        out.println(dp[k]);
    }

    int sum(int []a) {
        int rs = 0;
        for(int i : a)
            rs += i;
        return rs;
    }
}
