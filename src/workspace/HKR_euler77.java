package workspace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class HKR_euler77 {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int t = in.nextInt();
        List<Integer> primes = getPrimes();
        int m = primes.size();

        while(t-- > 0) {
            int n = in.nextInt();
            long [][]dp = new long[n + 1][m];
            Arrays.fill(dp[0], 1l);
            for(int i = 1; i <= n; ++i) {
                for(int j = 0; j < m; ++j) {
                    // use the jth prime
                    long x = (i - primes.get(j) >= 0) ? dp[i - primes.get(j)][j] : 0;
                    // not use the jth prime
                    long y = (j > 0) ? dp[i][j - 1] : 0;
                    dp[i][j] = x + y;
                }
            }

            out.println(dp[n][m - 1]);
        }
    }

    List<Integer> getPrimes() {
        boolean []num = new boolean[1001];
        Arrays.fill(num, true);
        num[0] = num[1] = false;
        for(int i = 2; i <= 1000; ++i) {
            if(num[i] == true) {
                int k = 2;
                while(i * k <= 1000) {
                    num[i * k] = false;
                    k++;
                }
            }
        }

        List<Integer> rs = new ArrayList<Integer>();
        for(int i = 0; i < num.length; ++i) {
            if(num[i] == true)
                rs.add(i);
        }

        return rs;
    }
}
