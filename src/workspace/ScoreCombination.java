package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class ScoreCombination {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        int []pool = new int[n];
        for(int i = 0; i < n; ++i)
            pool[i] = in.nextInt();

        while(m-- > 0) {
            int score = in.nextInt();
            int []dp = new int[score + 1];
            dp[0] = 1; // 1 way to reach score 0
            for(int i = 1; i <= score; ++i) {
                for(int s : pool) {
                    if(s <= i) {
                        dp[i] += dp[i - s];
                    }
                }
            }
            out.println(dp[score]);
        }
    }
}
