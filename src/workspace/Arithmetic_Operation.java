package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

/**
 * implement arithmetic operation without arithmetic operator ^_^
 */
public class Arithmetic_Operation {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();

        out.println(add(a, b));
        out.println(subtract(a, b));
    }

    int add(int x, int y) {
        /**
         * Tức là đầu tiên sẽ dùng XOR để cộng ko có carry
         * Các iter sau đó là dể cộng x với lại carry mà thôi
         */

        // loop until no more carry
        while(y != 0) {
            // common set bits of x and y
            int carry = x & y;
            // addition without carry
            x = x ^ y;
            // carry is shifted because it will be added for the next number
            y = carry << 1;
        }

        return x;
    }

    // recursive version
    int addRec(int x, int y) {
        if(y == 0)
            return x;
        return addRec(x ^ y, (x & y) << 1);
    }

    int subtract(int x, int y) {
        // 2nd complement of y
        y = add(~y, 1);
        return add(x, y);
    }
}
