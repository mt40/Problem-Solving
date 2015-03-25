package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class DivisibleBy7 {
    // Test if a number is divisible by 7 without modulo
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        // Idea: nếu 1 số có dạng 10x + y chia hết cho 7
        // thì số x - 2y cũng chia hết cho 7
        out.println(isDivisibleBy7(n) ? "YES" : "NO");
    }

    boolean isDivisibleBy7(int x) {
        if(x < 0)
            x *= -1;
        // base case
        if(x == 0 || x == 7)
            return true;
        else if(x < 7)
            return false;
        else return isDivisibleBy7(x / 10 - 2 * (x % 10));
    }
}
