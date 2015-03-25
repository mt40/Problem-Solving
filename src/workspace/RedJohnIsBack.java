package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class RedJohnIsBack {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        int []dp = new int[n + 1];
        // dp[0] = dp[1] = dp[2] = dp[3] = 1
        for(int i = 0; i <= n && i <= 3; ++i)
            dp[i] = 1;

        // if we choose the brick 4-1 then it is the smaller problem which n = n - 1
        // if we choose the brick 1-4, we have to put below it 3 other 1-4 bricks
        // --> n - 4
        for(int i = 4; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 4];
        }

        out.println(sieve(dp[n]));
    }

    // sieve of Eratosthenes
    public int sieve(int n) {
        boolean []prime = new boolean[n + 1];
        for(int i = 2; i <= n; ++i) {
            if(prime[i] == false)
                for(int j = 2; i * j <= n; ++j)
                    prime[i * j] = true;
        }

        //remaining false cells is prime
        int count = 0;
        for(int i = 2; i <= n; ++i)
            if(prime[i] == false)
                count++;
        return count;
    }
}
