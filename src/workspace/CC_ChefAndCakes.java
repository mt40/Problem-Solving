package workspace;

import java.util.HashSet;
import java.util.Scanner;
import java.io.PrintWriter;

/**
 * Codechef - EGRCAKE
 */
public class CC_ChefAndCakes {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();

        long ans = 0;
        if(m == 0)
            ans = 1;
        else
            ans = lcm(n, m) / m;
        if(ans == n)
            out.println("Yes");
        else
            out.println("No " + ans);
    }

    long lcm(int x, int y) {
        return Math.abs(1l * x * y) / gcd(x, y);
    }

    int gcd(int x, int y) {
        return (y == 0) ? x : gcd(y, x % y);
    }
}
