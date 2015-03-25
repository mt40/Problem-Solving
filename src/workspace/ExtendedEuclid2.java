package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class ExtendedEuclid2 {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();

        Num x = new Num(0), y = new Num(0);
        int g = gcd(a, b, x, y);
        out.printf("solution of %d.x + %d.y = gcd(x,y) is:\nx=%d y=%d gcd=%d",
                a, b, x.val, y.val, g);
    }

    int gcd(int a, int b, Num x, Num y) {
        if(a == 0) {
            x.val = 0;
            y.val = 1;
            return b;
        }
        Num x1 = new Num(0), y1 = new Num(0);
        int g = gcd(b % a, a, x1, y1);
        x.val = y1.val - (b/a) * x1.val;
        y.val = x1.val;
        return g;
    }

    class Num {
        public int val;

        public Num(int val) {
            this.val = val;
        }
    }
}
