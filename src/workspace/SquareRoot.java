package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class SquareRoot {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        out.printf("Java library: %.5f\n", Math.sqrt(n));
        out.printf("Newton's method: %.5f\n", Newton(n));
        out.printf("Binary search: %.5f\n", bin(n));
    }

    double Newton(double n) {
        double x0 = n / 2, prev = 0;
        while(Math.abs(prev - x0) > 10e-6) {
            prev = x0;
            x0 = x0 / 2 + n / 2 / x0;
        }
        return x0;
    }

    double bin(double n) {
        double e = 10e-6;
        double low = 0, hi = n / 2;
        while(hi - low > e) {
            double mid = low + (hi - low) / 2;
            if(mid * mid > n)
                hi = mid;
            else
                low = mid;
        }
        return low;
    }
}
