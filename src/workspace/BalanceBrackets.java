package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class BalanceBrackets {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        if(n > 0 && (n & 1) == 0) {
            // out.println(catalanNumber(n / 2));
            out.println(recursion(n, 0, 0, ""));
        }
        else
            out.println(0);
    }

    // Catalan number method
    int catalanNumber(int n) {
        return combination(2 * n, n) / (n + 1);
    }

    int recursion(int n, int i, int sum, String s) {
        if(sum < 0) {
            return 0;
        }
        if(i == n) {
            if(sum == 0)
                return 1;
            return 0;
        }
        int ans = 0;
        ans += recursion(n, i + 1, sum - 1, s + "]");
        ans += recursion(n, i + 1, sum + 1, s + "[");
        return ans;
    }

    int combination(int n, int k) {
        float ans = 1;
        for(int i = 1; i <= k; ++i)
            ans *= (n - k + i) * 1.0 / i;
        return (int)ans;
    }
}
