package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class FastPerfectSquareCheck {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int h = n & 0xf;

        /**
         * perfect square can only end with 0, 1, 4, or 9 in base 16
         * proved by induction
         */
        switch (h) {
            case 0:case 1:case 4:case 9:
                long sqrt = (long)Math.sqrt(n);
                out.println(sqrt * sqrt == n);
                break;
            default:
                out.println(false);
        }
    }
}
