package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class EfficientGCD {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a = in.nextInt(), b = in.nextInt();
        MyInt c1 = new MyInt(), c2 = new MyInt(), c3 = new MyInt();

        /**
         * When the modulo operation is expensive, we have to use the
         * subtraction GCD. The problem is the subtraction GCD can
         * run in the worst case (linear time) when a or b is much larger
         * than the other (test case 3).
         * --> We need an efficient version of it
         */
        out.printf("GCD of %d and %d\n", a, b);
        out.printf("Subtraction version: %d (%d operations)\n", sub(a, b, c1), c1.val);
        out.printf("Modulo version: %d (%d operations)\n", mod(a, b, c2), c2.val);
        out.printf("Efficient version: %d (%d operations)\n\n", efficient(a, b, c3), c3.val);
    }

    /**
     * In case modulo is expensive to do, we can improve the
     * subtraction GCD to be more efficient
     */
    int efficient(int a, int b, MyInt cnt) {
        cnt.val++;
        // base case
        if(a == b || b == 0) return a;
        if(a == 0) return b;

        // if a & b are even
        if((a & 1) == 0 && (b & 1) == 0)
            return 2 * efficient(a >> 1, b >> 1, cnt);

        // if a is even
        if((a & 1) == 0)
            return efficient(a >> 1, b, cnt);

        // if b is even
        if((b & 1) == 0)
            return efficient(a, b >> 1, cnt);

        return (a > b)? efficient(a - b, b, cnt) : efficient(b, b - a, cnt);
    }

    /**
     * GCD subtraction version
     */
    int sub(int a, int b, MyInt cnt) {
        cnt.val++;
        if(a == b)
            return a;
        return (a > b)? sub(a - b, b, cnt) : sub(a, b - a, cnt);
    }

    /**
     * GCD modulo version
     */
    int mod(int a, int b, MyInt cnt) {
        cnt.val++;
        if(a == 0)
            return b;
        return mod(b % a, a, cnt);
    }

    class MyInt {
        int val = 0;
    }
}
