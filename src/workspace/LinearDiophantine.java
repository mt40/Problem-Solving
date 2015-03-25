package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class LinearDiophantine {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        extendedEuclid(a, b);

        out.println(x * c / d + " " + y * c / d);
    }

    int x, y, d;
    public void extendedEuclid(int a, int b) {
        if(b == 0) {
            x = 1;
            y = 0;
            d = a;
            return;
        }
        extendedEuclid(b, a % b);
        int x1 = y;
        int y1 = x - (a / b) * y;
        x = x1;
        y = y1;
    }
}
