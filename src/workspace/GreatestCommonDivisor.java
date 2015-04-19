package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class GreatestCommonDivisor {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();

        out.printf("subtraction method: %d\n", gcd1(a, b));
        out.printf("modular method: %d\n", gcd2(a, b));
    }

    // subtraction method
    int gcd1(int a, int b) {
        while(a != b) {
            if(a > b)
                a -= b;
            else
                b -= a;
        }
        return a;
    }

    // modular method
    int gcd2(int a, int b) {
        return b == 0 ? a : gcd2(b, a % b);
    }
}
