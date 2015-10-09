package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class MinDifSubsets {
    /**
     * Given an array A. Divide A into 2 subsets such that
     * the difference of sums of those 2 is minimum
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        int total = sum(a);
        int []dp = new int[total + 1];
        for(int i = 0; i < n; ++i) {
            for(int j = total; j >= 0; --j) {
                if(dp[j] > 0 || j == 0) {
                    dp[j + a[i]] += 1;
                }
            }
        }

        int min = total;
        for(int i = 0; i <= total; ++i)
            if(dp[i] > 0 && dp[total - i] > 0)
                min = Math.min(min, Math.abs(i - (total - i)));
        out.println(min);
    }

    int sum(int []a) {
        int rs = 0;
        for(int i : a)
            rs += i;
        return rs;
    }
}
